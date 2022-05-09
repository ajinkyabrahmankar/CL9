import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.StringTokenizer;

public class UDP_Server {
	public static void main(String[] args) throws Exception{
		DatagramSocket ds = new DatagramSocket(1234);
		
		byte[] buf = null;
		
		DatagramPacket DpReceive = null;
		DatagramPacket DpSend = null;
		
		while(true) {
			buf = new byte[65535];
			
			DpReceive = new DatagramPacket(buf, buf.length);
			ds.receive(DpReceive);
			
			String inp = new String(buf, 0, buf.length);
			
			inp=inp.trim();
			
			System.out.println("\nInput Received to server:- " + inp);
			
			if(inp.equals("Exit")) {
				System.out.println("\nClient sent exit.. terminating");
				break;
			}
			
			StringTokenizer st = new StringTokenizer(inp);
			double a = Double.parseDouble(st.nextToken());
			double b = Double.parseDouble(st.nextToken());
			double res = a+b;
			System.out.println("Sending the result..");
			
			String result = Double.toString(res);
			
			buf = result.getBytes();
			
			int port = DpReceive.getPort();
			
			DpSend = new DatagramPacket(buf, buf.length, InetAddress.getLocalHost(), port);
			ds.send(DpSend);
		}
	}	
}
