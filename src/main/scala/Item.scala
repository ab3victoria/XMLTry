



class Item(productCode: String, productName: String,productPrice:Double, productAmount: Int)
{
      var code:String = productCode
      var name:String = productName
      var amount:Int = productAmount
      var price:Double = productPrice

  def toXML = {
    <item>
          <code>{code}</code>
          <name>{name}</name>
          <price>{price}</price>
          <amount>{amount}</amount>

    </item>
  }
}

