package Socket1;
import java.net.*;
import java.io.*;
import java.io.DataInputStream;


public class ServerExample {
    public static void main(String[] args){
        try{
            ServerSocket ss = new ServerSocket(2000);
            Socket s = ss.accept();
            System.out.println("Ricevuta richiesta da");

            InputStream is = s.getInputStream();
            System.out.println("Ricevuty 4 byte");

            /*
            for(int i=0; i<4; i++){
                System.out.println("Ricevuto: " + is.read());
            }
            */
            //Incapsulamento
            DataInputStream dis = new DataInputStream(is);
            int i = dis.readInt();
            // Stampa 16908060 perche sono il byte più significativo di 1,2,3 e 4.
            System.out.println("Ricevuto: " + i);
            // Ora che sul client abbiamo il DataInputStream incapsulando l'input stream vedremo i numeri 
            // normali



            s.close();
            ss.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}