package Socket3;

import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.DataInputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;
import java.nio.file.Path;
import java.nio.file.Files;
import java.io.IOException;

public class Client {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        try {
            Socket s = new Socket("localhost", 2000);
            System.out.println("Connesso a localhost:2000");
            OutputStream os = s.getOutputStream();
            InputStream is = s.getInputStream();

            System.out.println("Inserisci il percorso del file da inviare:");
            String file = scanner.nextLine();
            DataOutputStream dos = new DataOutputStream(os);
            DataInputStream dis = new DataInputStream(is);
            dos.writeUTF(file);
            dos.flush();

            String contenuto = dis.readUTF();
            try {
                // Percorso relativo che funziona solamente se lanciato dalla directory principale
                // della repo altrimenti bisogna specificare il percorso assoluto
                Path percorso = Path.of("file_socket/output.txt");
                Files.writeString(percorso, contenuto);
            }catch (IOException e) {
                System.out.println("Errore nella scrittura del file");
            }
            

            //chiudiamo scanner e socket
            scanner.close();           
            s.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
