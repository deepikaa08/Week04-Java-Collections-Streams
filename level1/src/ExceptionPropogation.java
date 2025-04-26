import java.util.Scanner;

public class ExceptionPropogation {
	static int n;
	static int d;
	
	static void method1() {
		int result = n/d;
		System.out.println("Result: "+result);
	}
	
	static void method2() {
		method1();
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		try {
			System.out.print("Enter numerator: ");
			n = input.nextInt();
			System.out.print("Enter denominator: ");
			d = input.nextInt();
			method2();
		}catch(ArithmeticException e) {
			System.out.println("Handled exception in main");
		}finally {
			input.close();
		}

	}

}
