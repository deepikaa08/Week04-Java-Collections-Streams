import java.util.Scanner;

public class NestedTryCatch {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		try {
			System.out.print("Enter the number of elements in the array: ");
			int size = input.nextInt();
			int[] arr = new int[size];
			System.out.println("Enter "+size+" elements: ");
			for(int i=0; i<size; i++) {
				arr[i] = input.nextInt();
			}
			System.out.print("Enter the index of the element to access: ");
			int index = input.nextInt();
			try {
				int element = arr[index];
				System.out.print("Enter the divisor");
				int divisor = input.nextInt();
				try {
					int result = element/divisor;
					System.out.println("Result: "+result);
				}catch(ArithmeticException e) {
					System.out.print("Cannot divide by 0");
				}
			}catch(ArrayIndexOutOfBoundsException e) {
				System.out.println("Invalid input");
			}
		}catch(Exception e) {
			System.out.println("Invalid input");
		}finally {
			input.close();
		}

	}

}

			

