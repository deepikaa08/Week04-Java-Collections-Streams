import java.util.*;
public class BinaryNumbers {
    public static List<String> binary(int n){
        List<String> binaryNums=new LinkedList<>();
        Queue<String> queue=new LinkedList<>();
        queue.add("1");
        while(n>0){
            String current=queue.poll();
            binaryNums.add(current);
            queue.add(current+"0");
            queue.add(current+"1");
            n--;
        }
        return binaryNums;
    }

    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.print("Enter number: ");
        int n=input.nextInt();
        List<String> result=binary(n);
        System.out.println(result);
        input.close();
    }
}
