import java.util.Scanner;

public class HexColorCode {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter hex code: ");
		String hex = input.nextLine();
		String regex = "^[#][a-fA-F0-9]{6}$";
		if(hex.matches(regex)){
			System.out.println(hex+" is a valid color code");
		}else{
			System.out.println(hex+" is not a valid color code");
		}
		input.close();

	}

}
