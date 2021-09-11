import scala.xml._
import java.net._

/**
 * This is an example for getting data from XML file,
 * gets currency rates from Bank Of Israel.
 * */
object XMLDemo
{
  def main(args:Array[String])
  {
    val url = new URL("https://www.boi.org.il/currency.xml")
    val conn = url.openConnection
    val doc = XML.load(conn.getInputStream)
    for(ob<-(doc\\"CURRENCY")) {
      println("currency:")
      println((ob \\ "NAME").text + "-" + (ob \\ "RATE").text)
    }
  }
}
