package TCP.Data;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author khacdatdo
 */
public class Server {

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(2504);

        while (true) {
            Socket client = server.accept();
        }
    }
}
