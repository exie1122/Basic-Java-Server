import java.net.*;
import java.io.*;

public class Server {
    // the port #, change it to what port you want to use
    private static int port = 4999;

    public static void main(String[] args) {

        // variables are left as null to use across a number of blocks of code
        ServerSocket serverSocket = null;
        Socket clientSocket = null;
        PrintWriter out = null;
        BufferedReader in = null;

        try {
            serverSocket = new ServerSocket(port); // Making the ServerSocket
            System.out.println("Server has been started on port:" + " " + port);

            clientSocket = serverSocket.accept(); // Will create a new socket if ServerSocket accepts a request
            System.out.println("client connected");

            // Stream to send data
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            // stream to receive data
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            
            String inputLine;

            // Keep reading lines from the client
            while ((inputLine = in.readLine()) != null) {
                System.out.println("Client: " + inputLine);
                out.println("Echo: " + inputLine); // Send a response back to the client
            }
        } catch (IOException e) {
            System.out.println("Exception when trying to listen on port " + port + " or listening for a connection");
            e.printStackTrace();
        }
        }
    }

