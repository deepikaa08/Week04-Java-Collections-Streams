import java.util.*;

public class StringFrequency{
	public static Map<String, Integer> countFreq(List<String> words){
		Map<String, Integer> freqMap=new HashMap<>();
		for(String word: words){
			if(freqMap.containsKey(word)){
				freqMap.put(word, freqMap.get(word)+1);
			}
			else{
				freqMap.put(word, 1);
			}
		}
		return freqMap;
	}
	
	public static void main(String[] args){
		List<String> input=Arrays.asList("apple", "banana", "apple", "orange");
		Map<String, Integer> result=countFreq(input);
		System.out.println(result);
	}
}
