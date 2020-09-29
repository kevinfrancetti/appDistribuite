package ch.supsi.kevin.http;

import java.io.*;
import java.net.*;
import java.util.List;
import java.util.Map;

/**
 * Esercizio 1
 * Questa classe fa una chiamata http versolo l'indizzo supsi.ch e ne mostra gli headers
 * più un po di infomrazioni interessanti che mi interessava vedere
 */
public class Esercizio1 {

    //Provando ad utilizzare URLconnection
    public static void test1(){

        try {
            String test = "http://192.168.56.1:5000";
            String test1 = "http://www.supsi.ch";
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(test).openConnection();
            System.out.println(httpURLConnection.getClass());
//            System.out.println(httpURLConnection instanceof HttpURLConnection);

            //httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setRequestProperty("cualo", "fagiano");
            httpURLConnection.setRequestProperty("User-Agent", "ketchup/1.0");
            httpURLConnection.setRequestProperty("Hostt", "666");
            System.out.println(httpURLConnection.getRequestMethod());
            System.out.println(httpURLConnection.getURL());

            Map<String, List<String>> map = httpURLConnection.getRequestProperties();
            for(String s : map.keySet()){
                System.out.println(s + ": " + map.get(s));
            }
            httpURLConnection.connect();

            System.out.println(httpURLConnection.getResponseMessage());
            InputStream inputStream = httpURLConnection.getInputStream();
            System.out.println(inputStream.read());
            System.out.println(inputStream.read());
            httpURLConnection.getOutputStream().write('Z');
            httpURLConnection.getOutputStream().flush();

            System.out.println(httpURLConnection.getContentLength());
            //System.out.println(httpURLConnection.getContentType());

            httpURLConnection.disconnect();


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void run(){
        try {

            //URL non ha bisogno di una connessione per funzionare

            System.out.println("===URL===");
            URL url = new URL("http://www.supsi.ch");
            System.out.println("protocollo " + url.getProtocol());
            System.out.println("host " + url.getHost());
            System.out.println("file " + url.getFile());
            System.out.println("port " + url.getPort());
            System.out.println("default port " + url.getDefaultPort());
            System.out.println("getAutority() " + url.getAuthority());
            System.out.println("getPath() " + url.getPath());
            System.out.println("getQuery() " + url.getQuery());
            System.out.println("getUserInfo() " + url.getUserInfo());


            //InetAddress invece ha bisogno di collegarsi
            System.out.println("===InetAddress===");
            InetAddress address = InetAddress.getByName("www.supsi.ch");
            System.out.println("address " + address.getHostAddress() );
            System.out.println("canonical host name: " +  address.getCanonicalHostName());
            System.out.println("host name: " + address.getHostName());

            System.out.println("===CONNECTION===");
            //Apertura di uno stream verso l'inidizzo desiderato e lettura del contenuto
            File file = new File("test.html");

            /*
             * il metodo open stream di URL equivale a:
             *
             * public final InputStream openStream() throws java.io.IOException {
             *   return openConnection().getInputStream();
             * }
             * fonte: http://hg.openjdk.java.net/jdk8/jdk8/jdk/file/687fd7c7986d/src/share/classes/java/net/URL.java
            */
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            int count = 0;
            while (true){
                int s = br.read();
                if(s == -1) break;
                bw.write(s);//flush non necessario, lo fa in automatico quando viene chiuso lo stream;
                count++;
            }
            System.out.println(count);

            bw.close();
            br.close();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args){
        //run();
        test1();
    }

}
