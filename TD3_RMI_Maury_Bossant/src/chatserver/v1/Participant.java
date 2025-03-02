package chatserver.v1;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Participant extends UnicastRemoteObject implements IParticipant {

	private static final long serialVersionUID = 1L;

	private String name;

	protected Participant(String name) throws RemoteException {
		this.name = name;
	}

	@Override
	public String name() throws RemoteException {
		return name;
	}

	@Override
	public void receive(String name, String msg) throws RemoteException {
		System.out.println(this.name + " received\n");
		System.out.println(name + " :\n" + msg);
	}

}
