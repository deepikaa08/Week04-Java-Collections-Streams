@FunctionalInterface
interface SquareCalculator {
    int calculate(int number);

    default void printResult(int number) {
        int result = calculate(number);
        System.out.println("The square of " + number + " is " + result);
    }
}

public class CustomFunctionalInterface {
    public static void main(String[] args) {
        SquareCalculator square = n -> n * n;
        square.printResult(7);
    }
}
