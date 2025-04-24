import java.io.*;
import java.util.*;

public class WordCount {

	public static void main(String[] args) {
		String filePath="C:\\Users\\deepi\\OneDrive\\Desktop\\javaprac\\Week04\\Day3_training\\IOStream\\src\\source.txt";
		Map<String, Integer> countMap = new HashMap<>();
		try(BufferedReader br = new BufferedReader(new FileReader(filePath))){
			String line;
			while((line = br.readLine())!=null) {
				line = line.replaceAll("[^a-zA-Z ]"," ").toLowerCase();
				String[] words = line.split("\\s+");
				
				for(String word : words) {
					if(!word.isEmpty()) {
						countMap.put(word, countMap.getOrDefault(words, 0)+1);
					}
				}
			}
			int totalWords = countMap.values().stream().mapToInt(Integer::intValue).sum();
			System.out.println("Total number of words: "+totalWords);
			List<Map.Entry<String, Integer>> sortedList = new ArrayList<>(countMap.entrySet());
			sortedList.sort((a, b) -> b.getValue().compareTo(a.getValue()));
			System.out.println("Top 5 most frequent words: ");
			for(int i=0; i<Math.min(5,  sortedList.size());i++) {
				Map.Entry<String, Integer> entry = sortedList.get(i);
				System.out.println(entry.getKey()+" - "+entry.getValue()+" times");
			}
		}catch(IOException e) {
			System.out.println("Error reading the file: "+e.getMessage());
		}

	}

}


