import java.io.IOException;
import java.util.Scanner;
public class DataProcessor {
	
	public static void processData(String data, int index) throws IOException{
		if(data == null||data.trim().isEmpty()) {
			throw new IOException("Data cannnot be null or empty");
		}
		char ch = data.charAt(index);
		System.out.println("Character at index "+index+": "+ch);
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		try {
			System.out.print("Enter a string: ");
			String text = input.nextLine();
			System.out.print("Enter an index to access: ");
			int index = input.nextInt();
			processData(text, index);
		}catch(IOException e) {
			System.out.println("Checked exception caught: "+e.getMessage());
		}catch(StringIndexOutOfBoundsException e) {
			System.out.println("Unchecked exception caught: Index out of range");
		}catch(Exception e) {
			System.out.println("Other exception: "+e.getMessage());
		}finally {
			input.close();
		}
	}

}
