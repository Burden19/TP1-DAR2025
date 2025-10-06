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
            //
            DataOutputStream dos = new DataOutputStream(clientSocket.getOutputStream());
            DataInputStream dis = new DataInputStream(clientSocket.getInputStream());
            //
            while (true) {
                int x = dis.readInt();
                if (x == 0) {
                    System.out.println("Client a envoyé 0 — fin de communication.");
                    break;
                }
                System.out.println("Reçu du client: " + x);
                int nb = x * 7;
                dos.writeInt(nb); // envoie du résultat
                System.out.println("Résultat envoyé: " + nb);
            }

            //Dernière étape
            dis.close();
            dos.close();
            clientSocket.close();
            serverSocket.close();
            System.out.println("Connexion terminée");

        } catch (IOException e) {
            System.out.println("Erreur serveur : " + e.getMessage());
        }
    }
}