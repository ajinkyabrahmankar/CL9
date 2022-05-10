import java.rmi.Naming;
import java.rmi.registry.*;

public class RMIServer {
	public static void main(String[] args) throws Exception {
		RMI_Impl obj = new RMI_Impl();
		
		Naming.rebind("ADD", obj);
		System.out.println("Server started..");
	}
}
