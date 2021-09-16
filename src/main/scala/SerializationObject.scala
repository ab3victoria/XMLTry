import java.time.{LocalDate, LocalTime}
import java.time.format.DateTimeFormatter

object SerializationObject {
  /**
   *
   * This is an example. I created XML file called "expenses.xml".
   * This class function prints details of these expenses.
   */
  def main(args:Array[String]): Unit =
  {
    val expenses = scala.xml.XML.loadFile("expenses.xml")
    var expensesList: List[Expense] = List()
    for(node<-(expenses\\"expense")) {
      expensesList = Expense.fromXML(node) :: expensesList
    }
    // Reverse the list (scala reads the file backwards)
    expensesList = expensesList.reverse

    // Printing the expenses
    println("-----------")
    var iterator:Iterator[Expense] = expensesList.iterator
    while(iterator.hasNext) {
      println(iterator.next)
    }
    println("-----------")

    /**
     * This code creates new expense, adding to list, prints them in XML form and saves in the file.
     */
    var ob:Expense = new Expense(
      "Test 3",
      "Testing",
      150.45,
      LocalDate.parse("18/09/2021", DateTimeFormatter.ofPattern("dd/MM/yyyy")),
      LocalTime.parse("00:25", DateTimeFormatter.ofPattern("HH:mm")))
    var newExpensesList: List[Expense] = ob :: expensesList
    val data = expensesToXML(newExpensesList)
    println(data)
    val pp = new scala.xml.PrettyPrinter(80, 2)
    scala.xml.XML.save("expenses.xml", scala.xml.XML.loadString(pp.format(data)) , "UTF-8", true)
  }

  def expensesToXML(expenses: List[Expense]) : xml.Elem = {
    <expenses>
      {expenses.map(e => e.toXML)}
    </expenses>
  }
}