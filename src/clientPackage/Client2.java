package clientPackage;
import java.io.*;
import java.net.*;

import res.Operation;

public class Client2 {
    public static void main(String[] args) {
        try (
                Socket socket = new Socket("localhost", 1234);
                ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
                ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
                BufferedReader consoleInput = new BufferedReader(new InputStreamReader(System.in))
        ) {
            String orderMessage = (String) in.readObject();
            System.out.println(orderMessage);

            boolean continueOperations = true;
            while (continueOperations) {
                System.out.print("Entrez le premier opérande: ");
                double operand1 = Double.parseDouble(consoleInput.readLine());

                System.out.print("Entrez l'opérateur (+, -, *, /): ");
                String operator = consoleInput.readLine().trim();

                System.out.print("Entrez le deuxième opérande: ");
                double operand2 = Double.parseDouble(consoleInput.readLine());

                Operation operation = new Operation(operand1, operator, operand2);
                out.writeObject(operation);
                out.flush();

                Operation resultOperation = (Operation) in.readObject();

                if (resultOperation.getErrorMessage() != null) {
                    System.out.println("Erreur: " + resultOperation.getErrorMessage());
                } else {
                    System.out.println("Résultat: " + resultOperation.getResultat());
                }
            }

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
