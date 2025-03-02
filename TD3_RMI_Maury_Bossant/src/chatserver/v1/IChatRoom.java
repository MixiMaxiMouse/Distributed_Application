package chatserver.v1;

import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IChatRoom extends Remote {

	/*
	 * Connect: allows a new participant to connect to a chat room
	 * 
	 * Leave: allows a participant to leave a chat room
	 * 
	 * Who: allows a participant to get the names of all participants currently
	 * connected to a chat room
	 * 
	 * Send: allows a participant to send a message to a given chat room
	 */
	/*
	 * Return the name of the ChatRoom
	 */
	public String name() throws RemoteException;

	public void connect(IParticipant p) throws RemoteException;

	public void leave(IParticipant p) throws RemoteException;

	public String[] who() throws RemoteException;

	public void send(IParticipant p, String msg) throws RemoteException, NotBoundException;

}
