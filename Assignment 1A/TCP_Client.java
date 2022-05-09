import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class TCP_Client {
	public static void main(String[] args) throws Exception{
		InetAddress ip = InetAddress.getLocalHost();
		
		int port = 5555;
		
		Socket s = new Socket(ip, port);
		
		Scanner sc = new Scanner(System.in);
		
		DataOutputStream dos = new DataOutputStream(s.getOutputStream());
		DataInputStream dis = new DataInputStream(s.getInputStream());
		
		System.out.println("Enter two numbers : ");
		double a = sc.nextDouble();
		double b = sc.nextDouble();
		
		
		dos.writeDouble(a);
		dos.writeDouble(b);
		
		double c = dis.readDouble();
		
		System.out.println("The sum of numbers is : " + c);
		
		
	}
}
