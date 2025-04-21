import java.util.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

class Policy {
    String policyNumber;
    String policyholderName;
    LocalDate expiryDate;
    String coverageType;
    double premiumAmount;

    public Policy(String policyNumber, String policyholderName, LocalDate expiryDate, String coverageType, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.policyholderName = policyholderName;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }

    @Override
    public String toString() {
        return "PolicyNumber: " + policyNumber +
               ", Holder: " + policyholderName +
               ", Expiry: " + expiryDate +
               ", Coverage: " + coverageType +
               ", Premium: " + premiumAmount;
    }
}

public class InsurancePolicyManagementSystem {
    static HashMap<String, Policy> policyHashMap = new HashMap<>();
    static LinkedHashMap<String, Policy> policyLinkedHashMap = new LinkedHashMap<>();
    static TreeMap<LocalDate, List<Policy>> policyTreeMap = new TreeMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        while (true) {
            System.out.println("\n--- Insurance Policy Management ---");
            System.out.println("1. Add Policy");
            System.out.println("2. Retrieve Policy by Number");
            System.out.println("3. List Policies Expiring Soon (next 30 days)");
            System.out.println("4. List Policies by Policyholder Name");
            System.out.println("5. Remove Expired Policies");
            System.out.println("6. Display All Policies");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume leftover newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Policy Number: ");
                    String number = scanner.nextLine();
                    System.out.print("Enter Policyholder Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Expiry Date (yyyy-MM-dd): ");
                    String expiryInput = scanner.nextLine();
                    LocalDate expiry = LocalDate.parse(expiryInput, formatter);
                    System.out.print("Enter Coverage Type: ");
                    String coverage = scanner.nextLine();
                    System.out.print("Enter Premium Amount: ");
                    double premium = scanner.nextDouble();

                    Policy policy = new Policy(number, name, expiry, coverage, premium);

                    policyHashMap.put(number, policy);
                    policyLinkedHashMap.put(number, policy);
                    policyTreeMap.computeIfAbsent(expiry, k -> new ArrayList<>()).add(policy);

                    System.out.println("Policy added successfully.");
                    break;

                case 2:
                    System.out.print("Enter Policy Number to retrieve: ");
                    String searchNumber = scanner.nextLine();
                    Policy foundPolicy = policyHashMap.get(searchNumber);
                    if (foundPolicy != null) {
                        System.out.println(foundPolicy);
                    } else {
                        System.out.println("Policy not found.");
                    }
                    break;

                case 3:
                    System.out.println("Policies expiring within next 30 days:");
                    LocalDate today = LocalDate.now();
                    LocalDate next30 = today.plusDays(30);
                    for (Map.Entry<LocalDate, List<Policy>> entry : policyTreeMap.subMap(today, true, next30, true).entrySet()) {
                        for (Policy p : entry.getValue()) {
                            System.out.println(p);
                        }
                    }
                    break;

                case 4:
                    System.out.print("Enter Policyholder Name: ");
                    String holderName = scanner.nextLine();
                    boolean found = false;
                    for (Policy p : policyLinkedHashMap.values()) {
                        if (p.policyholderName.equalsIgnoreCase(holderName)) {
                            System.out.println(p);
                            found = true;
                        }
                    }
                    if (!found) {
                        System.out.println("No policies found for policyholder: " + holderName);
                    }
                    break;

                case 5:
                    System.out.println("Removing expired policies...");
                    LocalDate now = LocalDate.now();
                    Iterator<Map.Entry<String, Policy>> it = policyHashMap.entrySet().iterator();
                    while (it.hasNext()) {
                        Map.Entry<String, Policy> entry = it.next();
                        if (entry.getValue().expiryDate.isBefore(now)) {
                            it.remove();
                            policyLinkedHashMap.remove(entry.getKey());
                            policyTreeMap.get(entry.getValue().expiryDate).remove(entry.getValue());
                        }
                    }
                    System.out.println("Expired policies removed.");
                    break;

                case 6:
                    System.out.println("All policies (Insertion Order):");
                    for (Policy p : policyLinkedHashMap.values()) {
                        System.out.println(p);
                    }
                    break;

                case 7:
                    System.out.println("Exiting system. Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
