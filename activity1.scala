object Main extends App {
  // 1. Area of a disk with radius r is Pi r*r. What is the area of a disk with radius 5? 

  def areaOfDisk(r:Double): Double = math.Pi*r*r
  printf("Area of a disk with radius 5 is: %.3f\n", areaOfDisk(5))

  // 2. The temperature is 35C; convert this temperature into Fahrenheit. ºF =ºC * 1.8000 + 32.00
  def toFahrenheit(c:Double) = c * 1.8 + 32
  printf("The temperature 35C in Fahrenheit is %.3f\n", toFahrenheit(35))

  // 3. The volume of a sphere with radius r is 4/3 Pi r3. What is the volume of a sphere with radius 5? 
  def volumeOfSphere(r:Double): Double = (4/3)*math.Pi*r*r*r
  printf("Volume of Sphere with radius 5 is: %.3f\n", volumeOfSphere(5))

  // 4. Suppose the cover price of a book is Rs. 24.95, but bookstores get a 40% discount. 
  // Shipping costs Rs. 3 for the first 50 copies and 75 cents for each additional copy.
  //  What is the total wholesale cost for 60 copies? 
  def bookPrice(x:Int):Double = x*24.95
  def discount(amount:Double): Double = amount * 0.4
  def shippingCost(x:Int): Double = 3*x+(x-50)*0.75

  printf("Total wholesale cost for 60 books is %.3f\n", bookPrice(60) - discount(bookPrice(60)) + shippingCost(60))


  // 5. I run 2 km at an easy pace (8 min per km), then 3 km at Tempo (7 min per km) and 2 km at easy pace again to reach home.
  //  What is the total running time? 
  def easyPaceTime(x:Int):Int=x*8
  def tempoTime(x:Int):Int=x*7

  printf("Total running time is: %d\n", easyPaceTime(2)+tempoTime(3)+easyPaceTime(2))

}

