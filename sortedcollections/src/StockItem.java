package bhargavak;


public class StockItem implements Comparable<StockItem> {
	private final String name;
	private double price;
	private int quantityStock = 0;
	private int reservedQuantity = 0;	
	public StockItem(String name, double price) {
		this.name = name;
		this.price = price;
		this.quantityStock = 0;
	}

	public StockItem(String name, double price, int quantityStock) {
		this.name = name;
		this.price = price;
		this.quantityStock = quantityStock;
	}

	public String getName() {
		return name;
	}	

	public double getPrice() {
		return price;
	}

	public int quantityInStock() {
		return quantityStock;
	}
	public int reservedQuantity() {
		return this.reservedQuantity;
	}

	public void setPrice(double price) {
		if(price > 0.0) {
		this.price = price;
	}

}

public void adjustStock(int quantity) {
	int newQuantity = this.quantityStock + quantity;
	if(newQuantity >=0) {
		this.quantityStock = newQuantity;
	}

}

public int reserveStock(int quantityToReserve) {
if((quantityToReserve<=this.quantityStock))
{
	System.out.println("reserveStock() if block");
this.reservedQuantity = quantityToReserve;
//adjustStock(-reservedQuantity);
return this.reservedQuantity;
}
else
{
	System.out.println("reserveStock() else block");
	return 0;
}
}

public int unreserveStock(int quantityToUnReserve) {
	if((quantityToUnReserve<=this.reservedQuantity))
	{
		int newReservedQuantity = this.reservedQuantity - quantityToUnReserve;
		if(newReservedQuantity>=0)
		{
			this.reservedQuantity = newReservedQuantity;
			return quantityToUnReserve;
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

@Override
public boolean equals(Object obj){
	System.out.println("Entering StockItem.equals");
	if(obj == this){
		return true;
	}

	if((obj == null) || (obj.getClass() != this.getClass())) {
		return false;
	}

	String objName = ((StockItem) obj).getName();
	return this.name.equals(objName);
}

@Override
public int hashCode() {
	return this.name.hashCode() + 31;

}

@Override
public int compareTo(StockItem o) {
	System.out.println("Entering StockItem.compareTo");
	if(this == o) {
		return 0;
	}

	if(o !=null) {
		return this.name.compareTo(o.getName()); 
	}

	throw new NullPointerException();
}

@Override
public String toString() {
	return this.name + " : price " + this.price;
}

} 