object D2Q1 {
    def main(arg: Array[String]):Unit ={
        var k, i, j = 2
        var m, n = 5
        var f = 12.0f
        var g = 4.0f
        var c = 'X'

        printf("k + 12 * m = %d\n", k+12*m)
        printf("m / j = %d\n", m / j)
        printf("n %% j = %d\n", math.abs(n % j))
        printf("m / j * j = %d\n", m/j*j)
        printf("f + 10*5 + g = %.3f\n", f+10*5+g)
        i += 1
        printf("++i * n = %d\n", i * n)
    }
}