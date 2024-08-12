object NumberCategorizer {
  def main(args: Array[String]): Unit = {
    // Check if the user provided an input
    if (args.isEmpty) {
      println("Please provide an integer input.")
    } else {
      try {
        // Convert the input to an integer
        val input = args(0).toInt

        // Define the pattern matching using lambda functions
        val result = (input: Int) => input match {
          case x if x % 3 == 0 && x % 5 == 0 => "Multiple of Both Three and Five"
          case x if x % 3 == 0               => "Multiple of Three"
          case x if x % 5 == 0               => "Multiple of Five"
          case _                             => "Not a Multiple of Three or Five"
        }

        // Print the result of the pattern matching
        println(result(input))
      } catch {
        case _: NumberFormatException =>
          println("Please provide a valid integer input.")
      }
    }
  }
}
