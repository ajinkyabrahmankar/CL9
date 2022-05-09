import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class tcpservera {
	public static void main(String[] args) throws Exception{
		ServerSocket ss = new ServerSocket(5555);
		
		Socket s = ss.accept();
		
		DataOutputStream dos = new DataOutputStream(s.getOutputStream());
		DataInputStream dis = new DataInputStream(s.getInputStream());
		
		Scanner sc = new Scanner(System.in);
		
		double a = dis.readDouble();
		double b = dis.readDouble();
		
		double c = a+b;
		
		dos.writeDouble(c);
		
//		System.out.println("Enter two numbers : ");
//		double a = sc.nextDouble();
//		double b = sc.nextDouble();
//		
//		dos.writeDouble(a);
//		dos.writeDouble(b);
		
		
		
	}
}
