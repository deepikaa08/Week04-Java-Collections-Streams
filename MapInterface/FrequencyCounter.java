import java.io.*;
import java.util.*;
public class FrequencyCounter{
    public static void main(String[] args) {
        String filepath="C:\\Users\\deepi\\OneDrive\\Desktop\\javaprac\\Week04\\Day2_training\\MapInterface\\text.txt";
        Map<String, Integer> wordFreq=new HashMap<>();
        try(BufferedReader reader=new BufferedReader(new FileReader(filepath))){
            String line;
            while((line=reader.readLine())!=null){
                line=line.replaceAll("[^a-zA-Z ]", "").toLowerCase();
                String[] words=line.split("\\s+");
                for(String word: words){
                    if(!word.isEmpty()){
                        wordFreq.put(word, wordFreq.getOrDefault(word,0)+1);
                    }
                }
            }
            System.out.println("Word Frequencies:");
            for(Map.Entry<String, Integer> entry: wordFreq.entrySet()){
                System.out.println(entry.getKey()+"="+entry.getValue());
            }
        }catch(IOException e){
            System.out.println("Error reading file: "+e.getMessage());
        }

    }
}