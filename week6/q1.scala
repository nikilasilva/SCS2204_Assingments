object D6Q1 {

  // Define a case class to represent a product
  case class Product(id: Int, name: String, quantity: Int, price: Double)

  // Sample inventories
  val inventory1: Map[Int, Product] = Map(
    101 -> Product(101, "Product A", 10, 15.0),
    102 -> Product(102, "Product B", 5, 20.0),
    103 -> Product(103, "Product C", 8, 12.0)
  )

  val inventory2: Map[Int, Product] = Map(
    102 -> Product(102, "Product B", 3, 25.0),
    104 -> Product(104, "Product D", 7, 18.0)
  )

  // Retrieve all product names from inventory1
  def getProductNames(inventory: Map[Int, Product]): List[String] = {
    inventory.values.map(_.name).toList
  }

  // Calculate the total value of all products in inventory1
  def getTotalValue(inventory: Map[Int, Product]): Double = {
    inventory.values.map(product => product.quantity * product.price).sum
  }

  // Check if inventory1 is empty
  def isInventoryEmpty(inventory: Map[Int, Product]): Boolean = {
    inventory.isEmpty
  }

  // Merge inventory1 and inventory2, updating quantities and retaining the highest price
  def mergeInventories(inventory1: Map[Int, Product], inventory2: Map[Int, Product]): Map[Int, Product] = {
    inventory2.foldLeft(inventory1) { case (acc, (id, product)) =>
      acc.get(id) match {
        case Some(existingProduct) =>
          val updatedProduct = existingProduct.copy(
            quantity = existingProduct.quantity + product.quantity,
            price = math.max(existingProduct.price, product.price)
          )
          acc + (id -> updatedProduct)
        case None =>
          acc + (id -> product)
      }
    }
  }

  // Check if a product with a specific ID exists and print its details
  def checkAndPrintProductDetails(inventory: Map[Int, Product], id: Int): Unit = {
    inventory.get(id) match {
      case Some(product) => println(s"Product details: $product")
      case None => println(s"Product with ID $id does not exist.")
    }
  }

  def main(args: Array[String]): Unit = {
    // Retrieve all product names from inventory1
    println("Product Names: " + getProductNames(inventory1))

    // Calculate the total value of all products in inventory1
    println("Total Value: " + getTotalValue(inventory1))

    // heck if inventory1 is empty
    println("Is Inventory Empty: " + isInventoryEmpty(inventory1))

    // Merge inventory1 and inventory2
    val mergedInventory = mergeInventories(inventory1, inventory2)
    println("Merged Inventory: " + mergedInventory)

    // Check if product with ID 102 exists in inventory1 and print its details
    checkAndPrintProductDetails(inventory1, 102)
  }
}
