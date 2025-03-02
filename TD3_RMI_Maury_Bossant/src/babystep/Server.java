package babystep;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {

	public static void main(String[] args) throws RemoteException, AlreadyBoundException {

		IPrinter printer = new Printer();
		Registry registry = LocateRegistry.createRegistry(1234); // create so embedded

		// here the server will wait for remote access while the printer is in the
		// registery
		registry.rebind("LinePrinter", printer);

	}

}
