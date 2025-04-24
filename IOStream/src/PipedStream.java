import java.io.*;
public class PipedStream {
	public static void main(String[] args) {
		try {
			PipedOutputStream pos = new PipedOutputStream();
			PipedInputStream pis = new PipedInputStream(pos);
			
			Thread writerThread = new Thread(()->{
				try {
					String message = "Hello from writer thread!";
					pos.write(message.getBytes());
					pos.close();
				}catch(IOException e) {
					System.out.println("Writer error: "+e.getMessage());
				}
			});
			Thread readerThread = new Thread(()->{
				try {
					int data;
					System.out.print("Reader recieved: ");
					while((data = pis.read())!=-1) {
						System.out.print((char)data);
					}
					pis.close();
				}catch(IOException e) {
					System.out.println("Reader error: "+e.getMessage());
				}
			});
			
			readerThread.start();
			writerThread.start();

		}catch (IOException e) {
			System.out.println("Error connecting piped streams: "+e.getMessage());
		}

	}
}
