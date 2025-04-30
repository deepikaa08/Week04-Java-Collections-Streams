import java.util.*;
import java.util.stream.Collectors;

public class EmployeeData {

    public static class Employee {
        private int id;
        private String name;
        private String department;
        private double salary;

        public Employee(int id, String name, String department, double salary) {
            this.id = id;
            this.name = name;
            this.department = department;
            this.salary = salary;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getDepartment() {
            return department;
        }

        public double getSalary() {
            return salary;
        }

        @Override
        public String toString() {
            return "Employee{id=" + id + ", name='" + name + "', department='" + department + "', salary=" + salary + "}";
        }
    }

    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee(1, "John Doe", "Engineering", 90000),
                new Employee(2, "Jane Smith", "Marketing", 75000),
                new Employee(3, "Robert Johnson", "Engineering", 95000),
                new Employee(4, "Emily Davis", "Engineering", 80000),
                new Employee(5, "James Brown", "Engineering", 110000),
                new Employee(6, "Patricia Wilson", "HR", 78000)
        );

        List<Employee> filteredEmployees = employees.stream()
                .filter(e -> e.getDepartment().equals("Engineering") && e.getSalary() > 80000)
                .collect(Collectors.toList());

        List<Employee> sortedEmployees = filteredEmployees.stream()
                .sorted(Comparator.comparing(Employee::getSalary).reversed())
                .collect(Collectors.toList());

        Map<String, List<Employee>> groupedByDepartment = sortedEmployees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));

        Map<String, Double> averageSalaryByDepartment = groupedByDepartment.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> entry.getValue().stream().mapToDouble(Employee::getSalary).average().orElse(0)
                ));

        System.out.println("Filtered and Sorted Employees: ");
        sortedEmployees.forEach(System.out::println);

        System.out.println("\nGrouped by Department: ");
        groupedByDepartment.forEach((department, empList) -> {
            System.out.println(department + ": " + empList);
        });

        System.out.println("\nAverage Salary by Department: ");
        averageSalaryByDepartment.forEach((department, avgSalary) -> {
            System.out.println(department + ": " + avgSalary);
        });
    }
}
