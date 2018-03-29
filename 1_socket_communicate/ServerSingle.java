import java.io.*;
import java.net.*;

public class ServerSingle {
    public static void main(String[] args) {
        ServerSocket svr = null;
        Socket soc = null;
        InputStream is = null;
        OutputStream os = null;
        try {
            svr = new ServerSocket(8000);
            while (true) {
                System.out.println("Waiting for connection...");
                soc = svr.accept();
                is = soc.getInputStream();
                os = soc.getOutputStream();
                BufferedReader in = new BufferedReader(new InputStreamReader(is));
                BufferedWriter out = new BufferedWriter(new OutputStreamWriter(os));
                System.out.println("Client IP: " + soc.getInetAddress());
                System.out.println("Client port: " + soc.getPort());
                out.write(new String("Welcome! \r\n"));
                out.flush();
                while (true) {
                    String str = in.readLine();
                    System.out.println("Received: " + str);
                    if (str.equals("quit"))
                        break;
                }
                System.out.println("Exiting.");
                is.close();
                os.close();
                soc.close();
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}