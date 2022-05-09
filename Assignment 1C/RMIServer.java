import java.rmi.Naming;
import java.rmi.registry.*;

public class RMIServer {
	public static void main(String[] args) throws Exception {
		rmiimpla obj = new rmiimpla();
		
		Naming.rebind("ADD", obj);
		System.out.println("Server started..");
	}
}
