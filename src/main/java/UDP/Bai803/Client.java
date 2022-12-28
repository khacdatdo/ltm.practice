package UDP.Bai803;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Arrays;

/**
 *
 * @author khacdatdo
 */
public class Client {

    public static void main(String[] args) throws SocketException, SocketException, IOException {
        DatagramSocket socket = new DatagramSocket();

        // Gui chuoi ma sinh vien
        String masv = ";B19DCCN170;803";
        DatagramPacket pack = new DatagramPacket(masv.getBytes(), masv.length(), InetAddress.getByName("localhost"), 2504);
        socket.send(pack);

        // Nhan chuoi
        byte[] chuoi = new byte[1024];
        pack = new DatagramPacket(chuoi, 1024, pack.getAddress(), pack.getPort());
        socket.receive(pack);
        System.out.println(new String(pack.getData()).trim());

        // Xu ly
        String result = handle(new String(pack.getData()).trim());
        System.out.println(result);

        // Gui ket qua
        pack = new DatagramPacket(result.getBytes(), result.length(), pack.getAddress(), pack.getPort());
        socket.send(pack);

        // Dong ket noi
        socket.close();
    }

    public static String handle(String chuoi) {
        String requestId = chuoi.split(";")[0];
        String data = chuoi.split(";")[1];

        // Tim ki tu xuat hien nhieu nhat
        int[] markArray = new int[255];
        Arrays.fill(markArray, 0);
        int max = 0;
        int position = 0;
        for (int i = 0; i < data.length(); i++) {
            char letter = data.charAt(i);
            markArray[(int) letter]++;
            if (markArray[(int) letter] > max) {
                max = markArray[(int) letter];
                position = i;
            }
        }
        String indexes = "";
        int index = 0;
        while ((index = data.indexOf(data.charAt(position), index)) != -1) {
            indexes += index + ",";
            index++;
        }
        return requestId + ";" + data.charAt(position) + ":" + indexes;
    }
}
