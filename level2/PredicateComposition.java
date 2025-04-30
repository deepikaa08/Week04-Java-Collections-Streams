import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateComposition {

    public static void main(String[] args) {
        List<String> strings = Arrays.asList(
                "testcase", "example", "short", "testing", "unit", "integrationtest", "mocktest"
        );

        Predicate<String> lengthGreaterThan5 = str -> str.length() > 5;
        Predicate<String> containsTest = str -> str.contains("test");
        Predicate<String> combinedPredicate = lengthGreaterThan5.and(containsTest);
        List<String> filteredList = strings.stream().filter(combinedPredicate).collect(Collectors.toList());

        System.out.println("Filtered strings: " + filteredList);
    }
}
