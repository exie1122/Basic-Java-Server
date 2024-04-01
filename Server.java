import java.net.*;
import java.io.*;
import java.util.Scanner;

public class Server {
    private static int port = 4999;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Server has been started on port: " + port);

        Socket clientSocket = serverSocket.accept();
        System.out.println("Client connected");

        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter message to send to client:");
            String messageToSend = scanner.nextLine();

            out.println(messageToSend);  // Send the message to the client

            String clientResponse = in.readLine();
            if (clientResponse == null) {
                break;  // Exit loop if the client disconnects
            }
            System.out.println("Client says: " + clientResponse);
        }
    }
}
