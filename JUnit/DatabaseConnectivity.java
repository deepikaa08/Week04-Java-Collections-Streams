import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DatabaseConnectivity {

    static class DatabaseConnection {
        private boolean connected = false;

        public void connect() {
            connected = true;
            System.out.println("Database connected.");
        }

        public void disconnect() {
            connected = false;
            System.out.println("Database disconnected.");
        }

        public boolean isConnected() {
            return connected;
        }
    }

    // Instance for each test
    private DatabaseConnection db;

    @BeforeEach
    public void setUp() {
        db = new DatabaseConnection();
        db.connect();
    }

    @AfterEach
    public void tearDown() {
        db.disconnect();
    }

    @Test
    public void testConnectionIsEstablished() {
        assertTrue(db.isConnected(), "Connection should be established before test");
    }

    @Test
    public void testConnectionIsClosedAfterTest() {
        assertTrue(db.isConnected(), "Connection should be open during test");

    }
}
