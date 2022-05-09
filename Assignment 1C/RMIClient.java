import java.rmi.Naming;
import java.util.Scanner;

public class RMIClient {
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter two numbers : ");
		double a = sc.nextDouble();
		double b = sc.nextDouble();
		
		rmiinterfacea obj = (rmiinterfacea)Naming.lookup("ADD");
		double n = obj.addition(a, b);
		
		System.out.println("Addition : " + n);
	}
}
