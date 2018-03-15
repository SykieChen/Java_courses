import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        try {
			Socket soc = null;
			InputStream is = null;
			OutputStream os = null;
			try {
				soc = new Socket("localhost", 8000);
				System.out.println("Connecting...");
				is = soc.getInputStream();
				os = soc.getOutputStream();
				System.out.println("Server address: " + soc.getInetAddress());
				System.out.println("Server port: " + soc.getPort());
				BufferedReader in = new BufferedReader(new InputStreamReader(is));
				BufferedWriter out = new BufferedWriter(new OutputStreamWriter(os));
				System.out.println("Received: " + new String(in.readLine()));
				in = new BufferedReader(new InputStreamReader(System.in));
				String msg = null;
				do {
					msg = in.readLine();
					out.write(msg + "\r\n");
					out.flush();
				} while (!msg.equals("quit"));
				System.out.println("Exiting.");
			} catch (Exception e) {
				System.out.println("Error: " + e);
			} finally {
				is.close();
				os.close();
				soc.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}