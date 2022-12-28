package TCP.Character.Bai912;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 *
 * @author khacdatdo
 */
public class Client {

    public static void main(String[] args) throws UnknownHostException, IOException {
        Socket connection = new Socket("localhost", 2504);

        // Luong
        BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        PrintWriter bw = new PrintWriter(connection.getOutputStream());

        // Gui ma sinh vien
        String masv = "B19DCCN170;123";
        bw.write(masv);
        bw.flush();

        // Nhan chuoi tu server
        StringBuilder chuoi = new StringBuilder();
        int ch;
        while ((ch = br.read()) != -1) {
            chuoi.append((char) ch);

            if (!br.ready()) {
                break;
            }
        }
        System.out.println(chuoi);

        // Tach chuoi
        String[] ketqua = splitString(chuoi.toString());

        // Gui ket qua
        bw.write(ketqua[0]);
        bw.write(ketqua[1]);
        bw.flush();

        // Dong ket noi
        br.close();
        bw.close();
    }

    public static String[] splitString(String str) {
        String kytu = "";
        String conlai = "";
        for (int i = 0; i < str.length(); i++) {
            if ((str.charAt(i) < 'a' || str.charAt(i) > 'z')
                    && (str.charAt(i) < 'A' || str.charAt(i) > 'Z')
                    && (str.charAt(i) > '9' || str.charAt(i) < '0')) {
                // day la ky tu dac biet
                kytu += str.charAt(i);
            } else {
                conlai += str.charAt(i);
            }
        }
        return new String[]{kytu, conlai};
    }
}
