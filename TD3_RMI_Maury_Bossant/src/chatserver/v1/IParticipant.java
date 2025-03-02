package chatserver.v1;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IParticipant extends Remote {

	/*
	 * returns the name of the participant
	 */
	public String name() throws RemoteException;
	
	/*
	 * receive a message from a chatRoom
	 */
	public void receive(String name, String msg) throws RemoteException;
	
}
