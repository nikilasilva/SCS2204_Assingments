object D2Q3 {
    def main(arg: Array[String]): Unit = {
        println("Weekly income of person who works 40 normal hours and 30 OT = "+ income(40, 30))
    }

    def normalIncome(h:Int): Int = h * 250 
    def OTIncome(h:Int): Int = h * 85
    def income(nHours:Int, otHours:Int): Int = normalIncome(nHours) + OTIncome(otHours)
    def tax(fullIncome:Int):Double = fullIncome + 0.12

    def takeHome(normalHours:Int, otHours:Int):Double = {
        return income(normalHours, otHours) - tax(income(normalHours, otHours))
    }
}



