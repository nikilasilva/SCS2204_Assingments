object D2Q4 {
    def main(args: Array[String]): Unit = {
        println("Profit for 5: "+ profit(5))
        println("Profit for 10: "+ profit(10))
        println("Profit for 15: "+ profit(15))
        println("Profit for 20: "+ profit(20))
        println("Profit for 25: "+ profit(25))

    }

    def attendees(price:Int):Int = 120 + (15-price)/5*20
    def revenue(price:Int):Int = attendees(price) * price
    def cost(price:Int):Int = 500 + attendees(price)
    def profit(price:Int):Int = revenue(price) - cost(price)
}