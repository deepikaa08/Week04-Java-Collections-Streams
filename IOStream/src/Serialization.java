import java.io.*;
import java.util.*;

class Employee implements Serializable{
	private int id;
	private String name;
	private String department;
	private double salary;
	
	public Employee(int id, String name, String department, double salary) {
		this.id=id;
		this.name=name;
		this.department=department;
		this.salary=salary;
	}
	
	public String toString() {
		return "ID: "+id+", Name: "+name+", Dept: "+department+", Salary: $"+salary;
	}
}
public class Serialization {
	public static void main(String[] args) {
		String fileName = "employees.dat";
		
		List<Employee> employees = new ArrayList<>();
		employees.add(new Employee(101, "Alice", "HR", 50000));
		employees.add(new Employee(102, "Bob", "IT", 75000));
		employees.add(new Employee(103, "Charlie", "Finance", 60000));
		
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))){
			oos.writeObject(employees);
			System.out.println("Employee data has been serialized to "+fileName);
		}catch (IOException e) {
			System.out.println("Error during serialization: "+e.getMessage());
		}
		
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))){
			List<Employee> deserializedEmployees = (List<Employee>) ois.readObject();
			System.out.println("\nDeserialized Employees: ");
			for(Employee emp : deserializedEmployees) {
				System.out.println(emp);
			}
		}catch (IOException | ClassNotFoundException e) {
			System.out.println("Error during deserialization: "+e.getMessage());
			
		}
	}
}
