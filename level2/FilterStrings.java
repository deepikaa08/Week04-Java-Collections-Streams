import java.util.*;
import java.util.stream.Collectors;

public class FilterStrings {

    public static void main(String[] args) {
        List<String> strings = Arrays.asList("Apple", "Banana", "Avocado", "Grapes", "Apricot", "Orange");

        List<String> filteredList = strings.stream()
                .filter(str -> !str.startsWith("A")) // Filter strings not starting with "A"
                .collect(Collectors.toList()); // Collect the filtered result into a new list

        System.out.println(filteredList);
    }
}
