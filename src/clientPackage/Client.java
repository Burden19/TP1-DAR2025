package clientPackage;
import java.io.*;
import java.net.*;
public class Client {
    public static void main(String[] args) {
        final String HOST = "127.0.0.1";
        final int PORT = 1234;

        try {
            //Première étape
            System.out.println("Je suis un client pas encore connecté...");

            //Deuxième étape
            Socket socket = new Socket(HOST,PORT );
            System.out.println("Je suis un client connecté");

            //Dernière étape
            socket.close();
            System.out.println("Connexion terminée");

        } catch (IOException e) {
            System.out.println("Erreur client : " + e.getMessage());
            e.printStackTrace();

        }
    }
}
