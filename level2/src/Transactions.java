import java.util.Scanner;
class InvalidTransactionException extends Exception{
	public InvalidTransactionException(String message) {
		super(message);
	}
}
public class Transactions {
	
	public static void processTransaction(double amount) throws InvalidTransactionException{
		if(amount<0) {
			throw new InvalidTransactionException("Negative amount: "+amount);
		}
		System.out.println("Transaction successful: ₹"+amount);
	}
	
	public static void handleTransaction(double amount) throws InvalidTransactionException{
		try {
			processTransaction(amount);
		}catch(InvalidTransactionException e) {
			throw new InvalidTransactionException("Transaction failed for amount ₹"+amount+". Reason: "+e.getMessage());
		}
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		try {
			System.out.print("Enter transaction amount: ₹");
			double amount = input.nextDouble();
			handleTransaction(amount);
		}catch(InvalidTransactionException e) {
			System.out.println("Error: "+e.getMessage());
		}catch(Exception e) {
			System.out.println("Invalid input. Please enter valid number");
		}finally {
			input.close();
		}

	}

}