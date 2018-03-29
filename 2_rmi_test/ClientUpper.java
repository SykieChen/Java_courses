import java.rmi.*;

public interface ClientUpper extends Remote {
	String upperCase(String s) throws RemoteException;
}