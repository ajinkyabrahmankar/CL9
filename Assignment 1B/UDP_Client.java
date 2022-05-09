import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class UDP_Client {
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		int port = 1234;
		DatagramSocket ds = new DatagramSocket();
		InetAddress ip = InetAddress.getLocalHost();
		byte[] buf=null;
		
		while(true) {
			System.out.println("Enter two nos. to add : ");
			System.out.println("enter `Exit` to terminate");
			
			String inp = sc.nextLine();
			buf = new byte[65535];
			
			buf = inp.getBytes();
			
			DatagramPacket DpSend = new DatagramPacket(buf, buf.length, ip, port);
			ds.send(DpSend);
			
			if(inp.equals("Exit")) {
				break;
			}
			
			buf = new byte[65535];
			
			DatagramPacket DpReceive = new DatagramPacket(buf, buf.length);
			ds.receive(DpReceive);
			
			System.out.println("Answer :- " + new String(buf, 0, buf.length));
		}
	}
}
