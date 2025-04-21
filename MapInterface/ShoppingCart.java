import java.util.*;
public class ShoppingCart {

	public static void main(String[] args) {
		Map<String, Double> prodPrice = new HashMap<>();
		prodPrice.put("Apple", 1.5);
		prodPrice.put("Banana", 0.8);
		prodPrice.put("Milk", 2.5);
		prodPrice.put("Bread", 1.2);
		
		Map<String, Integer> cart = new LinkedHashMap<>();
		addToCart(cart, "Apple");
		addToCart(cart, "Milk");
		addToCart(cart, "Banana");
		addToCart(cart, "Milk");
		
		System.out.println("Items in Cart");
		for(Map.Entry<String, Integer> entry : cart.entrySet()) {
			System.out.println(entry.getKey()+" (Quantity: "+entry.getValue()+")");
		}
		
		TreeMap<Double, List<String>> pricesSorted = new TreeMap<>();
		for(String p : cart.keySet()) {
			double price = prodPrice.get(p);
			pricesSorted.computeIfAbsent(price, k -> new ArrayList<>()).add(p);
		}
		
		System.out.println("Items Sorted by Price ");
		for(Map.Entry<Double, List<String>> entry : pricesSorted.entrySet()) {
			System.out.println("Price: "+entry.getKey()+" -> Products: "+entry.getValue());
		}
		double total=0.0;
		for(Map.Entry<String, Integer> entry : cart.entrySet()) {
			String product= entry.getKey();
			int quantity = entry.getValue();
			double price = prodPrice.get(product);
			total+=price*quantity;
		}
		System.out.println("\nTotal Price: $"+total);
	}
	public static void addToCart(Map<String, Integer> cart, String product) {
		cart.put(product,  cart.getOrDefault(product,  0)+1);
	}

}
