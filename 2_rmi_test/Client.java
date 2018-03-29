import java.rmi.*;
import java.io.*;

public class Client {
    public static void main(String[] args) {
        try {
            ClientUpper obj = (ClientUpper)Naming.lookup("rmi://na.coder17.com:1025/UpperString");
            String r = obj.upperCase("abcd");
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            String input = null;
            System.out.println("Type quit to terminate.");
            do {
                input = in.readLine();
                System.out.println(obj.upperCase(input));
            } while (!input.equals("quit"));
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}
