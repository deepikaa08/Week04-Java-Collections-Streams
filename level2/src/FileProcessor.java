import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class FileProcessor {
	
	public void processFiles(List<String> filePaths) {
		for(String path : filePaths) {
			System.out.println("Reading file: "+path);
			try(BufferedReader reader = new BufferedReader(new FileReader(path))){
				String line;
				while((line = reader.readLine())!=null) {
					System.out.println(line);
				}
			}catch(IOException e) {
				System.out.println("Error reading file "+path+": "+e.getMessage());
			}
		}
	}

	public static void main(String[] args) {
		List<String> files = Arrays.asList("C:\\Users\\deepi\\OneDrive\\Desktop\\file1.txt","C:\\Users\\deepi\\OneDrive\\Desktop\\file2.txt","C:\\Users\\deepi\\OneDrive\\Desktop\\file3.txt");
		FileProcessor processor = new FileProcessor();
		processor.processFiles(files);

	}

}
