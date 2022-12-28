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

            StringBuilder masv = new StringBuilder();
            int ch;
            while ((ch = br.read()) != -1) {
                System.out.println((char) ch);
                masv.append((char) ch);
            }
            System.out.println("masv: " + masv.toString());

            String chuoi = "Hello World";
            pw.write(chuoi);
            System.out.println(chuoi);
            pw.flush();

            StringBuilder ketqua = new StringBuilder();
            while ((ch = br.read()) != -1) {
                System.out.println((char) ch);
                ketqua.append((char) ch);
            }
            System.out.println("ketqua: " + ketqua.toString());

            br.close();
            pw.close();
        }
    }
}
