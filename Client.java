import java.net.*;
import java.io.*;
import java.util.Scanner;

class Client {
    public static void main(String[] args) {
        try {
            // creates a new socket to request connection to server
            Socket socket = new Socket("192.168.1.134", 4999);
            System.out.println("Connected to the server.");

            // Lets user write data to output
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.print("Enter message: ");
                String message = scanner.nextLine();

                out.println(message);  // Send message to the server

                String serverResponse = in.readLine();  // Read response from the server
                System.out.println("Server says: " + serverResponse);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
