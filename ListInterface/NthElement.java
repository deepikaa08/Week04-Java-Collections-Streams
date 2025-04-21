import java.util.LinkedList;
import java.util.Scanner;

public class NthElement{
	public static String element(LinkedList<String> list, int n){
		int first=0;
		int second=0;
		while(first<n){
			if(first>list.size()){
				return null;
			}
			first++;
		}
		while(first<list.size()){
			first++;
			second++;
		}
		return list.get(second);
	}
	
	public static void main(String[] args){
		LinkedList<String> words=new LinkedList<>();
		words.add("A");
		words.add("B");
		words.add("C");
		words.add("D");
		words.add("E");
		for(int i=0; i<words.size(); i++){
			System.out.print(words.get(i)+", ");
		}
		System.out.println();
		Scanner input=new Scanner(System.in);
		System.out.print("Enter position: ");
		int n=input.nextInt();
		String result=element(words, n);
		System.out.println(result);
		input.close();
	}
}

		