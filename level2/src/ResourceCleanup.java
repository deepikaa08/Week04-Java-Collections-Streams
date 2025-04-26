class Connection{
	public void openConnection() {
		System.out.println("Connection opened");
	}
	
	public void process() throws Exception{
		System.out.println("Processing");
		throw new Exception("Error while processing");
	}
	
	public void closeConnection() {
		System.out.println("Connection closed");
	}
}
public class ResourceCleanup {

	public static void main(String[] args) {
		Connection connect = new Connection();
		try {
			connect.openConnection();
			connect.process();
		}catch(Exception e) {
			System.out.println("Exception caught: "+e.getMessage());
		}finally {
			connect.closeConnection();
		}

	}

}

