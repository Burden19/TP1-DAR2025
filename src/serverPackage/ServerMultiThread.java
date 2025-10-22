package serverPackage;
import java.io.*;
import java.net.*;

import res.Operation;

public class ServerMultiThread {
    public static void main(String[] args) {
        int port = 1234;
        int clientCount = 0;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Le serveur est connecté sur le port: " + port);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                clientCount++;
                System.out.println("Nouveau client #" + clientCount + " connecté.");
                new Thread(new ClientProcess(clientSocket, clientCount)).start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ClientProcess implements Runnable {
    private Socket socket;
    private int clientId;

    public ClientProcess(Socket socket, int clientId) {
        this.socket = socket;
        this.clientId = clientId;
    }

    @Override
    public void run() {
        try {
            InetSocketAddress remoteAddress = (InetSocketAddress) socket.getRemoteSocketAddress();
            String clientIP = remoteAddress.getAddress().getHostAddress();
            int clientPort = remoteAddress.getPort();

            System.out.println("Client #" + clientId + " connecté avec l'IP: " + clientIP + " sur le port: " + clientPort);

            ObjectOutputStream out  = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            out.writeObject("Votre ordre de communication est : #" + clientId);
            out.flush();

            while (true) {
                Operation operation = (Operation) in.readObject();
                if (operation == null) break;

                operation.calcule();
                out.writeObject(operation);
                out.flush();
            }

            socket.close();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Client #" + clientId + " déconnecté.");
        }
    }
}
