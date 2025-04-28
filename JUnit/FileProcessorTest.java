import org.junit.jupiter.api.*;
import java.io.*;
import java.nio.file.*;
import static org.junit.jupiter.api.Assertions.*;

public class FileProcessorTest {

    static class FileProcessor {

        public void writeToFile(String filename, String content) throws IOException {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
                writer.write(content);
            }
        }

        public String readFromFile(String filename) throws IOException {
            StringBuilder sb = new StringBuilder();
            try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    sb.append(line);
                }
            }
            return sb.toString();
        }
    }

    private final FileProcessor fileProcessor = new FileProcessor();
    private final String testFile = "testFile.txt";

    @AfterEach
    public void cleanUp() throws IOException {
        Files.deleteIfExists(Paths.get(testFile));
    }

    @Test
    public void testWriteAndReadFile() throws IOException {
        String content = "Hello, world!";
        fileProcessor.writeToFile(testFile, content);
        String result = fileProcessor.readFromFile(testFile);
        assertEquals(content, result);
    }

    @Test
    public void testFileExistsAfterWriting() throws IOException {
        fileProcessor.writeToFile(testFile, "Testing existence.");
        assertTrue(Files.exists(Paths.get(testFile)));
    }

    @Test
    public void testIOExceptionOnReadingNonExistentFile() {
        String nonExistentFile = "does_not_exist.txt";
        assertThrows(IOException.class, () -> fileProcessor.readFromFile(nonExistentFile));
    }
}
