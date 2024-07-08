object D3Q4 {
    def main(args: Array[String]): Unit = {   
        printf(f"Enter list of integers :\n")
        // Input list of integers seperated by commas.
        val userInput=scala.io.StdIn.readLine()
        val nums=userInput.split(" ").map(_.toInt).toList

        printf(f"The sum of even numbers : ${sum(nums)}")

        def sum(integers :List[Int]):Int = {
                integers.filter(_%2==0).sum
            }
    }
}