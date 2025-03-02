package babystep;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {

	public static void main(String[] args) throws RemoteException, NotBoundException {
		
		Registry registry = LocateRegistry.getRegistry(1234);
		
		//!\\ attention here it is the interface not the class because we want the skeleton
		IPrinter printer = (IPrinter) registry.lookup("LinePrinter"); // printer is a STUB
		printer.print("");
	}

}
