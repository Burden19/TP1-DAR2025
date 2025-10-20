package clientPackage;
import java.io.*;
import java.net.*;

public class Client2 {
    public static void main(String[] args) {
        try (
                Socket socket = new Socket("localhost", 1234);
                BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))
        ) {
            String orderMessage = in.readLine();
            if (orderMessage != null) {
                System.out.println(orderMessage);
            }

            System.out.println("Client est connecté, tapez un message:");

            String message;
            while ((message = input.readLine()) != null) {
                out.println(message);
                System.out.println(in.readLine());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
