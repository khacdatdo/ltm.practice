package TCP.Data;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author khacdatdo
 */
public class Server {

    public static void main(String[] args) throws IOException {
        // Khởi tạo server tại cổng 2504
        ServerSocket server = new ServerSocket(2504);

        while (true) {
            // Khi có client kết nối thì accept
            Socket client = server.accept();

            // Khởi tạo luồng đọc và ghi
            DataInputStream dis = new DataInputStream(client.getInputStream());
            DataOutputStream dos = new DataOutputStream(client.getOutputStream());

            System.out.println("--------------");

            // Nhận mã sinh viên và mã câu hỏi
            String masv = dis.readUTF();
            System.out.println("masv: " + masv);

            // Gửi cho client 2 số a và b
            int a = (int) (Math.random() * 1000); // random
            int b = (int) (Math.random() * 1000); // random
            dos.writeInt(a);
            dos.writeInt(b);
            System.out.format("a = %d, b = %d\n", a, b);

            // Nhận kết quả
            int result = dis.readInt();
            System.out.println("result from client: " + result);

            // Đóng kết nối
            dis.close();
            dos.close();
        }
    }
}
