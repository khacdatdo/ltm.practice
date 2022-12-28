package Bai913;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 *
 * @author khacdatdo
 */
public class Client {
    public static void main(String[] args) throws UnknownHostException, IOException, ClassNotFoundException {
        Socket connection = new Socket(InetAddress.getByName("localhost"), 2504);
        
        // Luong
        ObjectInputStream ois = new ObjectInputStream(connection.getInputStream());
        ObjectOutputStream oos = new ObjectOutputStream(connection.getOutputStream());
        
        // Gui ma sinh vien
        String masv = "B19DCCN170;913";
        oos.writeUTF(masv);
        
        // Nhan object
        Student std = (Student) ois.readObject();
        
        // Xu ly
        if (std.getGpa() <= 1) {
            std.setGpaLetter("F");
        } else if (std.getGpa() <= 2) {
            std.setGpaLetter("D");
        } else if (std.getGpa() <= 3) {
            std.setGpaLetter("C");
        } else if (std.getGpa() <= 3.7) {
            std.setGpaLetter("B");
        } else if (std.getGpa() <= 4) {
            std.setGpaLetter("A");
        }
        
        // Gui ket qua
        oos.writeObject(std); // Test sever thu xem
        
        // Dong ket noi
        ois.close();
        oos.close();
        connection.close();
    }
}
