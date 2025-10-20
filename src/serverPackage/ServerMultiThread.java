package serverPackage;
import java.io.*;
import java.net.*;

public class ServerMultiThread {
    public static void main(String[] args) {
        int port = 1234;
        int clientCount = 0;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("le serveur est connecte sur le port: " + port);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                clientCount++;
                System.out.println("Un nouveau client numero #" + clientCount+" est connecte");
                new Thread(new ClientHandler(clientSocket, clientCount)).start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ClientHandler implements Runnable {
    private Socket socket;
    private int clientId;

    public ClientHandler(Socket socket, int clientId) {
        this.socket = socket;
        this.clientId = clientId;
    }

    @Override
    public void run() {
        try {
            InetSocketAddress remoteAddress = (InetSocketAddress) socket.getRemoteSocketAddress();
            String clientIP = remoteAddress.getAddress().getHostAddress();
            int clientPort = remoteAddress.getPort();

            System.out.println("Client n°" + clientId + " est connecte avec l'IP: " + clientIP + " sur le port: " + clientPort);

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            out.println("Votre ordre de communication est : #" + clientId);

            String message;
            while ((message = in.readLine()) != null) {
                System.out.println("Client #" + clientId + " a dit : " + message);
                out.println(" Le Server a reçoit: " + message);
            }

            socket.close();
        } catch (IOException e) {
            System.out.println("Client #" + clientId + " est deconnecté.");
        }
    }
}
