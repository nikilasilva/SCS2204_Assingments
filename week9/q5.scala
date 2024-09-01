object w9q5 {
    def countLetterOccurrences(words: List[String]): Int = {
        val lengths = words.map(word => word.length)    
        val totalCount = lengths.reduce((a, b) => a + b)    
        return totalCount
    }

    def main(args: Array[String]): Unit = {
        val words = List("apple", "banana", "cherry", "date")
        val totalLetters = countLetterOccurrences(words)
        println(s"Total count of letter occurrences: $totalLetters")
    }
}