import java.util.Scanner;

public class Username {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter username: ");
		String username = input.nextLine();
		String regex = "^[a-zA-Z][a-zA-Z0-9_]{4,14}$";
		if(username.matches(regex)) {
			System.out.println(username+" is valid");
		}else {
			System.out.println(username+" is invalid");
		}
		input.close();
	}

}



