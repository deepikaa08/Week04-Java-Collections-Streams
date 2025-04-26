import java.util.Scanner;

public class ArrayOperations {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int[] numbers = null;
		try {
			System.out.print("Enter the size of the array: ");
			int size = input.nextInt();
			numbers = new int[size];
			System.out.println("Enter "+size+" elements");
			for(int i=0;i<size;i++) {
				numbers[i] = input.nextInt();
			}
			System.out.print("Enter the index to retrieve :");
			int index = input.nextInt();
			System.out.println("Values at index "+index+" is "+numbers[index]);
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Invalid index");
		}catch(NullPointerException e) {
			System.out.println("Array not initialized");
		}catch(Exception e) {
			System.out.println("Invalid input");
		}finally {
			input.close();
		}
	}
}
