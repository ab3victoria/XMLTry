object SerializationObject {
  /**
   *
   *This is an example. I created XML file called "Items.xml" with 3 items.
   * This class function prints details of these items.
   */
  def main(args:Array[String]): Unit =
  {
    val items = scala.xml.XML.loadFile("C:\\Users\\vikvi\\IdeaProjects\\XMLTry\\src\\main\\scala\\Items.xml")
    for(ob<-(items\\"item")) {
      println("Item:" + (ob \\ "name").text + ", Price:" + (ob \\ "price").text + ", Amount:" + (ob \\ "amount").text)
    }

    /**
     * This code creates new items add prints them in XML form.
     */
    //    var ob:Item = new Item("001","chair",30.50,5)
//    var ob2:Item = new Item("002","desk",50.90,5)
//    for(item <- List(ob,ob2))
//    {
//      println(item.toXML)
//    }

  }
}
