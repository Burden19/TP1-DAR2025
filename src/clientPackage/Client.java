package clientPackage;

import res.Operation;

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

            ObjectOutputStream oos = new ObjectOutputStream(clientSocket.getOutputStream());
            ObjectInputStream ois = new ObjectInputStream(clientSocket.getInputStream());
            Scanner scanner = new Scanner(System.in);

            System.out.print("Entrez un entier : ");
            String op1Str = scanner.nextLine();
            System.out.print("Entrez une opération : ");
            String operateur = scanner.nextLine();
            System.out.print("Entrez le 2ème entier : ");
            String op2Str = scanner.nextLine();

            double op1 = Double.parseDouble(op1Str);
            double op2 = Double.parseDouble(op2Str);

            Operation operation = new Operation(op1, operateur, op2);
            oos.writeObject(operation);

            Operation response = (Operation) ois.readObject();

            if (response.getErrorMessage() != null) {
                System.out.println("Erreur : " + response.getErrorMessage());
            } else {
                System.out.println("Résultat reçu du serveur : " + response.getResultat());
            }

            ois.close();
            oos.close();
            scanner.close();
            clientSocket.close();
            System.out.println("Connexion terminée");

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erreur client : " + e.getMessage());
        }
    }
}
