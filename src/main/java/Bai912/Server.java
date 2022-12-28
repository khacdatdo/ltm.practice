package Bai912;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
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
            
            // Luong ghi
            BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
            
            // Nhan ma sinh vien
            StringBuilder masv = new StringBuilder();
            int ch;
            while ((ch = br.read()) != -1) {
                masv.append((char) ch);
                
                if (!br.ready()) break;
            }
            System.out.println(masv);
            
            // Gui 1 chuoi bat ki cho client
            String chuoi = "dhaksh27912372*&^^%%&^%&9";
            bw.write(chuoi);
            bw.flush();
            
            // Nhan 2 chuoi ket qua
            // Thoi doan nay nhan 1 chuoi thoi
            StringBuilder ketqua = new StringBuilder();
            
            while ((ch = br.read()) != -1) {
                ketqua.append((char) ch);
                if (!br.ready()) break;
            }
            System.out.println(ketqua); // Day la chuyen cua server, viet vao cho ai doc con biet
            
            // Dong ket noi
            br.close();
            bw.close();
        }
    }
}