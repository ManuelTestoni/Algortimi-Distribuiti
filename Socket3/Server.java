package Socket3;

import java.io.DataInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;

public class Server {
    public static void main(String[] args){
        try{
            ServerSocket ss = new ServerSocket(2000);
            Socket s = ss.accept();
            System.out.println("Ricevuta richiesta da localhost");

            InputStream is = s.getInputStream();
            OutputStream os = s.getOutputStream();

            //Incapsulamento
            DataInputStream dis = new DataInputStream(is);
            DataOutputStream dos = new DataOutputStream(os);
            // Percorso relativo che funziona solamente se lanciato dalla directory principale
            // della repo altrimenti bisogna specificare il percorso assoluto
            Path percorso = Path.of(dis.readUTF());
            try {
                String contenuto = Files.readString(percorso);
                dos.writeUTF(contenuto);
                dos.flush();
            }catch (IOException e){
                System.out.println("Errore nella lettura del file");
            }
            



            s.close();
            ss.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
