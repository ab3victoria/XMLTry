import scala.xml._
import java.net._

object GroceriesXML
{
  def main(args:Array[String])
  {
    val books = scala.xml.XML.loadFile("C:\\Users\\vikvi\\IdeaProjects\\XMLTry\\src\\main\\scala\\Items.xml")
    for(ob<-books) {
      print((ob \\ "purchaseOrder").text)
    }

  }
}