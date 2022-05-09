import java.rmi.server.UnicastRemoteObject;

public class RMI_Impl extends UnicastRemoteObject implements RMI_Interface{
	public RMI_Impl() throws Exception{
		super();
	}
	
	public double addition(double a, double b) {
		return a+b;
	}
}
