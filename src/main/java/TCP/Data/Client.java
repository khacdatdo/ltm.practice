package TCP.Data;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 *
 * @author khacdatdo
 */
public class Client {

    public static void main(String[] args) throws UnknownHostException, IOException {
        // Khởi tạo kết nối đến server
        Socket connection = new Socket(InetAddress.getLocalHost(), 2504);

        // Khởi tạo 2 luồng đọc và ghi
        DataInputStream dis = new DataInputStream(connection.getInputStream()); // Đọc
        DataOutputStream dos = new DataOutputStream(connection.getOutputStream()); // Ghi

        // Gửi mã sinh viên kèm mã câu hỏi (qCode)
        dos.writeUTF("B19DCCN170;123");

        // Nhận về hai số a và b
        int a = dis.readInt();
        int b = dis.readInt();
        System.out.format("a = %d, b = %d\n", a, b);

        // Xử lý
        int result = handle(a, b);
        System.out.println("result: " + result);

        // Gửi trả kết quả
        dos.writeInt(result);

        // Đóng kết nối
        dis.close();
        dos.close();
    }

    public static int handle(int a, int b) {
        // Tính tổng 2 số
        return a + b;
    }
}
