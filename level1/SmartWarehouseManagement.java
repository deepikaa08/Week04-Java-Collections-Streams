import java.util.ArrayList;
import java.util.List;

abstract class WarehouseItem{
	private String name;
	
	public WarehouseItem(String name){
		this.name=name;
	}
	
	public String getName(){
		return name;
	}
	
	public abstract String getCategory();
	
	@Override
	public String toString(){
		return getCategory()+": "+name;
	}
}

class Electronics extends WarehouseItem{
	public Electronics(String name){
		super(name);
	}
	
	@Override
	public String getCategory(){
		return "Electronics";
	}
}

class Groceries extends WarehouseItem{
	public Groceries(String name){
		super(name);
	}
	
	@Override
	public String getCategory(){
		return "Groceries";
	}
}

class Furniture extends WarehouseItem{
	public Furniture(String name){
		super(name);
	}
	
	@Override
	public String getCategory(){
		return "Furniture";
	}
}

class Storage<T extends WarehouseItem>{
	private List<T> items=new ArrayList<>();
	
	public void addItem(T item){
		items.add(item);
	}
	
	public T getItem(int index){
		return items.get(index);
	}
	
	public List<T> getAll(){
		return items;
	}
}

class displayDetails{
	public static void displayItems(List<? extends WarehouseItem> items){
		for(WarehouseItem item: items){
			System.out.println(item);
		}
	}
}

public class SmartWarehouseManagement{
	public static void main(String[] args){
		Storage<Electronics> electronic=new Storage<>();
		electronic.addItem(new Electronics("Laptop"));
		electronic.addItem(new Electronics("Smartphone"));
		
		Storage<Groceries> grocery=new Storage<>();
		grocery.addItem(new Groceries("Coconuts"));
		grocery.addItem(new Groceries("Apples"));
		
		Storage<Furniture> furnitures=new Storage<>();
		furnitures.addItem(new Furniture("Chair"));
		furnitures.addItem(new Furniture("Table"));
		
		System.out.println("ELECTONICS: ");
		displayDetails.displayItems(electronic.getAll());
		System.out.println();
		System.out.println("GROCERIES: ");
		displayDetails.displayItems(grocery.getAll());
		System.out.println();
		System.out.println("FURNITURE: ");
		displayDetails.displayItems(furnitures.getAll());
	}
}

