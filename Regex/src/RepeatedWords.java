import java.util.Scanner;
import java.util.regex.*;

public class RepeatedWords {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = input.nextLine();
        String regex = "\\b(\\w+)\\b\\s+\\1\\b";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);
        StringBuilder result = new StringBuilder();
        String[] found = new String[100];
        int count = 0;
        while(matcher.find()){
            String word = matcher.group(1).toLowerCase();
            boolean exists = false;
            for(int i = 0 ; i<count; i++){
                if(found[i].equals(word)){
                    exists = true;
                    break;
                }
            }
            if(!exists){
                found[count++] = word;
                if(result.length()>0){
                    result.append(", ");
                }
                result.append(word);
            }
        }
        if(result.length()>0){
            System.out.println(result);
        }else{
            System.out.println("No repeating words");
        }
    }
}
