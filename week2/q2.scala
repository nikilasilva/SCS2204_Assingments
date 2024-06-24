object D2Q2 {
    def main(arg: Array[String]): Unit = {
        var a:Int = 2
        var b:Int = 3
        var c:Int = 4
        var d:Int = 5
        var k:Double = 4.3f
        
        b -= 1
        println("--b * a + c * d-- = " + b * a + c * d)
        d -= d
        a += 1
        println("a++ = " + a)

        println("-2 * (d - k) + c = " + -2*(d-k) + c)

        c += 1
        println("c=c++" + c)
        c += 1
        println("c=++c*a++" + c*a)
        a += 1


    }
}