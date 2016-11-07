package tcp;

import java.io.*;
import java.net.Socket;

public class TcpSocket {

    public static void main(String[] args) {
        TcpSocket t = new TcpSocket();
        t.open();
    }

    void open() {
        try {
            Socket s = new Socket("192.168.1.222", 9997);
            OutputStream out = s.getOutputStream();
            PrintWriter output = new PrintWriter(out, false);
            output.println("A55A1001AAAAAAAAAAAAAAAABBBBBBBBBBBB1355AA ");
            BufferedReader input = new BufferedReader(new InputStreamReader(s.getInputStream()));
            String message = input.readLine();
            System.out.println(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
