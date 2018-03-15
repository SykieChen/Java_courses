import java.io.*;
import java.net.*;

public class ServerThread extends Thread {
    Socket soc = null;
    InputStream is = null;
    OutputStream os = null;

    public ServerThread(Socket s) {
        soc = s;
    }

    public void run() {
        try {
            is = soc.getInputStream();
            os = soc.getOutputStream();
            BufferedReader in = new BufferedReader(new InputStreamReader(is));
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(os));
            String ip = soc.getInetAddress().toString();
            String port = Integer.toString(soc.getPort());
            System.out.println("Client IP: " + ip);
            System.out.println("Client port: " + port);
            out.write(new String("Welcome! \r\n"));
            out.flush();
            while (true) {
                String str = in.readLine();
                System.out.println(ip + ":" + port + " Received: " + str);
                if (str.equals("quit"))
                    break;
            }
            System.out.println(ip + ":" + port + " Exiting.");
            is.close();
            os.close();
            soc.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}