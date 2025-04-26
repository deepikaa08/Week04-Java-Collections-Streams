import java.util.Scanner;
public class DivisionProcessor {
	
	public static int performDivision(int numerator, int denominator) {
		if(denominator == 0) {
			throw new ArithmeticException("Division by zero is not allowed");
		}
		return numerator/denominator;
	}
	
	public static int calculate(int numerator, int denominator) {
		try {
			return performDivision(numerator, denominator);
		}catch(ArithmeticException e) {
			throw new ArithmeticException("Error in calculate(): "+e.getMessage());
		}

	}
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		try {
			System.out.print("Enter numerator: ");
			int n = input.nextInt();
			System.out.print("Enter denominator: ");
			int d = input.nextInt();
			int result = calculate(n,d);
			System.out.print("Result: "+result);
		}catch(ArithmeticException e) {
			System.out.println("Exception caught in main: "+e.getMessage());
		}catch(Exception e) {
			System.out.println("Invalid input. Enter integers only");
		}finally {
			input.close();
			System.out.println("Program ended");
		}
	}
}
