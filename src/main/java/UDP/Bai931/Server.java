package UDP.Bai931;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 *
 * @author khacdatdo
 */
public class Server {

    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(2504);

        // Nhan masv
        byte[] masv = new byte[1024];
        DatagramPacket pack = new DatagramPacket(masv, 1024);
        socket.receive(pack);
        System.out.println(new String(pack.getData()).trim());

        // Gui chuoi
        String chuoi = "requestId;1,2,3,4,5,6,7";
        pack = new DatagramPacket(chuoi.getBytes(), chuoi.length(), pack.getAddress(), pack.getPort());
        socket.send(pack);

        // Nhan ket qua
        byte[] ketqua = new byte[1024];
        pack = new DatagramPacket(ketqua, 1024, pack.getAddress(), pack.getPort());
        socket.receive(pack);
        System.out.println(new String(pack.getData()).trim());

    }
}
