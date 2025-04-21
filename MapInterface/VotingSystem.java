import java.util.*;
public class VotingSystem {

	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		Map<String, Integer> voteCount = new HashMap<>();
		LinkedHashMap<Integer, String> voteOrder = new LinkedHashMap<>();
		int voteNumber = 1;
		System.out.println("Enter votes (type 'end' to stop): ");
		while(true) {
			System.out.println("Vote for candidate: ");
			String candidate = input.nextLine();
			if(candidate.equalsIgnoreCase("end")) {
				break;
			}
			voteCount.put(candidate, voteCount.getOrDefault(candidate, 0)+1);
			voteOrder.put(voteNumber++, candidate);
		}
		
		System.out.println("\n Order of Votes");
		for(Map.Entry<Integer, String> entry : voteOrder.entrySet()) {
			System.out.println("Vote "+entry.getKey()+": "+entry.getValue());
		}
		System.out.println("\nTotal Votes");
		for(Map.Entry<String, Integer> entry : voteCount.entrySet()) {
			System.out.println(entry.getKey()+" -> "+entry.getValue()+" votes");
		}
		
		TreeMap<String, Integer> sortedVotes = new TreeMap<>(voteCount);
		System.out.println("Votes sorted by candidate name:");
		for(Map.Entry<String, Integer> entry : sortedVotes.entrySet()) {
			System.out.println(entry.getKey()+" -> "+entry.getValue()+" votes");
		}
		input.close();
	}

}
