import java.io.*;
public class UppercaseToLowercase {

	public static void main(String[] args) {
		String inputFile = "input.txt";
		String outputFile = "output.txt";
		
		try(
			BufferedReader reader = new BufferedReader(new FileReader(inputFile));
			BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))
		){
			String line;
			while((line = reader.readLine())!=null) {
				writer.write(line.toLowerCase());
				writer.newLine();
			}
			System.out.println("Conversion completed: Uppercase letters converted to lowercase in "+outputFile);
		}catch(IOException e) {
			System.out.println("Error during file processing: "+e.getMessage());
			e.printStackTrace();
		}

	}

}
