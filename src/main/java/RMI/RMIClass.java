package RMI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author khacdatdo
 */
public class RMIClass extends UnicastRemoteObject implements Example {

    RMIClass() throws RemoteException {
        super();
    }

    @Override
    public int sum(int a, int b) {
        System.out.println("Co thang vua goi den");
        return a + b;
    }

}
