import java.util.*;

public class SortPersonList {
    static class Person {
        String name;
        int age;
        double salary;

        public Person(String name, int age, double salary) {
            this.name = name;
            this.age = age;
            this.salary = salary;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public double getSalary() {
            return salary;
        }

        @Override
        public String toString() {
            return "Person{name='" + name + "', age=" + age + ", salary=" + salary + "}";
        }
    }

    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Alice", 30, 50000),
                new Person("Bob", 25, 60000),
                new Person("Charlie", 35, 70000),
                new Person("David", 28, 55000),
                new Person("Eve", 40, 80000)
        );

        people.sort((p1, p2) -> Integer.compare(p1.getAge(), p2.getAge()));

        people.forEach(System.out::println);
    }
}
