package serverPackage;
import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(1234);
            System.out.println("Je suis un serveur en attente la connexion d'un client ");

            Socket clientSocket = serverSocket.accept();
            System.out.println("Un client est connecté");

            BufferedOutputStream bos = new BufferedOutputStream(clientSocket.getOutputStream());
            BufferedInputStream bis = new BufferedInputStream(clientSocket.getInputStream());
            PrintWriter pw = new PrintWriter(bos, true);
            BufferedReader br = new BufferedReader(new InputStreamReader(bis));

            String operation = br.readLine();
            String[] parts = operation.trim().split("\\s+");
            String messageResultat;

            if (parts.length != 3) {
                messageResultat = "Format entree invalide";
            } else {
                try {
                    double op1 = Double.parseDouble(parts[0]);
                    String operateur = parts[1];
                    double op2 = Double.parseDouble(parts[2]);
                    double resultat;
                    switch (operateur) {
                        case "+":
                            resultat = op1 + op2;
                            messageResultat = String.valueOf(resultat);
                            break;
                        case "-":
                            resultat = op1 - op2;
                            messageResultat = String.valueOf(resultat);
                            break;
                        case "*":
                            resultat = op1 * op2;
                            messageResultat = String.valueOf(resultat);
                            break;
                        case "/":
                            if (op2 == 0) {
                                messageResultat = "Division par zero";
                            } else {
                                resultat = op1 / op2;
                                messageResultat = String.valueOf(resultat);
                            }
                            break;
                        default:
                            messageResultat = "operateur invalide";
                            break;
                    }
                } catch (NumberFormatException e) {
                    messageResultat = "format du l'operation est invalide";
                }
            }

            System.out.println("Résultat: " + messageResultat);
            pw.println(messageResultat);

            bis.close();
            bos.close();
            clientSocket.close();
            serverSocket.close();
            System.out.println("Connexion terminée");

        } catch (IOException e) {
            System.out.println("Erreur serveur : " + e.getMessage());
        }
    }
}