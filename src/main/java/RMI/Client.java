package RMI;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 *
 * @author khacdatdo
 */
public class Client {

    public static void main(String[] args) throws NotBoundException, MalformedURLException, RemoteException {
        Example remoteClass = (Example) Naming.lookup("rmi://localhost/test");

        int a = (int) (Math.random() * 1000);
        int b = (int) (Math.random() * 1000);
        System.out.format("%d + %d = %d", a, b, remoteClass.sum(a, b)
        );
    }
}
