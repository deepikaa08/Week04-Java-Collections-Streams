import java.util.*;
import java.util.stream.Collectors;

public class PolicyHolderRisk {

    public static class PolicyHolder {
        private String holderId;
        private String name;
        private int age;
        private String policyType;
        private double premiumAmount;

        public PolicyHolder(String holderId, String name, int age, String policyType, double premiumAmount) {
            this.holderId = holderId;
            this.name = name;
            this.age = age;
            this.policyType = policyType;
            this.premiumAmount = premiumAmount;
        }

        public String getHolderId() {
            return holderId;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public String getPolicyType() {
            return policyType;
        }

        public double getPremiumAmount() {
            return premiumAmount;
        }

        @Override
        public String toString() {
            return "PolicyHolder{holderId='" + holderId + "', name='" + name + "', age=" + age + ", premiumAmount=" + premiumAmount + "}";
        }
    }

    public static class RiskAssessment {
        private String holderId;
        private String name;
        private double riskScore;

        public RiskAssessment(String holderId, String name, double riskScore) {
            this.holderId = holderId;
            this.name = name;
            this.riskScore = riskScore;
        }

        public String getHolderId() {
            return holderId;
        }

        public String getName() {
            return name;
        }

        public double getRiskScore() {
            return riskScore;
        }

        @Override
        public String toString() {
            return "RiskAssessment{holderId='" + holderId + "', name='" + name + "', riskScore=" + riskScore + "}";
        }
    }

    public static void main(String[] args) {
        List<PolicyHolder> policyHolders = Arrays.asList(
                new PolicyHolder("H001", "John Doe", 65, "Life", 5000),
                new PolicyHolder("H002", "Jane Smith", 70, "Life", 3000),
                new PolicyHolder("H003", "Alice Brown", 55, "Life", 7000),
                new PolicyHolder("H004", "Bob Johnson", 68, "Life", 8000),
                new PolicyHolder("H005", "Charlie White", 45, "Health", 4000),
                new PolicyHolder("H006", "David Black", 72, "Life", 12000),
                new PolicyHolder("H007", "Emma Green", 66, "Life", 6000)
        );

        List<PolicyHolder> filteredPolicyHolders = policyHolders.stream()
                .filter(holder -> "Life".equals(holder.getPolicyType()) && holder.getAge() > 60)
                .collect(Collectors.toList());

        List<RiskAssessment> riskAssessments = filteredPolicyHolders.stream()
                .map(holder -> new RiskAssessment(holder.getHolderId(), holder.getName(), holder.getPremiumAmount() / holder.getAge()))
                .collect(Collectors.toList());

        List<RiskAssessment> sortedRiskAssessments = riskAssessments.stream()
                .sorted(Comparator.comparing(RiskAssessment::getRiskScore).reversed())
                .collect(Collectors.toList());

        Map<String, List<RiskAssessment>> categorizedRiskAssessments = sortedRiskAssessments.stream()
                .collect(Collectors.groupingBy(assessment -> assessment.getRiskScore() > 0.5 ? "High Risk" : "Low Risk"));

        System.out.println("Categorized Risk Assessments:");
        categorizedRiskAssessments.forEach((category, assessments) -> {
            System.out.println(category + ":");
            assessments.forEach(System.out::println);
        });
    }
}
