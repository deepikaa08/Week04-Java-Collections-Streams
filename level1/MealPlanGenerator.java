import java.util.*;

interface MealPlan{
	String getMealName();
	List<String> getIngredients();
}

class VegetarianMeal implements MealPlan{
	public String getMealName(){
		return "Vegetarian Meal";
	}
	public List<String> getIngredients(){
		return Arrays.asList("Panner", "Rice", "Spices", "Vegetables");
	}
}

class VeganMeal implements MealPlan{
	public String getMealName(){
		return "Vegan Meal";
	}
	public List<String> getIngredients(){
		return Arrays.asList("Quinoa", "Olive Oil", "Tofu", "Brocolli");
	}
}

class Meal<T extends MealPlan>{
	private T meal;
	
	public Meal(T meal){
		this.meal=meal;
	}
	public T getMeal(){
		return meal;
	}
	
	@Override
	public String toString(){
		return "Meal: "+meal.getMealName()+"\nIngredients: "+meal.getIngredients();
	}
}

class MealPlanner{
	public static<T extends MealPlan> Meal<T> generateMealPlan(T meal){
		return new Meal<>(meal);
	}
}

public class MealPlanGenerator{
	public static void main(String[] args){
		VegetarianMeal veg=new VegetarianMeal();
		VeganMeal vegan=new VeganMeal();
		
		Meal<VegetarianMeal> meal1=MealPlanner.generateMealPlan(veg);
		Meal<VeganMeal> meal2=MealPlanner.generateMealPlan(vegan);
		System.out.println(meal1);
		System.out.println();
		System.out.println(meal2);
	}
}
