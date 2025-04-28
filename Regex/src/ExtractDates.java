import java.util.regex.*;
import java.util.Scanner;

public class ExtractDates {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = input.nextLine();
        String regex = "\\b\\d{2}/\\d{2}/\\d{4}\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher =pattern.matcher(text);
        while(matcher.find()){
            System.out.println(matcher.group());
        }
        input.close();
    }
}
