package babystep;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Printer extends UnicastRemoteObject implements IPrinter {

	private static final long serialVersionUID = 1L;

	protected Printer() throws RemoteException {
	}

	public void print(String s) throws RemoteException {
		if (s.equals("")) {
			System.out.println("Ici le printer a Houston... vous me recevez ?");
		} else {
			System.out.println(s);
		}
	}
}
