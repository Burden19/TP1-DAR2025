package clientPackage;
import java.io.*;
import java.net.*;
public class Client {
    public static void main(String[] args) {
        final String HOST = "localhost"; // à remplacer par l'adresse IP plus tard
        final int PORT = 1234;

        try {
            //Première étape
            System.out.println("Je suis un client pas encore connecté...");

            //Deuxième étape
            Socket socket = new Socket("127.0.0.1", 1234);
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
