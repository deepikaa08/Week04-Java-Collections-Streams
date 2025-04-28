import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserRegister {

    static class UserRegistration {

        public static String registerUser(String username, String email, String password) {
            if (username == null || username.trim().isEmpty()) {
                throw new IllegalArgumentException("Username cannot be empty.");
            }
            if (email == null || !email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
                throw new IllegalArgumentException("Invalid email format.");
            }
            if (password == null || password.length() < 6) {
                throw new IllegalArgumentException("Password must be at least 6 characters.");
            }
            return "User registered successfully";
        }
    }


    @Test
    public void testValidRegistration() {
        String result = UserRegistration.registerUser("Deepikaa", "deepikaa@example.com", "password123");
        assertEquals("User registered successfully", result);
    }

    @Test
    public void testEmptyUsername() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            UserRegistration.registerUser("", "test@example.com", "password123");
        });
        assertEquals("Username cannot be empty.", ex.getMessage());
    }

    @Test
    public void testInvalidEmail() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            UserRegistration.registerUser("John", "invalidemail", "password123");
        });
        assertEquals("Invalid email format.", ex.getMessage());
    }

    @Test
    public void testShortPassword() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            UserRegistration.registerUser("John", "john@example.com", "123");
        });
        assertEquals("Password must be at least 6 characters.", ex.getMessage());
    }
}
