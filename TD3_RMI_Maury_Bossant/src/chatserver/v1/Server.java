package chatserver.v1;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {

	public static void main(String[] args) throws RemoteException, AlreadyBoundException {

		IChatRoom familyGroup = new ChatRoom("familyGroup");
		Registry registry = LocateRegistry.createRegistry(1234);

		registry.bind("familyGroup", familyGroup);

		System.out.println("Server running ...");
	}

}
