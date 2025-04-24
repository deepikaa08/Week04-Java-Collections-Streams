import java.io.*;
public class StudentDataStream {
	public static void main(String[] args) {
		String fileName = "studentData.dat";
		
		int rollNumber = 101;
		String name = "AAA";
		double gpa = 8.7;
		
		try(DataOutputStream dos = new DataOutputStream(new FileOutputStream(fileName))){
			dos.writeInt(rollNumber);
			dos.writeUTF(name);
			dos.writeDouble(gpa);
			System.out.println("Student data written to file successfully");
		}catch (IOException e) {
			System.out.println("Error writing to file: "+e.getMessage());
		}
		try(DataInputStream dis = new DataInputStream(new FileInputStream(fileName))){
			int readRoll = dis.readInt();
			String readName = dis.readUTF();
			double readGPA = dis.readDouble();
			
			System.out.println("\nRetrieved Student Details: ");
			System.out.println("Roll Number: "+readRoll);
			System.out.println("Name: "+readName);
			System.out.println("GPA: "+readGPA);
		}catch(IOException e) {
			System.out.println("Error reading from file: "+e.getMessage());
		}
	}
}
