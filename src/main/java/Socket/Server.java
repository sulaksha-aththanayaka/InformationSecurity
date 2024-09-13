package Socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

    static int PORT = 9999;

    public static void main(String[] args) throws IOException {
        System.out.println("=== Simple Socket Server  ===");

        ServerSocket server_socket = new ServerSocket(PORT);

        try {
            while (true) {
                // Listening to incoming connection
                Socket socket = server_socket.accept();
                System.out.println("A client connected");

                try {

                    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                    BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    Scanner scan = new Scanner(System.in);

                    out.println("Welcome to the chat application");

                    while (true){
                        //Read from client
                        String msg = in.readLine();
                        System.out.println("Client says: " + msg);

                        //Write to client
                        System.out.print("Me: " );
                        String input = scan.nextLine();
                        out.println(input);
                    }

                } finally {
                    socket.close(); // Close the client socket after sending the message
                }
            }
        } finally {
            server_socket.close();
        }
    }
}
