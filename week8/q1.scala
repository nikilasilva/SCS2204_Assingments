import scala.io.StdIn.readLine

object CaesarCipher {

  // Function to encrypt the text using Caesar cipher
  def encrypt(text: String, shift: Int): String = {
    text.map { char =>
      if (char.isLetter) {
        val base = if (char.isUpper) 'A' else 'a'
        (((char - base + shift)%26 + 26) % 26 + base).toChar 
      } else {
        char
      }
    }
  }

  // Function to decrypt the text using Caesar cipher
  def decrypt(text: String, shift: Int): String = {
    encrypt(text, 26 - (shift % 26))  // Decryption is simply encryption with the inverse shift
  }

  // General Cipher function that takes an encryption or decryption function and processes the data
  def cipher(text: String, shift: Int, operation: (String, Int) => String): String = {
    operation(text, shift)
  }

  def main(args: Array[String]): Unit = {

    println("Enter text: ")
    val plaintext = readLine()

    println("Enter shift value: ")
    val shift = readLine().toInt

    // Encrypting the plaintext
    val encryptedText = cipher(plaintext, shift, encrypt)
    println(s"Encrypted Text: $encryptedText")

    // Decrypting the encrypted text
    val decryptedText = cipher(encryptedText, shift, decrypt)
    println(s"Decrypted Text: $decryptedText")
  }
}
