package UDP.Bai932;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 *
 * @author khacdatdo
 */
public class Client {
    public static void main(String[] args) throws UnknownHostException, IOException {
        DatagramSocket connection = new DatagramSocket();
        
        // Gui Ma sinh vien
        String masv = ";B19DCCN170;932";
        DatagramPacket pack = new DatagramPacket(masv.getBytes(), masv.getBytes().length, InetAddress.getByName("localhost"), 2504);
        connection.send(pack);
        
        // Nhan chuoi bat ky
        byte[] rawString = new byte[1024];
        pack = new DatagramPacket(rawString, 1024);
        connection.receive(pack);
        System.out.println(new String(pack.getData()).trim());
        
        // Xu ly
        String ketqua = handle(new String(pack.getData()).trim());
        System.out.println(ketqua); // No dang xu ly sai kia 
        
        // Gui ket qua
        pack = new DatagramPacket(ketqua.getBytes(), ketqua.length(), pack.getAddress(), pack.getPort());
        connection.send(pack);
        
        // Dong ket noi
        connection.close();
    }
    
    public static String handle(String str) {
        String requestId = str.split(";")[0];
        String rawStr = str.split(";")[1];
        
        // Xu ly
        rawStr = rawStr.toLowerCase();
        for (int i = 0; i < rawStr.length(); i++) {
            char currentChar = rawStr.charAt(i);
            if (i > 0 && rawStr.charAt(i - 1) == ' ' && (currentChar >= 'a' && currentChar <= 'z')) {
                // day la ki tu dau tien cua tu
                rawStr = rawStr.substring(0, i) + (char)((int)currentChar - 32) + rawStr.substring(i + 1);
            }
        }
        return requestId + ";" + (char)((int)rawStr.charAt(0) - 32) + rawStr.substring(1);
    }
}
