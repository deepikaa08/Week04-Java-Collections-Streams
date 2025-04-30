import java.util.function.BiFunction;
import java.util.Scanner;

public class Bifunction {

    public static void main(String[] args) {
        BiFunction<String, String, String> concatenateWithSpace = (str1, str2) -> str1 + " " + str2;

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the first string: ");
        String input1 = scanner.nextLine();

        System.out.print("Enter the second string: ");
        String input2 = scanner.nextLine();
        String result = concatenateWithSpace.apply(input1, input2);
        System.out.println("Concatenated string: " + result);

        scanner.close();
    }
}
