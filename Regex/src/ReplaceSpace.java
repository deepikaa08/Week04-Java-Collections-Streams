import java.util.Scanner;

public class ReplaceSpace {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = input.nextLine();
        String result = text.replaceAll("\\s+", " ");
        System.out.println(result);
        input.close();
    }
}
