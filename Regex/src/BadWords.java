import java.util.Scanner;

public class BadWords {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        String[] badwords = {"damn", "stupid"};
        System.out.print("Enter text: ");
        String text = input.nextLine();
        for(String word : badwords){
            text = text.replaceAll("(?i)\\b"+word+"\\b","****");
        }
        System.out.println(text);
        input.close();
    }
}
