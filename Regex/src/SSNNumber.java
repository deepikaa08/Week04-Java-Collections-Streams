import java.util.Scanner;
import java.util.regex.*;

public class SSNNumber {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter SSN number: ");
        String number = input.nextLine();
        String regex = "\\b\\d{3}-\\d{2}-\\d{4}\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(number);
        boolean found = false;
        while(matcher.find()){
            System.out.println(matcher.group()+" is valid");
            found = true;
        }
        if(!found){
            System.out.println("Not a valid SSN number");
        }
        input.close();
    }
}
