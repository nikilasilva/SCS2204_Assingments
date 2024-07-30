import scala.io.StdIn._

object D6Q2 {

  // Function to validate input
  def validateInput(name: String, marks: Int, totalMarks: Int): (Boolean, Option[String]) = {
    if (name.isEmpty) {
      (false, Some("Name cannot be empty"))
    } else if (marks < 0 || marks > totalMarks) {
      (false, Some("Marks must be between 0 and the total possible marks"))
    } else {
      (true, None)
    }
  }

  // Function to calculate percentage and grade
  def calculatePercentageAndGrade(marks: Int, totalMarks: Int): (Double, Char) = {
    val percentage = (marks.toDouble / totalMarks) * 100
    val grade = percentage match {
      case p if p >= 90 => 'A'
      case p if p >= 75 => 'B'
      case p if p >= 50 => 'C'
      case _ => 'D'
    }
    (percentage, grade)
  }

  // Function to read student info with retry until valid data is provided
  def getStudentInfoWithRetry(): (String, Int, Int, Double, Char) = {
    var isValid = false
    var name = ""
    var marks = 0
    var totalMarks = 0
    var percentage = 0.0
    var grade = 'D'

    while (!isValid) {
      println("Enter student name:")
      name = readLine()
      println("Enter marks:")
      marks = readInt()
      println("Enter total possible marks:")
      totalMarks = readInt()

      val (valid, errorMessage) = validateInput(name, marks, totalMarks)
      if (valid) {
        val (calculatedPercentage, calculatedGrade) = calculatePercentageAndGrade(marks, totalMarks)
        percentage = calculatedPercentage
        grade = calculatedGrade
        isValid = true
      } else {
        println(s"Invalid input: ${errorMessage.getOrElse("Unknown error")}. Please try again.")
      }
    }

    (name, marks, totalMarks, percentage, grade)
  }

  // Function to print student record
  def printStudentRecord(studentRecord: (String, Int, Int, Double, Char)): Unit = {
    val (name, marks, totalMarks, percentage, grade) = studentRecord
    println(s"Student Name: $name")
    println(s"Marks: $marks/$totalMarks")
    println(f"Percentage: $percentage%.2f%%")
    println(s"Grade: $grade")
  }

  def main(args: Array[String]): Unit = {
    val studentInfo = getStudentInfoWithRetry()
    printStudentRecord(studentInfo)
  }
}
