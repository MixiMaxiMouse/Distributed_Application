package chatserver.v1;

import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {

	public static void main(String[] args) throws RemoteException, NotBoundException, AlreadyBoundException {
		
		Registry registry = LocateRegistry.getRegistry(1234);
		
		//!\\ attention here it is the interface not the class because we want the skeleton
		IChatRoom familyGroup = (IChatRoom) registry.lookup("familyGroup");
		
		IParticipant hervé = new Participant("hervé");
		IParticipant maxime = new Participant("maxime");
		registry.bind("maxime", maxime);
		registry.bind("hervé", hervé);

		System.out.println("Client running ...");
		
		familyGroup.connect(maxime);
		familyGroup.connect(hervé);

		String[] user = familyGroup.who();
		System.out.println("Users : " + user[0] + " , " + user[1]);
		
		System.out.println("Hervé sending something ...");
		familyGroup.send(hervé, "I am Wireshark. \n "
				+ "⠀ ⢯⠙⠲⢤⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n"
				+ "⠀⠀⠸⡆⠀⠀⠈⠳⣄⠀⠀⠀⠀⠀⠀⠀\n"
				+ "⠀⠀⠀⡇⠀⠀⠀⠀⠈⢳⡀⠀⠀⠀⠀⠀\n"
				+ "⠀⠀⢰⠇⠀⠀⠀⠀⠀⠈⢷⠀⠀⠀⠀⠀\n"
				+ "⣀⡴⠒⢾⡀⣀⡴⠒⢦⣀⢀⡼⠓⢦⣀\n"
				+ "⣩⠴⠒⢶⣉⣉⡴⠒⢦⣉⣉⡴⠒⠶⣌\n"
				+ "⠁⠀⠀⠀⠈⠁⠀⠀⠀⠈⠁⠀⠀⠀⠈");
		
	}

}
