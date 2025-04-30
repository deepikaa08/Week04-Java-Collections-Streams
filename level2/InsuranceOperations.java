import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

class InsurancePolicy {
    String policyNumber;
    String holderName;
    double premiumAmount;

    public InsurancePolicy(String policyNumber, String holderName, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.holderName = holderName;
        this.premiumAmount = premiumAmount;
    }

    public String getPolicyNumber() { return policyNumber; }
    public String getHolderName() { return holderName; }
    public double getPremiumAmount() { return premiumAmount; }

    public String toString() {
        return policyNumber + " | " + holderName + " | $" + premiumAmount;
    }
}

public class InsuranceOperations {
    public static void main(String[] args) {
        List<InsurancePolicy> policies = Arrays.asList(
                new InsurancePolicy("P001", "Alice", 1500),
                new InsurancePolicy("P002", "Bob", 950),
                new InsurancePolicy("P003", "Charlie", 2200),
                new InsurancePolicy("P004", "David Smith", 1800),
                new InsurancePolicy("P005", "Eve", 2100),
                new InsurancePolicy("P006", "Alice", 1300),
                new InsurancePolicy("P007", "Frank", 800),
                new InsurancePolicy("P008", "George Smith", 1200)
        );

        List<InsurancePolicy> filteredPremium = policies.stream()
                .filter(p -> p.getPremiumAmount() > 1200)
                .collect(Collectors.toList());

        List<InsurancePolicy> sortedByName = policies.stream()
                .sorted(Comparator.comparing(InsurancePolicy::getHolderName))
                .collect(Collectors.toList());

        double totalPremium = policies.stream()
                .mapToDouble(InsurancePolicy::getPremiumAmount)
                .sum();

        policies.forEach(p -> System.out.println(p.getPolicyNumber() + " - " + p.getHolderName() + " - $" + p.getPremiumAmount()));

        List<InsurancePolicy> premiumRange = policies.stream()
                .filter(p -> p.getPremiumAmount() >= 1000 && p.getPremiumAmount() <= 2000)
                .collect(Collectors.toList());

        Optional<InsurancePolicy> highestPremium = policies.stream()
                .max(Comparator.comparingDouble(InsurancePolicy::getPremiumAmount));

        Map<Character, List<InsurancePolicy>> groupedByInitial = policies.stream()
                .collect(Collectors.groupingBy(p -> p.getHolderName().charAt(0)));

        double averagePremium = policies.stream()
                .mapToDouble(InsurancePolicy::getPremiumAmount)
                .average().orElse(0);

        List<InsurancePolicy> sortedByPremium = policies.stream()
                .sorted(Comparator.comparingDouble(InsurancePolicy::getPremiumAmount))
                .collect(Collectors.toList());
        sortedByPremium.forEach(System.out::println);

        boolean anyAbove2000 = policies.stream()
                .anyMatch(p -> p.getPremiumAmount() > 2000);

        Map<String, Long> premiumRanges = policies.stream()
                .collect(Collectors.groupingBy(p -> {
                    if (p.getPremiumAmount() <= 1000) return "0-1000";
                    else if (p.getPremiumAmount() <= 2000) return "1001-2000";
                    else return ">2000";
                }, Collectors.counting()));

        List<String> uniqueNames = policies.stream()
                .map(InsurancePolicy::getHolderName)
                .distinct()
                .collect(Collectors.toList());

        List<InsurancePolicy> nameContainsSmith = policies.stream()
                .filter(p -> p.getHolderName().contains("Smith"))
                .collect(Collectors.toList());

        Map<String, Double> policyMap = policies.stream()
                .collect(Collectors.toMap(InsurancePolicy::getPolicyNumber, InsurancePolicy::getPremiumAmount));

        String text = "this is a sample text corpus this text has words and this is a simple sample";
        List<String> words = Arrays.stream(text.toLowerCase().replaceAll("[^a-z ]", "").split("\\s+"))
                .collect(Collectors.toList());

        Map<String, Long> wordFreq = words.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        List<Map.Entry<String, Long>> topNWords = wordFreq.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(5)
                .collect(Collectors.toList());

        topNWords.forEach(e -> System.out.println(e.getKey() + " : " + e.getValue()));

        List<Map.Entry<String, Long>> sortedWords = wordFreq.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .collect(Collectors.toList());

        if (sortedWords.size() >= 2) {
            System.out.println("Second most frequent word: " + sortedWords.get(1).getKey());
        }
    }
}
