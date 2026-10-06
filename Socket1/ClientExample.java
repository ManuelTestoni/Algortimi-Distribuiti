package Socket1;
import java.net.*;
import java.io.*;

public class ClientExample {
    public static void main(String[] args) {
        try {
            Socket s = new Socket("localhost", 2000);
            System.out.println("Connesso a localhost:2000");
            OutputStream os = s.getOutputStream();

            /* 
            for (int i = 0; i<4; i++) {
                os.write(i+1);
            }
            */

            DataOutputStream dos = new DataOutputStream(os);
            dos.writeInt(2398);            

            s.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
