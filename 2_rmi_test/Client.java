import java.rmi.*;

public class Client {
    public static void main(String[] args) {
        try {
            ClientUpper obj = (ClientUpper)Naming.lookup("rmi://127.0.0.1:1099/UpperString");
            String r = obj.upperCase("abcd");
            System.out.println(r);
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}
