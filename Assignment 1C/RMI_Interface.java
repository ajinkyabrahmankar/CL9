import java.rmi.Remote;
import java.rmi.RemoteException;


public interface RMI_Interface extends Remote {
	public double addition(double a, double b) throws RemoteException;
}
