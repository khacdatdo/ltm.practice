package TCP.Character;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author khacdatdo
 */
public class Server {

    public static void main(String[] args) throws IOException {
        // Initialize socket server
        ServerSocket server = new ServerSocket(2504);

        // Loop
        while (true) {
            // Client
            Socket client = server.accept();

            BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()), 4 * 1024);
            PrintWriter pw = new PrintWriter(client.getOutputStream());

            while (!br.ready()) {
            }

            StringBuilder masv = new StringBuilder();
            int ch;
            while (br.ready() && (ch = br.read()) != -1) {
                masv.append((char) ch);
            }
            System.out.println("masv: " + masv.toString());

            String chuoi = "Hello World";
            pw.write(chuoi);
            pw.flush();

            // doi den khi co ket qua
            while (!br.ready()) {
                // do nothing
            }

            StringBuilder ketqua = new StringBuilder();
            while (br.ready() && (ch = br.read()) != -1) {
                ketqua.append((char) ch);
            }
            System.out.println("ketqua: " + ketqua.toString());

            br.close();
            pw.close();
        }
    }
}
