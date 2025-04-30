@FunctionalInterface
interface Adder {
    int add(int a, int b);
}

public class FunctionalInterfaceSum {

    public static void main(String[] args) {

        Adder adder = (a, b) -> a + b;


        int result = adder.add(10, 20);


        System.out.println("Sum: " + result);
    }
}
