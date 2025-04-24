import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.File;
public class ReadWriteFile {
	public static void main(String[] args) {
		String sourceFile="C:\\Users\\deepi\\OneDrive\\Desktop\\javaprac\\Week04\\Day3_training\\IOStream\\src\\source.txt";
		String destinationFile="C:\\Users\\deepi\\OneDrive\\Desktop\\javaprac\\Week04\\Day3_training\\IOStream\\src\\destination.txt";
		
		FileInputStream fis = null;
		FileOutputStream fos = null;
		
		try {
			File file = new File(sourceFile);
			if(!file.exists()) {
				System.out.println("Source file does not exist");
				return;
			}
			fis = new FileInputStream(sourceFile);
			fos = new FileOutputStream(destinationFile);
			
			int data;
			while((data = fis.read())!=-1) {
				fos.write(data);
			}
			System.out.println("File copied successfully!");
		}catch(IOException e) {
			System.out.println("An error occured: "+e.getMessage());
		}finally {
			try {
				if(fis!=null) fis.close();
				if(fos!=null) fos.close();
			} catch(IOException e) {
				System.out.println("Error while closing files: "+e.getMessage());
			}
		}	
	}
}
