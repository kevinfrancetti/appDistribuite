package ch.supsi.kevin.old;

import java.io.*;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;

public class RenameMe {

    public static void testing(){
        System.out.println("Mannaggia");
        try {
            URL url = new URL("http://www.supsi.ch");
            InetAddress address = InetAddress.getByName("www.supsi.ch");
            System.out.println("===URL===");
            System.out.println("protocollo " + url.getProtocol());
            System.out.println("host " + url.getHost());
            System.out.println("file " + url.getFile());
            System.out.println("port " + url.getPort());
            System.out.println("default port " + url.getDefaultPort());
            System.out.println("===InetAddress===");
            System.out.println("address " + address.getHostAddress() );
            System.out.println("canonical host name: " +  address.getCanonicalHostName());
            System.out.println("host name: " + address.getHostName());
            System.out.println("===CONNECTION===");
            //URLConnection con = url.openConnection();
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
            File file = new File("test.html");
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));

            int count = 0;
            while (true){
                int s = br.read();
                if(s == -1) break;
                bw.write(s);
                count++;
            }

            System.out.println(count);
            //InputStream is = con.getInputStream();
            //System.out.println("Content lenght: " + con.getContentLength());
            bw.close();
            br.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
