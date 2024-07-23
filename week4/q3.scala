object D4Q3{
    
    def toUpper(name: String): String = {
        var uName:String = "";
        for(i <- 0 until name.length){
            if(name(i) >= 'a' && name(i) <= 'z'){
                uName+= (name(i).toInt - 32).toChar;
            }else{
                uName+= name(i);
            }
        }
        return uName;
    }

    def toLower(name: String): String = {
        var lName:String = "";
        for(i <- 0 until name.length){
            if(name(i) >= 'A' && name(i) <= 'Z'){
                lName += (name(i).toInt + 32).toChar;
            }else{
                lName += name(i);
            }
        }
        return lName;
    }

    // Formating function
    def formatNames(name: String)(format: String => String): String = {
        format(name)
    }

    def main(args: Array[String]): Unit = {
        println(formatNames("Benny")(toUpper));
        
        println(formatNames("Niroshan")(name => {
            name.substring(0, 4).toUpperCase + name.substring(4);
            })
        );
        println(formatNames("Saman")(toUpper));
        
        println(formatNames("Kumara")(name => {
            name.substring(0, 1).toUpperCase + name.substring(1, 5) + name.substring(5).toUpperCase;
        })
        );
    }
}