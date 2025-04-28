import java.util.Scanner;
import java.util.regex.*;

public class CreditCard {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter card number: ");
        String number = input.nextLine();
        String regex = "^4\\d{15}$|^5\\d{15}$";
        Pattern pattern =Pattern.compile(regex);
        Matcher matcher = pattern.matcher(number);
        if(matcher.matches()){
            if(number.startsWith("4")){
                System.out.println("Valid Visa Card");
            }else{
                System.out.println("Valid MasterCard");
            }
        }else{
            System.out.println("Invalid card number");
        }
        input.close();
    }
}
