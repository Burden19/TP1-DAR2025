package clientPackage;
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        final String HOST = "127.0.0.1";
        final int PORT = 1234;

        try {
            System.out.println("Je suis un client pas encore connecté...");

            Socket clientSocket = new Socket(HOST, PORT);
            System.out.println("Je suis un client connecté");

            BufferedOutputStream bos = new BufferedOutputStream(clientSocket.getOutputStream());
            BufferedInputStream bis = new BufferedInputStream(clientSocket.getInputStream());
            Scanner scanner = new Scanner(System.in);
            PrintWriter pw = new PrintWriter(bos, true);
            BufferedReader br = new BufferedReader(new InputStreamReader(bis));

            System.out.print("Entrez un entier : ");
            String op1 = scanner.nextLine();
            System.out.print("Entrez une opération : ");
            String operateur = scanner.nextLine();
            System.out.print("Entrez le 2ème entier : ");
            String op2 = scanner.nextLine();

            String operation = op1 + " " + operateur + " " + op2;
            pw.println(operation);

            String resultat = br.readLine();
            System.out.println("Résultat reçu du serveur : " + resultat);

            bis.close();
            bos.close();
            scanner.close();
            clientSocket.close();
            System.out.println("Connexion terminée");

        } catch (IOException e) {
            System.out.println("Erreur client : " + e.getMessage());
        }
    }
}
