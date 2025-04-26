import java.io.*;

public class MergeFiles {

	public static void main(String[] args) {
		String file1 = "C:\\Users\\deepi\\OneDrive\\Desktop\\file1.txt";
		String file2 = "C:\\Users\\deepi\\OneDrive\\Desktop\\file2.txt";
		String output = "C:\\Users\\deepi\\OneDrive\\Desktop\\file3.txt";
		try(
			BufferedReader reader1 = new BufferedReader(new FileReader(file1));
			BufferedReader reader2 = new BufferedReader(new FileReader(file2));
			BufferedWriter writer = new BufferedWriter(new FileWriter(output))){
			String line;
			while((line = reader1.readLine())!=null) {
				writer.write(line);
				writer.newLine();
			}
			while((line = reader2.readLine())!=null) {
				writer.write(line);
				writer.newLine();
			}
			System.out.println("Files merged successfully into "+output);
		}catch(IOException e) {
			System.out.println("Error during file operation: "+e.getMessage());
		}

	}

}
