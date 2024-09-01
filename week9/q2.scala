object w9q2 {

    class Rational(n: Int, d: Int) {
        require(d != 0, "Denominator cannot be zero")

        // Calculate the gcd to simplify the fraction
        private val gcd = gcdFunction(n.abs, d.abs)
        val numerator: Int = n / gcd
        val denominator: Int = d / gcd

        // Ensure that the denominator is always positive
        def this(n: Int) = this(n, 1)
        def neg: Rational = new Rational(-numerator, denominator)

        // Method to subtract another rational number 
        def sub(that: Rational): Rational = {
            val newNumerator = this.numerator * that.denominator - that.numerator * this.denominator
            val newDenominator = this.denominator * that.denominator
            new Rational(newNumerator, newDenominator)
        }

        // String representation for easy display
        override def toString: String = s"$numerator/$denominator"

        // gcd function
        private def gcdFunction(a:Int, b:Int): Int = {
            if (b == 0) a else gcdFunction(b, a%b)
        }
    }

    def main(args: Array[String]): Unit = {
        val x = new Rational(3, 4)
        val y = new Rational(5, 8)
        println(s"first rational number: ${x}")
        println(s"second rational number: ${y}")
        val result = x.sub(y)
        println(result)
    }

}