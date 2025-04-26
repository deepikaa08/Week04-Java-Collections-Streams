import java.util.HashSet;
import java.util.Scanner;
class UserAlreadyExistsException extends Exception{
	public UserAlreadyExistsException(String message) {
		super(message);
	}
}

class UserNotFoundException extends Exception{
	public UserNotFoundException(String message) {
		super(message);
	}
}

class UserService{
	private HashSet<String> users = new HashSet<>();
	public void registerUser(String username) throws UserAlreadyExistsException{
		if(users.contains(username)) {
			throw new UserAlreadyExistsException("User already exists");
		}
		users.add(username);
		System.out.println("User registered: "+username);
	}
	
	public void checkUserExistence(String username) throws UserNotFoundException{
		if(!users.contains(username)) {
			throw new UserNotFoundException("User not found");
		}
		System.out.println("User exists: "+username);
	}
	
}
public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		UserService service = new UserService();
		try {
			System.out.print("Enter username to register: ");
			String user1 = input.nextLine();
			service.registerUser(user1);
			System.out.print("Enter username to check: ");
			String user2 = input.nextLine();
			service.checkUserExistence(user2);
		}catch(UserAlreadyExistsException | UserNotFoundException e) {
			System.out.println("Error: "+e.getMessage());
		}
		input.close();

	}

}

