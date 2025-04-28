import java.util.Scanner;

public class LicensePlate {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter lincense number: ");
		String number = input.nextLine();
		String regex = "^[A-Z]{2}[0-9]{4}$";
		if(number.matches(regex)) {
			System.out.println(number+" is a valid license plate number");
		}else {
			System.out.println(number+" is not a valid license plate number");
		}
		input.close();
	}

}
