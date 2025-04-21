import java.util.*;
class Main {
    public static void main(String[] args){
		int[] arr={2, 2, 3, 1, 4, 3};
		Arrays.sort(arr);
		for(int i=0; i<arr.length-1; i++){
			while(i<arr.length&&arr[i]==arr[i+1]){
				a.add(arr[i]);
				i++;
				System.out.println(arr[i]);
			}
		}
	}
}