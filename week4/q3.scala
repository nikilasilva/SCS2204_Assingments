object D4Q3{
    
    def toUpper(name: String): String = {
        return name.toUpperCase
    }

    def toLower(name: String): String = {
        return name.toLowerCase
    }

    def formatNames(name: String)(format: String => String): String = {
        format(name)
    }

    def main(args: Array[String]): Unit = {
        println(formatNames("Simon")(toUpper));
        
        println(formatNames("Johnnie")(name => {
            name.substring(0, 2).toUpperCase + name.substring(2);
            })
        );
        println(formatNames("John")(toLower));
        
        println(formatNames("Eskiel")(name => {
            name.substring(0, 1).toUpperCase + name.substring(1, 5) + name.substring(5).toUpperCase;
        })
        );
    }
}