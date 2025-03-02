package chatserver.v1;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.LinkedList;
import java.util.List;

public class ChatRoom extends UnicastRemoteObject implements IChatRoom {

	private static final long serialVersionUID = 1L;

	private String name;
	private List<IParticipant> users;

	protected ChatRoom(String name) throws RemoteException {
		this.name = name;
		this.users = new LinkedList<IParticipant>();
	}

	/*
	 * (cours)
	 * https://im2ag-moodle.univ-grenoble-alpes.fr/pluginfile.php/13913/mod_resource
	 * /content/20/RMI.pdf we are at the chatRoom first version
	 * 
	 * https://im2ag-moodle.univ-grenoble-alpes.fr/pluginfile.php/62572/mod_resource
	 * /content/18/Projet-RMI.pdf
	 * 
	 * -----------------------------------------------------------------------------
	 * - HERE we drew the object graph we created the interfaces todo : create and
	 * fill the implementations of the interfaces and create the client and server
	 * 
	 */

	@Override
	public String name() throws RemoteException {
		return this.name;
	}

	@Override
	public void connect(IParticipant p) throws RemoteException {
		users.add(p);
	}

	@Override
	public void leave(IParticipant p) throws RemoteException {
		users.remove(p);
	}

	@Override
	public String[] who() throws RemoteException {
		Object[] connected = users.toArray();
		int len = connected.length;
		String[] nameOfConnected = new String[len];
		for (int i = 0; i < len; i++) {
			nameOfConnected[i] = ((IParticipant) connected[i]).name();
		}
		return nameOfConnected;
	}

	/*
	 * For each participant in the chatRoom except the sender it gets ths stub from
	 * the registry and invokes the receive method
	 */
	@Override
	public void send(IParticipant p, String msg) throws RemoteException, NotBoundException {
		Registry reg = LocateRegistry.getRegistry(1234);

		for (IParticipant part : users) {

			if (!part.equals(p)) {
				reg.lookup(part.name());
				part.receive(p.name(), msg);
			}
		}
	}

}
