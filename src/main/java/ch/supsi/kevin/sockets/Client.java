package ch.supsi.kevin.sockets;

import java.io.*;
import java.net.Socket;

public class Client {

    public static void main(String[] args){
        try {
            Socket client = new Socket("localhost", 5000);
            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            PrintWriter out = new PrintWriter (new OutputStreamWriter(client.getOutputStream()));
            BufferedReader lineReader = new BufferedReader(new InputStreamReader(System.in));

            while (true){
                String line = lineReader.readLine();
                if(line.equals("!q")) break;
                else {
                    out.println(line);
                    out.flush();
                    System.out.println(in.readLine());
                }
            }
            in.close();
            out.close();
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
