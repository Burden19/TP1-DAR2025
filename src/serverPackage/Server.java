package serverPackage;
import java.io.*;
import java.net.*;
public class Server {
    public static void main(String[] args) {
        try {
            //Première étape
            ServerSocket serverSocket = new ServerSocket(1234);
            System.out.println("Je suis un serveur en attente la connexion d'un client ");

            //Deuxième étape
            Socket clientSocket = serverSocket.accept();
            System.out.println("Un client est connecté");

            //Dernière étape
            clientSocket.close();
            serverSocket.close();
            System.out.println("Connexion terminée");

        } catch (IOException e) {
            System.out.println("Erreur serveur : " + e.getMessage());
            e.printStackTrace();
        }
    }
}