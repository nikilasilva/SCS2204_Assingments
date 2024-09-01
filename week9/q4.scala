object w9q3 {
    class Account(private var balance: Double) {
        // deposit money
        def deposit(amount: Double): Unit = {
            require(amount > 0, "Deposit amount must be positive")
            balance += amount
        }

        // withdraw money
        def withdraw(amount: Double): Unit = {
            require(amount > 0, "Withdrawal amount must be positive")
            if (amount > balance) {
                println("Insufficient balance")
            }
            else {
                balance -= amount
            }
        }

        // transfer money
        def transfer(amount: Double, toAcc: Account): Unit = {
            require(amount > 0, "Transfer amount must be positive")
            if (amount > balance) {
                println("Insufficient balance")
            }
            else {
                this.withdraw(amount)
                toAcc.deposit(amount)
            }
        }

        def applyInterest(): Unit = {
            if (balance > 0) deposit(balance * 0.05)
            else withdraw(balance * -0.10)
        }

        def getBalance: Double = balance

        override def toString: String = f"Account Balance: $$${balance}%.2f"
    }

    class Bank(var accounts: List[Account]) {
        def accountsWithNegBalance: List[Account] = {
            accounts.filter(_.getBalance < 0)
        }

        def totalBalance: Double = {
            accounts.map(_.getBalance).sum
        }

        def applyInterestToAll(): Unit = {
            accounts.foreach(_.applyInterest())
        }

        def displayAccounts(): Unit = {
            accounts.foreach(println)
        }
    }


    def main(args: Array[String]): Unit = {
        val acc1 = new Account(1000.0)
        val acc2 = new Account(500.0)
        val acc3 = new Account(-200.0)
        println(s"Account 1: ${acc1}")
        println(s"Account 2: ${acc2}")
        println(s"Account 3: ${acc3}\n")

        val bank = new Bank(List(acc1, acc2, acc3))

        val negativeAccounts = bank.accountsWithNegBalance
        println("Accounts with negative balance: ")
        negativeAccounts.foreach(println)


        val total = bank.totalBalance
        println(s"Total Balance of all accounts: $$${total}")

        bank.applyInterestToAll()
        println("Final Balances after applying interest:")
        bank.displayAccounts()
    }
}