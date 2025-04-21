import java.util.*;
class Employee{
	String name;
	String department;
	
	Employee(String name, String department){
		this.name = name;
		this.department = department;
	}
	@Override
	public String toString() {
		return name;
	}
}
public class DepartmentGroup {

	public static void main(String[] args) {
		List<Employee> employees = Arrays.asList(
				new Employee("Alice", "HR"),
				new Employee("Bob", "IT"), 
				new Employee("Carol", "HR"), 
				new Employee("David", "Finance"));
		Map<String, List<Employee>> groupedDept = new HashMap<>();
		
		for (Employee e : employees) {
			groupedDept.computeIfAbsent(e.department, k -> new ArrayList<>()).add(e);
		}
		for(Map.Entry<String, List<Employee>> entry : groupedDept.entrySet()) {
			System.out.println(entry.getKey() + ": "+ entry.getValue());
		}
	}

}
