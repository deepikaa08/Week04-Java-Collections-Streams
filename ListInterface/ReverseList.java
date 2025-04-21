import java.util.ArrayList;
import java.util.LinkedList;

public class ReverseList{
	public static void reverseList(ArrayList<Integer> list){
		int left=0, right=list.size()-1;
		while(left< right){
			int temp=list.get(left);
			list.set(left, list.get(right));
			list.set(right, temp);
			left++;
			right--;
		}
	}
	
	public static void reverseLinkedList(LinkedList<Integer> list){
		int left=0;
		int right=list.size()-1;
		while(left<right){
			int temp=list.get(left);
			list.set(left, list.get(right));
			list.set(right, temp);
			left++;
			right--;
		}
	}
	
	public static void main(String[] args){
		ArrayList<Integer> arrayList=new ArrayList<>();
		for(int i=1; i<=5; i++){
			arrayList.add(i);
		}
		System.out.println("Original ArrayList: "+arrayList);
		reverseList(arrayList);
		System.out.println("Reverse ArrayList: "+arrayList);
		
		LinkedList<Integer> linkedlist=new LinkedList<>();
		for(int i=1; i<=5; i++){
			linkedlist.add(i);
		}
		System.out.println("Original LinkedList: "+linkedlist);
		reverseLinkedList(linkedlist);
		System.out.println("Reversed LinkedList: "+linkedlist);
	}
}

