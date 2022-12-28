package RMI;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author khacdatdo
 */
public class Server {
    public static void main(String[] args) throws RemoteException, MalformedURLException {
        Registry registry = LocateRegistry.createRegistry(1099);
        
        RMIClass rmiClass = new RMIClass();
        Naming.rebind("rmi://localhost/test", rmiClass);
        System.out.println("Binded");
    }
}
