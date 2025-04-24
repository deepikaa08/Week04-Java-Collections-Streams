import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadUserInput {

	public static void main(String[] args) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		try {
			System.out.print("Enter your name: ");
			String name=reader.readLine();
			
			System.out.print("Enter your age: ");
			String age = reader.readLine();
			
			System.out.print("Enter your favorite programming language: ");
			String language = reader.readLine();
			
			FileWriter writer = new FileWriter("userinfo.txt");
			writer.write("Name: "+name+"\n");
			writer.write("Age: "+age+"\n");
			writer.write("Favorite Language: "+language+"\n");
			
			writer.close();
			System.out.println("User info saved successfully");
		}catch (IOException e) {
			System.out.println("Error occured while reading");
			e.printStackTrace();
		}
	}

}
