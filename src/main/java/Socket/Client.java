package Socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    static int PORT = 9999;

    public static void main(String[] args) throws IOException {
        System.out.println("=== Simple client ===");

        InetAddress ip_address = InetAddress.getLocalHost();

        Socket socket = new Socket(ip_address, PORT);

        System.out.println("Server connected");

        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        Scanner scan = new Scanner(System.in);

        try{
             while(true){
                 //Read from server
                 String msg = in.readLine();
                 System.out.println("Server says: " + msg);

                //Write to server
                 System.out.print("Me: " );
                 String input = scan.nextLine();
                 out.println(input);
             }
        } finally {
            socket.close();
            in.close();
        }

    }
}
