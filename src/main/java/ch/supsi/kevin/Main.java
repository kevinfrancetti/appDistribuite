package ch.supsi.kevin;

import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;

public class Main {

    public static void main(String[] args){
        System.out.println("Mannaggia");
        try {
            URL url = new URL("http://www.supsi.ch/index.html");
            InetAddress address = InetAddress.getByName("www.supsi.ch");
            System.out.println("protocollo " + url.getProtocol());
            System.out.println("host " + url.getHost());
            System.out.println("file " + url.getFile());
            System.out.println("port " + url.getPort());
            System.out.println("default port " + url.getDefaultPort());
            //System.out.println("addres " + url.getHostA );
        } catch (MalformedURLException | UnknownHostException e) {
            e.printStackTrace();
        }

    }

}
