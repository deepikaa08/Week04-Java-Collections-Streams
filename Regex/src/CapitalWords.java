import java.util.Scanner;
import java.util.regex.*;

public class CapitalWords {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter text here: ");
        String text = input.nextLine();
        String regex="\\b[A-Z][a-z]*\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        boolean found = false;
        StringBuilder result = new StringBuilder();
        while(matcher.find()){
            if(found){
                result.append(", ");
            }
            result.append(matcher.group());
            found = true;
        }
        if(found){
            System.out.println(result.toString());
        }else{
            System.out.println("No capital words");
        }
        input.close();
    }
}
