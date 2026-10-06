package Socket2;

import java.io.DataInputStream;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args){
        try{
            ServerSocket ss = new ServerSocket(2000);
            Socket s = ss.accept();
            System.out.println("Ricevuta richiesta da");

            InputStream is = s.getInputStream();
            System.out.println("Ricevuty 4 byte");

            DataInputStream dis = new DataInputStream(is);
            String reverse = dis.readUTF();
            
            for (int i = reverse.length() - 1; i >= 0; i--) {
                System.out.print(reverse.charAt(i));
            }



            s.close();
            ss.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
