import java.util.*;
import java.util.function.Consumer;

public class ConsumerFunction{

    public static void main(String[] args) {
        List<String> words = Arrays.asList("java", "lambda", "stream", "functional", "interface");
        Consumer<String> printUpperCase = str -> System.out.println(str.toUpperCase());
        words.forEach(printUpperCase);
    }
}
