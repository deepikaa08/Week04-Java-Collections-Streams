import java.util.*;

public class OptionalMax {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10, 25, 7, 63, 42);
        Optional<Integer> maxOptional = numbers.stream().max(Integer::compareTo);
        maxOptional.ifPresentOrElse(
                max -> System.out.println("Maximum value: " + max),
                () -> System.out.println("List is empty. No maximum value.")
        );
    }
}
