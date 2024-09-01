object w9q3 {
    class Account(private var balance: Double) {
        require(balance >= 0, "Initial balance cannot be negative")

        // deposit money
        def deposit(amount: Double): Unit = {
            require(amount > 0, "Deposit amount must be positive")
            balance += amount
            println(s"Deposited: $$${amount}, New Balance: $$${balance}")
        }

        // withdraw money
        def withdraw(amount: Double): Unit = {
            require(amount > 0, "Withdrawal amount must be positive")
            if (amount > balance) {
                println("Insufficient balance")
            }
            else {
                balance -= amount
                println(s"Withdrew: $$${amount}, New balance: $$${balance}")
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
                println(s"Transferred: $$${amount} to another account")
            }
        }

        def getBalance: Double = balance

        override def toString: String = f"Account Balance: $$${balance}%.2f"
    }

    def main(args: Array[String]): Unit = {
        val acc1 = new Account(1000.0)
        val acc2 = new Account(500.0)
        println(s"Account 1: ${acc1}")
        println(s"Account 2: ${acc2}\n")

        acc2.deposit(200.0)
        acc1.withdraw(100.0)
        acc1.transfer(400.0, acc2)

        println(s"Account 1: ${acc1}")
        println(s"Account 2: ${acc2}")
    }
}