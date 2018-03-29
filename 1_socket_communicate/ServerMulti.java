import java.io.*;
import java.net.*;

public class ServerMulti {
    public static void main(String[] args) {
        ServerSocket svr = null;
        Socket soc = null;

        try {
            svr = new ServerSocket(8000);
            System.out.println("Waiting for connection...");
            while (true) {
                soc = svr.accept();
                ServerThread st = new ServerThread(soc);
                new Thread(st).start();
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}