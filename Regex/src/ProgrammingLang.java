import java.util.Scanner;
import java.util.regex.*;

public class ProgrammingLang {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = input.nextLine();
        String[] lang = {"Java", "Python", "JavaScript", "Go"};
        StringBuilder result = new StringBuilder();
        boolean found = false;
        for(String l : lang){
            Pattern pattern = Pattern.compile("\\b"+l+"\\b");
            Matcher matcher = pattern.matcher(text);
            if(matcher.find()){
                if(found){
                    result.append(", ");
                }
                result.append(l);
                found = true;
            }
        }
        if(found){
            System.out.println(result);
        }else{
            System.out.println("No programming languages found");
        }
        input.close();
    }
}
