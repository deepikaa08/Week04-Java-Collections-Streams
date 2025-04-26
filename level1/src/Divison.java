import java.util.InputMismatchException;
import java.util.Scanner;

public class Divison {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		try {
			System.out.print("Enter first number (numerator): ");
			int num1 = input.nextInt();
			System.out.print("Enter second number (denominator): ");
			int num2 = input.nextInt();
			int result = num1/num2;
			System.out.println("Result: "+result);
		}catch(ArithmeticException e) {
			System.out.println("Error: Division by zero is not allowed");
		}catch(InputMismatchException e) {
			System.out.println("Error: Please enter valid numeric values");
		}finally {
			input.close();
		}

	}

}
