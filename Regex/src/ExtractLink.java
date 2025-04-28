import java.util.regex.*;
import java.util.Scanner;

public class ExtractLink {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = input.nextLine();
        String regex = "https?://(www\\.)?([a-zA-Z0-9.-]+)";
        Pattern pattern =Pattern.compile(regex);
        Matcher matcher =pattern.matcher(text);
        while(matcher.find()){
            System.out.println(matcher.group());
        }
        input.close();
    }
}
