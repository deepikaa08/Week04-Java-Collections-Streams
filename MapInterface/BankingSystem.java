import java.util.*;
public class BankingSystem {

	public static void main(String[] args) {
		Map<Integer, Double> accounts = new HashMap<>();
		accounts.put(101, 5000.0);
		accounts.put(102,  8000.0);
		accounts.put(103,  3000.0);
		
		TreeMap<Double, List<Integer>> sortedBalance = new TreeMap<>(Collections.reverseOrder());
		for(Map.Entry<Integer, Double> entry : accounts.entrySet()) {
			sortedBalance.computeIfAbsent(entry.getValue(), k -> new ArrayList<>()).add(entry.getKey());
		}
		System.out.println("Customer sorted by Balance");
		for(Map.Entry<Double, List<Integer>> entry : sortedBalance.entrySet()) {
			System.out.println("Balance: "+entry.getKey()+" -> Accounts: "+entry.getValue());
		}
		 Queue<WithdrawalRequest> queue = new LinkedList<>();
		 queue.add(new WithdrawalRequest(101, 1000));
		 queue.add(new WithdrawalRequest(103, 500));
		 queue.add(new WithdrawalRequest(102, 9000));
		 
		 System.out.println("\nProcessing Withdrawals");
		 while(!queue.isEmpty()) {
			 WithdrawalRequest request = queue.poll();
			 double balance = accounts.getOrDefault(request.accountNumber, 0.0);
			 if(balance>=request.amount) {
				 accounts.put(request.accountNumber, balance-request.amount);
				 System.out.println("Withdrawal of "+request.amount+" from Account "+request.accountNumber+" successful.");
			 }
			 else {
				 System.out.println("Insufficient funds for Account "+request.accountNumber);
			 }
		 }
		 
		 System.out.println("\nFinal Balance ");
		 for(Map.Entry<Integer, Double> entry : accounts.entrySet()) {
			 System.out.println("Account "+entry.getKey()+" : "+entry.getValue());
		 }

	}

}

class WithdrawalRequest{
	int accountNumber;
	double amount;
	
	WithdrawalRequest(int acc, double amt){
		this.accountNumber=acc;
		this.amount=amt;
	}
}

