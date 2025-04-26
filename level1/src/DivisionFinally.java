import java.util.Scanner;

public class DivisionFinally {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		try {
			System.out.print("Enter numerator: ");
			int numerator = input.nextInt();
			System.out.print("Enter denominator: ");
			int denominator = input.nextInt();
			int result = numerator/denominator;
			System.out.println("Result: "+result);
		}catch(ArithmeticException e) {
			System.out.println("Cannot divide by zero!");
		}catch(Exception e) {
			System.out.println("Invalid input!");
		}finally {
			System.out.println("Operation completed");
		}
		input.close();
	}

}
