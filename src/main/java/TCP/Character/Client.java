package TCP.Character;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 *
 * @author khacdatdo
 */
public class Client {

    public static void main(String[] args) throws UnknownHostException, IOException {
        // Khoi tao ket noi den server
        Socket connection = new Socket(InetAddress.getLocalHost(), 2504);

        BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()), 4 * 1024);
        PrintWriter pw = new PrintWriter(connection.getOutputStream());

        String masv = "B19DCCN170;123";
        pw.write(masv, 0, masv.length());
        pw.flush();

        StringBuilder str = new StringBuilder();
        int ch;
        while ((ch = br.read()) != -1) {
            str.append((char) ch);
            if (!br.ready()) {
                break;
            }
        }
        System.out.println(str.toString());

        pw.write(str.toString());
        pw.flush();

        br.close();
        pw.close();
    }

    public static int randomInt() {
        return (int) (Math.random() * Integer.MAX_VALUE);
    }
}
