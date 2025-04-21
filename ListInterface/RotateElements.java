import java.util.*;

public class RotateElements{
	public static List<Integer> rotate(List<Integer> list, int pos){
		pos=pos%(list.size());
		List<Integer> result=new ArrayList<>();
		for(int i=pos; i<list.size(); i++){
			result.add(list.get(i));
		}
		for(int i=0; i<pos; i++){
			result.add(list.get(i));
		}
		return result;
	}
	
	public static void main(String[] args){
		List<Integer> numbers=Arrays.asList(10, 20, 30, 40, 50);
		System.out.println("List: "+numbers);
		Scanner input=new Scanner(System.in);
		System.out.print("Enter position: ");
		int position=input.nextInt();
		List<Integer> answer=rotate(numbers, position);
		System.out.println("Rotated List: "+answer);
	}
}
