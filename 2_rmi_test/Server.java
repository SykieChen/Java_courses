import java.rmi.*;
import java.io.*;

public class Server {
    public static void main(String[] args) {
        try {
            ServerUpperImpl obj=new ServerUpperImpl();
            System.out.println("ok: ");
            Naming.rebind("rmi://localhost:1099/UpperString", obj);
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}