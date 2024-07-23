object D5Q1{
    def getproductList() : List[String] = {
        import scala.io.StdIn.readLine;
        var productList : List[String] = List();
        var product : String = "";
        println("Enter the products in the inventory (type 'done' to stop)");
        while(product != "done"){
            product = readLine();
            if(product != "done"){
                productList = productList :+ product;
            }
        }
        return productList;
    }

    def printProductList(productList : List[String]) : Unit = {
        println("Items in the Inventory");
        for(i <- 0 to productList.length-1){
            println((i+1) + " - " + productList(i));
        }
    }

    def getTotalProducts(productList : List[String]) : Int = {
        return productList.length;
    }

    def main(args: Array[String]) : Unit = {
        var productList : List[String] = getproductList();
        printProductList(productList);
        println("Total products in the inventory: " + getTotalProducts(productList));
    }
}