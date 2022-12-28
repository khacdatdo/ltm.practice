package RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author khacdatdo
 */
public interface Example extends Remote {
    public int sum(int a, int b) throws RemoteException;
}
