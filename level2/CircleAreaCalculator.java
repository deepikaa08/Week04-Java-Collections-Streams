import java.util.function.Function;
import java.util.Scanner;
public class CircleAreaCalculator {

    public static void main(String[] args) {Function<Double, Double> calculateArea = radius -> Math.PI * radius * radius;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the radius of the circle: ");
        double radius = scanner.nextDouble();
        double area = calculateArea.apply(radius);
        System.out.printf("Area of the circle with radius %.2f is %.2f%n", radius, area);

        scanner.close();
    }
}
