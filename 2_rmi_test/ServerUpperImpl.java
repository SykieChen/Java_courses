import java.rmi.*;
import java.rmi.server.*;

public class ServerUpperImpl extends UnicastRemoteObject implements ClientUpper {
    public ServerUpperImpl() throws RemoteException {
        super();
    }

    public String upperCase(String s) throws RemoteException {
        return s.toUpperCase();
    }
}
