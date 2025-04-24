import java.io.*;
public class BufferedFileCopy {
	public static void main(String[] args) {
		String sourceFile = "largefile.txt";
		String destUnbuffered = "unbuffered_copy.txt";
		String destBuffered = "buffered_copy.txt";
		
		long startUnbuffered = System.nanoTime();
		copyUsingUnbufferedStream(sourceFile, destUnbuffered);
		long endUnbuffered = System.nanoTime();
		long durationUnbuffered = endUnbuffered-startUnbuffered;
		
		long startBuffered = System.nanoTime();
		copyUsingBufferedStream(sourceFile, destBuffered);
		long endBuffered = System.nanoTime();
		long durationBuffered = endBuffered-startBuffered;
		
		System.out.println("\nExecution Time(Unbuffered): "+durationUnbuffered/1_000_000+" ms");
		System.out.println("Execution Time(Buffered): "+durationBuffered/1_000_000+" ms");
	}
	
	public static void copyUsingUnbufferedStream(String source, String dest) {
		try(FileInputStream fis = new FileInputStream(source);
			FileOutputStream fos = new FileOutputStream(dest)){
			
			byte[] buffer = new byte[4096];
			int bytesRead;
			
			while((bytesRead = fis.read(buffer))!=-1) {
				fos.write(buffer, 0, bytesRead);
			}
			
			System.out.println("Unbuffered copy completed");
		}catch (IOException e) {
			System.out.println("Unbuffered Error: "+ e.getMessage());
		}
	}
	
	public static void copyUsingBufferedStream(String source, String dest) {
		try(BufferedInputStream bis = new BufferedInputStream(new FileInputStream(source));
			BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(dest))){
			
			byte[] buffer = new byte[4096];
			int bytesRead;
			
			while((bytesRead = bis.read(buffer))!=-1) {
				bos.write(buffer, 0, bytesRead);
			}
			System.out.println("Buffered copy completed");
		}catch(IOException e) {
			System.out.println("Buffered Error: "+e.getMessage());
		}
	}
}
