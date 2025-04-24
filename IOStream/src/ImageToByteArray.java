import java.io.*;
public class ImageToByteArray {

	public static void main(String[] args) {
		String originalFile = "original.jpg";
		String newFile = "copied.jpg";
		
		try {
			FileInputStream fis = new FileInputStream(originalFile);
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			
			byte[] buffer = new byte[1024];
			int bytesRead;
			while((bytesRead = fis.read(buffer))!=-1) {
				baos.write(buffer, 0, bytesRead);
			}
			fis.close();
			
			byte[] imageBytes = baos.toByteArray();
			System.out.println("Image successfully read into byte array. Size: "+imageBytes.length+" bytes");
			
			ByteArrayInputStream bais = new ByteArrayInputStream(imageBytes);
			FileOutputStream fos = new FileOutputStream(newFile);
			
			while((bytesRead = bais.read(buffer))!=-1) {
				fos.write(buffer, 0, bytesRead);
			}
			fos.close();
			bais.close();
			System.out.println("Image successfully written to "+newFile);
		}catch (IOException e) {
			System.out.println("An error occured: "+e.getMessage());
			e.printStackTrace();
		}

	}

}
