package ch.supsi.kevin.sockets;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(5000);
            while (true) {
                System.out.println("In attesa di connessione...");
                Socket client = server.accept();
                System.out.println("Miao");
                BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                PrintWriter out = new PrintWriter(new OutputStreamWriter(client.getOutputStream()));
                while (true) {
                    String s = in.readLine();
                    if (s == null || s == "!q") break;
                    else {
                        System.out.println(client + ". Messaggio: " + s);
                        //StringBuffer reverse = new StringBuffer(s).reverse();
                        //out.println(reverse);
                        //out.flush();
                    }
                }
                out.write("Finito");
                in.close();
                out.close();
                client.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
