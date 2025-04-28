import java.util.Scanner;
import java.util.regex.*;

public class IPAddress {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter IP address: ");
        String ip = input.nextLine();
        String regex="^(25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d)(\\.(25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d)){3}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(ip);
        if(matcher.matches()){
            System.out.println("Valid IP address");
        }else{
            System.out.println("Invalid IP address");
        }
        input.close();
    }
}
