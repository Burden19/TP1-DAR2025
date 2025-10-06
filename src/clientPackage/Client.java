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
            DataOutputStream dos = new DataOutputStream(clientSocket.getOutputStream());
            DataInputStream dis = new DataInputStream(clientSocket.getInputStream());
            Scanner scanner = new Scanner(System.in);
            //
            while (true) {
                System.out.print("Entrez un entier (tapez 0 pour quitter) : ");
                int x = scanner.nextInt();
                dos.writeInt(x);
                if (x == 0) {
                    System.out.println("Fermeture de la connexion...");
                    break;
                }

                int nb = dis.readInt(); // lit le résultat
                System.out.println("Résultat reçu du serveur : " + nb);
            }
            //Dernière étape
            scanner.close();
            dis.close();
            dos.close();
            clientSocket.close();
            System.out.println("Connexion terminée");

        } catch (IOException e) {
            System.out.println("Erreur client : " + e.getMessage());


        }
    }
}
