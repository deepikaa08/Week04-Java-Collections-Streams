import java.util.*;

public class RemoveDuplicates{
	public static List<Integer> remove(List<Integer> list){
		List<Integer> unique=new ArrayList<>();
		for(int i=0; i<list.size(); i++){
			if(!unique.contains(list.get(i))){
				unique.add(list.get(i));
			}
		}
		return unique;
	}
	
	public static void main(String[] args){
		List<Integer> input=Arrays.asList(3, 1, 2, 2, 3, 4);
		List<Integer> result=remove(input);
		System.out.println("After removing duplicates: "+result);
	}
}
