package serverPackage;

import res.Operation;

import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(1234);
            System.out.println("Je suis un serveur en attente la connexion d'un client ");

            Socket clientSocket = serverSocket.accept();
            System.out.println("Un client est connecté");

            ObjectInputStream ois = new ObjectInputStream(clientSocket.getInputStream());
            ObjectOutputStream oos = new ObjectOutputStream(clientSocket.getOutputStream());

            Operation operation = (Operation) ois.readObject();

            String error = operation.validate();
            if (error != null) {
                operation.setErrorMessage(error);
            } else {
                switch (operation.getOperator()) {
                    case "+":
                        operation.setResultat(operation.getOperand1() + operation.getOperand2());
                        break;
                    case "-":
                        operation.setResultat(operation.getOperand1() - operation.getOperand2());
                        break;
                    case "*":
                        operation.setResultat(operation.getOperand1() * operation.getOperand2());
                        break;
                    case "/":
                        if (operation.getOperand2() == 0) {
                            operation.setErrorMessage("Division par zéro");
                        } else {
                            operation.setResultat(operation.getOperand1() / operation.getOperand2());
                        }
                        break;
                    default:
                        operation.setErrorMessage("Opérateur non supporté");
                        break;
                }
            }
            oos.writeObject(operation);

            ois.close();
            oos.close();
            clientSocket.close();
            serverSocket.close();
            System.out.println("Connexion terminée");

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erreur serveur : " + e.getMessage());
        }
    }
}