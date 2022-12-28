package Bai802;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 *
 * @author khacdatdo
 */
public class Client {
    public static void main(String[] args) throws SocketException, UnknownHostException, IOException {
        DatagramSocket socket = new DatagramSocket();
        
        // Gui ma sinh vien
        String masv = ";B19DCCN170;208";
        DatagramPacket pack = new DatagramPacket(masv.getBytes(), masv.length(), InetAddress.getByName("localhost"), 2504);
        socket.send(pack);
        
        // Nhan chuoi
        byte[] chuoi = new byte[500];
        pack = new DatagramPacket(chuoi, 500, pack.getAddress(), pack.getPort());
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
        String[] splitedString = chuoi.split(";");
        String requestId = splitedString[0];
        int n = Integer.parseInt(splitedString[1].trim());
        String daySo = splitedString[2];
        String[] arr = daySo.split(",");
        boolean[] markArr = new boolean[100];
        for (int i = 0; i < arr.length; i++) {
            markArr[Integer.parseInt(arr[i])] = true;
        }
        String dayConThieu = "";
        for (int i = 1; i <= n; i++) {
            if (markArr[i] != true) {
                dayConThieu += "," + i;
            }
        }
        return requestId + ";" + dayConThieu.substring(1);
    }
}
