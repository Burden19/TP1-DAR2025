package clientPackage;
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        final String HOST = "127.0.0.1";
        final int PORT = 1234;

        try {
            //Première étape
            System.out.println("Je suis un client pas encore connecté...");

            //Deuxième étape
            Socket clientSocket = new Socket(HOST,PORT );
            System.out.println("Je suis un client connecté");
            //
            OutputStream os = clientSocket.getOutputStream();
            InputStream is = clientSocket.getInputStream();
            Scanner scanner = new Scanner(System.in);
            //
            System.out.print("Entrez un entier x : ");
            int x = scanner.nextInt();
            //
            os.write(x);
            int nb= is.read();
            System.out.println("Résultat reçu du serveur : " + nb);




            //Dernière étape
            clientSocket.close();
            System.out.println("Connexion terminée");

        } catch (IOException e) {
            System.out.println("Erreur client : " + e.getMessage());
            e.printStackTrace();

        }
    }
}
