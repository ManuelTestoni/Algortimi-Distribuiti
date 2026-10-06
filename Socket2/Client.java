package Socket2;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        try {
            Socket s = new Socket("localhost", 2000);
            System.out.println("Connesso a localhost:2000");
            OutputStream os = s.getOutputStream();

            System.out.println("Inserisci una stringa da inviare al server:");
            String test = scanner.nextLine();
            DataOutputStream dos = new DataOutputStream(os);
            dos.writeUTF(test);

            //chiudiamo scanner e socket
            scanner.close();           
            s.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
