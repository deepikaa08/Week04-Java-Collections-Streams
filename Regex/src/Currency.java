import java.util.Scanner;
import java.util.regex.*;

public class Currency {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter text: ");
        String text = input.nextLine();
        String regex = "\\$?\\d+(\\.\\d{2})?";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        boolean found = false;
        StringBuilder result = new StringBuilder();
        while(matcher.find()){
            if(found) result.append(", ");
            result.append(matcher.group());
            found = true;
        }
        if(found){
            System.out.println(result);
        }else{
            System.out.println("No currency value found");
        }
        input.close();
    }
}
