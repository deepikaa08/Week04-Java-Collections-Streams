import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BankAccountTest {

    static class BankAccount {
        private double balance;

        public BankAccount(double initialBalance) {
            this.balance = initialBalance;
        }

        public void deposit(double amount) {
            if (amount > 0) {
                balance += amount;
            }
        }

        public void withdraw(double amount) {
            if (amount > balance) {
                throw new IllegalArgumentException("Insufficient funds");
            }
            balance -= amount;
        }

        public double getBalance() {
            return balance;
        }
    }



    @Test
    public void testDeposit() {
        BankAccount account = new BankAccount(1000);
        account.deposit(500);
        assertEquals(1500, account.getBalance(), 0.01);
    }

    @Test
    public void testWithdrawSuccess() {
        BankAccount account = new BankAccount(1000);
        account.withdraw(400);
        assertEquals(600, account.getBalance(), 0.01);
    }

    @Test
    public void testWithdrawInsufficientFunds() {
        BankAccount account = new BankAccount(300);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(500);
        });
        assertEquals("Insufficient funds", exception.getMessage());
    }

    @Test
    public void testGetBalance() {
        BankAccount account = new BankAccount(800);
        assertEquals(800, account.getBalance(), 0.01);
    }
}
