import java.util.*;
import java.util.stream.Collectors;

public class FraudDetection {

    public static class Transaction {
        private String transactionId;
        private String policyNumber;
        private double amount;
        private Date transactionDate;
        private boolean isFraudulent;

        public Transaction(String transactionId, String policyNumber, double amount, Date transactionDate, boolean isFraudulent) {
            this.transactionId = transactionId;
            this.policyNumber = policyNumber;
            this.amount = amount;
            this.transactionDate = transactionDate;
            this.isFraudulent = isFraudulent;
        }

        public String getTransactionId() {
            return transactionId;
        }

        public String getPolicyNumber() {
            return policyNumber;
        }

        public double getAmount() {
            return amount;
        }

        public Date getTransactionDate() {
            return transactionDate;
        }

        public boolean isFraudulent() {
            return isFraudulent;
        }

        @Override
        public String toString() {
            return "Transaction{transactionId='" + transactionId + "', policyNumber='" + policyNumber + "', amount=" + amount + ", isFraudulent=" + isFraudulent + "}";
        }
    }

    public static class FraudAlert {
        private String policyNumber;
        private long totalFraudulentTransactions;
        private double totalFraudAmount;

        public FraudAlert(String policyNumber, long totalFraudulentTransactions, double totalFraudAmount) {
            this.policyNumber = policyNumber;
            this.totalFraudulentTransactions = totalFraudulentTransactions;
            this.totalFraudAmount = totalFraudAmount;
        }

        public String getPolicyNumber() {
            return policyNumber;
        }

        public long getTotalFraudulentTransactions() {
            return totalFraudulentTransactions;
        }

        public double getTotalFraudAmount() {
            return totalFraudAmount;
        }

        @Override
        public String toString() {
            return "FraudAlert{policyNumber='" + policyNumber + "', totalFraudulentTransactions=" + totalFraudulentTransactions + ", totalFraudAmount=" + totalFraudAmount + "}";
        }
    }

    public static void main(String[] args) {
        List<Transaction> transactions = Arrays.asList(
                new Transaction("T001", "P001", 12000, new Date(), true),
                new Transaction("T002", "P002", 5000, new Date(), false),
                new Transaction("T003", "P001", 15000, new Date(), true),
                new Transaction("T004", "P003", 20000, new Date(), true),
                new Transaction("T005", "P001", 8000, new Date(), false),
                new Transaction("T006", "P002", 25000, new Date(), true),
                new Transaction("T007", "P003", 12000, new Date(), true),
                new Transaction("T008", "P003", 5000, new Date(), false),
                new Transaction("T009", "P001", 30000, new Date(), true),
                new Transaction("T010", "P004", 35000, new Date(), true)
        );

        List<Transaction> fraudulentTransactions = transactions.stream()
                .filter(transaction -> transaction.isFraudulent() && transaction.getAmount() > 10000)
                .collect(Collectors.toList());

        Map<String, List<Transaction>> groupedTransactions = fraudulentTransactions.stream()
                .collect(Collectors.groupingBy(Transaction::getPolicyNumber));

        Map<String, FraudAlert> fraudAlerts = groupedTransactions.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> {
                            long totalFraudulentTransactions = entry.getValue().size();
                            double totalFraudAmount = entry.getValue().stream()
                                    .mapToDouble(Transaction::getAmount)
                                    .sum();
                            return new FraudAlert(entry.getKey(), totalFraudulentTransactions, totalFraudAmount);
                        }
                ));

        fraudAlerts.values().stream()
                .filter(alert -> alert.getTotalFraudulentTransactions() > 5 || alert.getTotalFraudAmount() > 50000)
                .forEach(System.out::println);
    }
}
