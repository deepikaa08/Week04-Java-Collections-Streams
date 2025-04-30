import java.util.*;
import java.util.stream.Collectors;

public class ClaimAnalysis {

    public static class Claim {
        private String claimId;
        private String policyNumber;
        private double claimAmount;
        private Date claimDate;
        private String status;

        public Claim(String claimId, String policyNumber, double claimAmount, Date claimDate, String status) {
            this.claimId = claimId;
            this.policyNumber = policyNumber;
            this.claimAmount = claimAmount;
            this.claimDate = claimDate;
            this.status = status;
        }


        public String getClaimId() {
            return claimId;
        }

        public String getPolicyNumber() {
            return policyNumber;
        }

        public double getClaimAmount() {
            return claimAmount;
        }

        public Date getClaimDate() {
            return claimDate;
        }

        public String getStatus() {
            return status;
        }

        @Override
        public String toString() {
            return "Claim{claimId='" + claimId + "', policyNumber='" + policyNumber + "', claimAmount=" + claimAmount + "}";
        }
    }

    public static class PolicyAggregate {
        private double totalClaimAmount;
        private double averageClaimAmount;

        public PolicyAggregate(double totalClaimAmount, double averageClaimAmount) {
            this.totalClaimAmount = totalClaimAmount;
            this.averageClaimAmount = averageClaimAmount;
        }

        public double getTotalClaimAmount() {
            return totalClaimAmount;
        }

        public double getAverageClaimAmount() {
            return averageClaimAmount;
        }

        @Override
        public String toString() {
            return "PolicyAggregate{totalClaimAmount=" + totalClaimAmount + ", averageClaimAmount=" + averageClaimAmount + "}";
        }
    }

    public static void main(String[] args) {
        List<Claim> claims = Arrays.asList(
                new Claim("C001", "P001", 6000, new Date(), "Approved"),
                new Claim("C002", "P002", 3000, new Date(), "Denied"),
                new Claim("C003", "P001", 8000, new Date(), "Approved"),
                new Claim("C004", "P003", 12000, new Date(), "Approved"),
                new Claim("C005", "P002", 10000, new Date(), "Approved"),
                new Claim("C006", "P004", 4000, new Date(), "Approved"),
                new Claim("C007", "P001", 5000, new Date(), "Approved")
        );

        List<Claim> filteredClaims = claims.stream()
                .filter(claim -> "Approved".equals(claim.getStatus()) && claim.getClaimAmount() > 5000)
                .collect(Collectors.toList());

        Map<String, List<Claim>> groupedClaims = filteredClaims.stream()
                .collect(Collectors.groupingBy(Claim::getPolicyNumber));

        Map<String, PolicyAggregate> aggregatedResults = groupedClaims.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> {
                            double totalClaimAmount = entry.getValue().stream()
                                    .mapToDouble(Claim::getClaimAmount)
                                    .sum();
                            double averageClaimAmount = entry.getValue().stream()
                                    .mapToDouble(Claim::getClaimAmount)
                                    .average()
                                    .orElse(0.0);
                            return new PolicyAggregate(totalClaimAmount, averageClaimAmount);
                        }
                ));

        List<Map.Entry<String, PolicyAggregate>> topPolicies = aggregatedResults.entrySet().stream()
                .sorted((entry1, entry2) -> Double.compare(entry2.getValue().getTotalClaimAmount(), entry1.getValue().getTotalClaimAmount()))
                .limit(3)
                .collect(Collectors.toList());

        System.out.println("Top 3 Policies with Highest Total Claim Amounts:");
        topPolicies.forEach(entry -> {
            System.out.println("Policy Number: " + entry.getKey() + " | Total Claim Amount: " + entry.getValue().getTotalClaimAmount()
                    + " | Average Claim Amount: " + entry.getValue().getAverageClaimAmount());
        });
    }
}
