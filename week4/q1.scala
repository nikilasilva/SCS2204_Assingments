object retailStore {
    var item: Array[String] = Array("Biscuit", "Sugar", "Rice", "Milk")
    var quantity: Array[Int] = Array(10, 12, 5, 6)

    def displayInventory():Unit = {
        println("_____Inventory_____")
        for (i <- 0 until item.length) {
            println(f"Item name: ${item(i)} -> quantity: ${quantity(i)}");
        }
    }

    def restockItem(itemName:String, quantityVal:Int):Unit = {
        var fItem:Boolean = false;

        for (i <- 0 until item.length) {
            if(itemName == item(i)) {
                quantity(i) += quantityVal;
                println("Item restocked sucessfully");
                fItem = true;
            }
            if (fItem == false) {
                println("Item not found");
            }
        }
    }

    def sellItem(itemName:String, quantityVal:Int): Unit = {
        var fItem:Boolean = false;
        for (i <- 0 until item.length) {
            if (itemName == item(i)) {
                fItem = true;
                if (quantityVal <= quantity(i)) {
                    quantity(i) -= quantityVal;
                    println("Stock updated");
                }
                else {
                    println("Not enough quantity");
                }
            }
        }
        if (fItem == false) {
            println("Item not found");
        }
    }

    def main(args: Array[String]): Unit = {
        println("Current Inventory\n");
        displayInventory();
        restockItem("Biscuit", 10);
        println("\nInventory after add 10 biscuits");
        displayInventory();
        sellItem("Biscuit", 4);
        println("\nAfter selling 4 biscuits");
        displayInventory();
    }
}