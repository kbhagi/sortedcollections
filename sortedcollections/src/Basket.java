package bhargavak;
import java.util.Map;
import java.util.TreeMap;
import java.util.Collections;

public class Basket {
	private final String name;
	private final Map<StockItem, Integer> list;
	//private static StockItem stockList = new StockItem();

	public Basket(String name) {
		this.name = name;
		this.list = new TreeMap<>();
	}

	public int addToBasket(StockItem item, int quantity) {
		int inBasket=0;
		if((item !=null) && (quantity >0)) {
			 inBasket = list.getOrDefault(item, 0);
			list.put(item, inBasket + quantity);
			if(item.reserveStock(quantity)!=0)
			{
				System.out.println("addToBasket() if block " + quantity);
			return quantity;			
			}
			else
			{
				System.out.println("addToBasket() else block");
				return 0;
			}
			
		}
		else
		{
			System.out.println("addToBasket() outer else block block");
			return 0;
		}
		
	}

	public int removeFromBasket(StockItem item, int quantityToUnReserve) {
		if((item !=null) && (quantityToUnReserve >0)) {
			int inBasket = this.list.getOrDefault(item, 0);
			if(inBasket>0)
			{
			this.list.remove(item);
			int status = item.unreserveStock(quantityToUnReserve);
			return 1;
			}
			else
			{
				return 0;
			}	
	}
	else
	{
		return 0;
	}
	
}


	public Map<StockItem, Integer> Items() {
		return Collections.unmodifiableMap(list);
	}

	public Map<StockItem, Integer> getBasket() {
		return this.list;
	}

	@Override
	public String toString() {
	 	String s = "\nShopping basket " + name + " contains " + list.size() + ((list.size() == 1) ? " item" : " items") + "\n";
	 	double totalCost = 0.0;

	 	for (Map.Entry<StockItem, Integer> item : list.entrySet()) {
	 		s = s + item.getKey() + ". " + item.getValue() +  " reserved\n";
	 		totalCost += item.getKey().getPrice() *	item.getValue();
	 	}
	 	return s + "Total  cost " + totalCost;
	}


}