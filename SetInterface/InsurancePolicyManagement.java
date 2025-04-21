import java.util.*;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

class Policy implements Comparable<Policy> {
	String policyNumber;
	String policyHolderName;
	Date expiryDate;
	String coverageType;
	double premiumAmount;
	
	public Policy(String policyNumber,String policyHolderName, Date expiryDate, String coverageType, double premiumAmount) {
		this.policyNumber = policyNumber;
		this.policyHolderName= policyHolderName;
		this.expiryDate= expiryDate;
		this.coverageType = coverageType;
		this.premiumAmount = premiumAmount;
	}
	
	@Override
	public boolean equals(Object o) {
		if(this == o) return true;
		if(!(o instanceof Policy)) return false;
		Policy policy = (Policy) o;
		return policyNumber.equals(policy.policyNumber);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(policyNumber);
	}
	
	@Override
	public int compareTo(Policy other) {
		return this.expiryDate.compareTo(other.expiryDate);
	}
	
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return "Policy Number: "+policyNumber+", Name: "+policyHolderName+", ExpiryDate: "+sdf.format(expiryDate)+", Coverage: "+coverageType+", Premium: "+premiumAmount;
	}
}
public class InsurancePolicyManagement {

	public static void main(String[] args) throws Exception{
		Set<Policy> hashSet = new HashSet<>();
		Set<Policy> linkedHashSet = new LinkedHashSet<>();
		Set<Policy> treeSet = new TreeSet<>();
		SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
		
		Policy p1 = new Policy("P101", "AAA", date.parse("2025-05-20"),"Health", 5000.0);
		Policy p2 = new Policy("P102", "BBB", date.parse("2024-11-14"),"Auto", 2000.0);
		Policy p3 = new Policy("P103", "CCC", date.parse("2025-08-03"),"Home", 8000.0);
		Policy p4 = new Policy("P101", "AAA", date.parse("2025-05-20"),"Health", 5000.0);

		hashSet.add(p1);
		hashSet.add(p2);
		hashSet.add(p3);
		hashSet.add(p4);
		
		linkedHashSet.addAll(hashSet);
		treeSet.addAll(hashSet);
		
		System.out.println("All unique policies: ");
		for(Policy p : hashSet) {
			System.out.println(p);
		}
		
		System.out.println("Policies Expiring Within 30 Days: ");
		Date today = new Date();
		for(Policy p : hashSet ) {
			long diff = p.expiryDate.getTime() - today.getTime();
			long daysLeft = TimeUnit.MILLISECONDS.toDays(diff);
			if(daysLeft >= 0 && daysLeft <=30) {
				System.out.println(p);
			}		
		}
		
		System.out.println("Policies with Coverage Type: 'Health': ");
		for(Policy p : hashSet) {
			if(p.coverageType.equalsIgnoreCase("Health")) {
				System.out.println(p);
			}
		}
		
		System.out.println("Detect Duplicates: ");
		Set<String> seenpn = new HashSet<>();
		for(Policy p : hashSet) {
			if(!seenpn.add(p.policyNumber)) {
				System.out.println("Duplicate found: "+p);
			}
		}
		
		System.out.println("\nPerformance Comparison");
		comparePerformance(hashSet, "HashSet");
		comparePerformance(linkedHashSet, "LinkedHashSet");
		comparePerformance(treeSet, "TreeSet");
	}
	
	public static void comparePerformance(Set<Policy> set, String setName) throws Exception{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Policy testPolicy = new Policy("P999", "Testuser", sdf.parse("2026-01-30"), "Test", 9999.0);
		
		long start = System.nanoTime();
		set.add(testPolicy);
		long addTime = System.nanoTime()-start;
		
		start = System.nanoTime();
		long searchTime = System.nanoTime() - start;
		
		start = System.nanoTime();
		set.remove(testPolicy);
		long removeTime = System.nanoTime() - start;
		
		System.out.println(setName+" -> Add: "+addTime+" ns, Search: "+searchTime+" ns, Remove: "+removeTime+" ns");
	}

}
