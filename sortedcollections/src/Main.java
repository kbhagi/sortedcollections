package bhargavak;
import java.util.Map;
public class Main {

	private static StockList stockList = new StockList();

	public static void main(String[] args) {
		StockItem temp = new StockItem("bread", 0.86, 100);
		stockList.addStock(temp);

		temp = new StockItem("cake", 1.10, 7);
		stockList.addStock(temp);

		temp = new StockItem("car", 12.50, 7);
		stockList.addStock(temp);

		temp = new StockItem("chair", 62.0, 10);
		stockList.addStock(temp);

		temp = new StockItem("cup", 0.50,200);
		stockList.addStock(temp);

		temp = new StockItem("cup", 0.45,7);
		stockList.addStock(temp);

		temp = new StockItem("door", 72.95, 4);
		stockList.addStock(temp);

		temp = new StockItem("juice", 2.50, 36);
		stockList.addStock(temp);

		temp = new StockItem("phone", 96.99, 35);
		stockList.addStock(temp);

		temp = new StockItem("towel",2.40, 80);
		stockList.addStock(temp);

		temp = new StockItem("vase", 8.76, 40);
		stockList.addStock(temp);


		Basket timsBasket = new Basket("Tim");
	/*	if((reserveItem(timsBasket,"car",1))&(sellItem(timsBasket, "car", 2)!=0))
		{
			System.out.println("car with quantity 1 sold");
		}
		else
		{*/
			reserveItem(timsBasket,"car",2);
			System.out.println(timsBasket);
		unreserveItem(timsBasket,"car",1);
		
		//}
		
		System.out.println(timsBasket);
		
		
		


	}

	public static boolean reserveItem(Basket basket, String item, int quantity) {
		StockItem stockItem = stockList.get(item);
		if(stockItem == null) {
			System.out.println("Item does not exist , can't reserve " + item);
			return false;
		}
		int value =	basket.addToBasket(stockItem, quantity);
		if(value!=0)
		{
			System.out.println(item+" added to basket");
			return true;
		}
		else 
		{
			System.out.println(item+" not added to basket");
			return false;
		}	
		

	}

	public static void unreserveItem(Basket basket, String item, int quantity) {
		StockItem stockItem = stockList.get(item);
		if(stockItem == null) {
			System.out.println("Item doesnot exist , can't reserve " + item);
			//return "unable to unreserve" + item.getName();
		}
		int status = basket.removeFromBasket(stockItem, quantity);
		if(status!=0)
		{
			System.out.println("Item "+status+" "+ "unreserved");

		}
		else 
		{
		System.out.println("Item does not exist, can't unreserve " + item);
		}	
		

	}

	public static int sellItem(Basket basket, String item, int quantity) {
		// retrieve the item from stock list
		StockItem stockItem = stockList.get(item);
		if(stockItem == null) {
			System.out.println("We don't sell " + item);
			return 0;
		}
		if((stockItem.reservedQuantity()==quantity)&&(stockList.sellStock(item, quantity) != 0))
		{
		System.out.println("Item "+stockItem.getName() + " worth quantity "+stockItem.reservedQuantity()+ " sold "+ "remaining Quantity in stock "+stockItem.quantityInStock());			
		//basket.getBasket().clear(); /*keySet().removeAll()*/

			return quantity;
		}
		else 
		{
		System.out.println("Item " + item + " is not reserved");
		return 0;
		}
	}


}
