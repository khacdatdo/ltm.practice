package UDP.Bai931;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 *
 * @author khacdatdo
 */
public class Client {

    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket();

        // Gui masv
        String masv = ";B19DCCN170;931";
        DatagramPacket pack = new DatagramPacket(masv.getBytes(), masv.length(), InetAddress.getByName("localhost"), 2504);
        socket.send(pack);

        // Nhan chuoi
        byte[] chuoi = new byte[1024];
        pack = new DatagramPacket(chuoi, 1024, pack.getAddress(), pack.getPort());
        socket.receive(pack);
        System.out.println(new String(pack.getData()).trim());

        // Xu ly
        String ketqua = handle(new String(pack.getData()).trim());
        System.out.println(ketqua);

        // Gui ket qua
        pack = new DatagramPacket(ketqua.getBytes(), ketqua.length(), pack.getAddress(), pack.getPort());
        socket.send(pack);

        // Dong ket noi
        socket.close();
    }

    public static String handle(String chuoi) {
        String requestId = chuoi.split(";")[0];
        String data = chuoi.split(";")[1];
        String[] stringArr = data.split(",");

        long min = Long.parseLong(stringArr[0]);
        long max = Long.parseLong(stringArr[0]);

        for (String s : stringArr) {
            long curr = Long.parseLong(s);
            if (curr > max) {
                max = curr;
            }
            if (curr < min) {
                min = curr;
            }
        }
        return requestId + ";" + max + "," + min;
    }
}
