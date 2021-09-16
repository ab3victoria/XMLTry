import java.time.LocalDate
import java.time.LocalTime
import scala.xml.Elem

class Expense (var name: String, var category: String, var cost: Double, var date: LocalDate, var time: LocalTime) {
  override def toString: String = {
    super.toString
    s"Name: ${name}, category: ${category}, cost: ${cost}, date: ${date}, time: ${time}"
  }

  def toXML: Elem = {
    <expense>
      <name>{name}</name>
      <category>{category}</category>
      <cost>{cost}</cost>
      <date>{date}</date>
      <time>{time}</time>
    </expense>
  }
}

object Expense {
  def fromXML(node: scala.xml.NodeSeq): Expense =
    new Expense(
      name = (node \ "name").text,
      category = (node \ "category").text,
      cost = (node \ "cost").text.toDouble,
      date = LocalDate.parse((node \ "date").text),
      time = LocalTime.parse((node \ "time").text)
    )
}