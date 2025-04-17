import java.util.*;

interface BookCategory{
	String getGenre();
}

interface ClothingCategory{
	String getType();
}

interface GadgetCategory{
	String getBrand();
}

class Product<T>{
	private String name;
	private double price;
	private T category;
	
	public Product(String name, double price, T category){
		this.name=name;
		this.price=price;
		this.category=category;
	}
	
	public String getName(){
		return name;
	}
	public double getPrice(){
		return price;
	}
	public void setPrice(double price){
		this.price=price;
	}
	public T getCategory(){
		return category;
	}
	
	@Override
	public String toString(){
		return "Product: "+name+", Price: $"+price+", Category: "+category;
	}
}

class Fiction implements BookCategory{
	public String getGenre(){
		return "Fiction";
	}
	
	@Override
	public String toString(){
		return getGenre();
	}
}

class TShirt implements ClothingCategory{
	public String getType(){
		return "T-Shirt";
	}
	
	@Override
	public String toString(){
		return getType();
	}
}

class Laptop implements GadgetCategory{
	public String getBrand(){
		return "Smartphone";
	}
	
	@Override
	public String toString(){
		return getBrand();
	}
}

class DiscountItems{
	public static<T extends Product<?>> void applyDiscount(T product, double percent){
		double price=product.getPrice();
		double discount=price*(percent/100);
		product.setPrice(price-discount);
		System.out.println("Discount applied to "+product.getName()+" :$"+discount);
	}
}

public class OnlineMarketplace{
	public static void main(String[] args){
		Product<BookCategory> book=new Product<>("The Alchemist", 500, new Fiction());
		Product<ClothingCategory> shirt=new Product<>("Plain Tee", 399, new TShirt());
		Product<GadgetCategory> laptop=new Product<>("Acer Laptop", 70000, new Laptop());
		
		List<Product<?>> catalog=new ArrayList<>();
		catalog.add(book);
		catalog.add(shirt);
		catalog.add(laptop);
		System.out.println("Product List");
		for(Product<?> p: catalog){
			System.out.println(p);
		}
		System.out.println();
		System.out.println("Applying Discount");
		DiscountItems.applyDiscount(book, 20);
		DiscountItems.applyDiscount(shirt, 10);
		DiscountItems.applyDiscount(laptop, 35);
		System.out.println();
		System.out.println("Updated List");
		for(Product<?> p: catalog){
			System.out.println(p);
		}
	}
}

			