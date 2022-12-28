package Bai932;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 *
 * @author khacdatdo
 */
public class Server {
    public static void main(String[] args) throws SocketException, IOException {
        DatagramSocket server = new DatagramSocket(2504);
        
        while (true) {
            // Nhan chuoi ma sinh vien
            byte[] masv = new byte[16];
            DatagramPacket pack = new DatagramPacket(masv, 16);
            server.receive(pack);
            System.out.println(new String(masv).trim());
            
            // Gui lai chuoi
            String chuoi = "requestId;hda haksjdh ah khsadjkahd kah skh kahskah kashd ksjh";
            pack = new DatagramPacket(chuoi.getBytes(), chuoi.getBytes().length, pack.getAddress(), pack.getPort());
            server.send(pack);
            
            // Nhan lai ket qua
            byte[] ketqua = new byte[chuoi.length() + 1];
            pack = new DatagramPacket(ketqua, ketqua.length);
            server.receive(pack);
            System.out.println(new String(ketqua).trim());
        }
    }
}
