package clientPackage;
import java.io.*;
import java.net.*;
import res.Operation;

public class Client {
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
                System.out.print("Entrez le premier opérande(tappez exit pour quitter): ");
                String operand1Str = consoleInput.readLine();
                if (operand1Str.equalsIgnoreCase("exit") || operand1Str.equalsIgnoreCase("quitter")) {
                    continueOperations = false;
                    break;
                }

                System.out.print("Entrez l'opérateur (+, -, *, /)(tappez exit pour quitter): ");
                String operator = consoleInput.readLine().trim();
                if (operator.equalsIgnoreCase("exit") || operator.equalsIgnoreCase("quitter")) {
                    continueOperations = false;
                    break;
                }

                System.out.print("Entrez le deuxième opérande(tappez exit pour quitter): ");
                String operand2Str = consoleInput.readLine();
                if (operand2Str.equalsIgnoreCase("exit") || operand2Str.equalsIgnoreCase("quitter")) {
                    continueOperations = false;
                    break;
                }

                try {
                    double operand1 = Double.parseDouble(operand1Str);
                    double operand2 = Double.parseDouble(operand2Str);

                    Operation operation = new Operation(operand1, operator, operand2);
                    out.writeObject(operation);
                    out.flush();

                    Operation resultOperation = (Operation) in.readObject();

                    if (resultOperation.getErrorMessage() != null) {
                        System.out.println("Erreur: " + resultOperation.getErrorMessage());
                    } else {
                        System.out.println("Résultat: " + resultOperation.getResultat());
                    }

                } catch (NumberFormatException e) {
                    System.out.println("Erreur: Veuillez entrer des nombres valides.");
                }
            }

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
