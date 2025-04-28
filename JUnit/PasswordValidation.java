import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PasswordValidation {

    static class PasswordValidator {
        public static boolean isValid(String password) {
            if (password == null || password.length() < 8) return false;
            boolean hasUppercase = false;
            boolean hasDigit = false;

            for (char c : password.toCharArray()) {
                if (Character.isUpperCase(c)) hasUppercase = true;
                if (Character.isDigit(c)) hasDigit = true;
            }

            return hasUppercase && hasDigit;
        }
    }


    @Test
    public void testValidPassword() {
        assertTrue(PasswordValidator.isValid("Password1"));
        assertTrue(PasswordValidator.isValid("Abcdefg9"));
    }

    @Test
    public void testTooShort() {
        assertFalse(PasswordValidator.isValid("Pass1"));
    }

    @Test
    public void testNoUppercase() {
        assertFalse(PasswordValidator.isValid("password1"));
    }

    @Test
    public void testNoDigit() {
        assertFalse(PasswordValidator.isValid("Password"));
    }

    @Test
    public void testNullPassword() {
        assertFalse(PasswordValidator.isValid(null));
    }
}
