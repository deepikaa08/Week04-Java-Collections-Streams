import java.util.Scanner;
import java.util.regex.*;

public class ExtractEmail {
    public static void main(String[] args){
        Scanner input= new Scanner(System.in);
        System.out.println("Enter text here: ");
        String text = input.nextLine();
        String regex = "\\b[A-Za-z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z]{2,}\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        boolean found = false;
        while(matcher.find()){
            System.out.println(matcher.group());
            found = true;
        }
        if(!found){
            System.out.println("No email id found");
        }
        input.close();
    }

}
