//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class ServiceCommunicator {
    private HttpURLConnection conn;
    private String url;

    public ServiceCommunicator(String url) {
        this.setURL(url);
    }

    public ServiceCommunicator() {
    }

    public void setURL(String serviceURL) {
        this.url = serviceURL;
    }

    public void connect() {
        try {
            URL url = new URL(this.url);
            URLConnection urlConnection = url.openConnection();
            this.conn = (HttpURLConnection)urlConnection;
        } catch (Exception var3) {
            System.err.println("**Error in constructor - Cannot create the URL or cannot make the connection.");
            System.exit(1);
        }

    }

    public String get() {
        String urlString = "";

        try {
            String current;
            for(BufferedReader in = new BufferedReader(new InputStreamReader(this.conn.getInputStream())); (current = in.readLine()) != null; urlString = urlString + current) {
            }

            return urlString;
        } catch (IOException var4) {
            System.err.println("**Error in get().  Cannot read from URL. [" + var4.getMessage() + "]");
            return (String)null;
        }
    }

    String getResults(String URL) {
        this.setURL(URL);
        this.connect();
        return this.get();
    }

    public static void main(String[] argv) {
        ServiceCommunicator sc = new ServiceCommunicator();
        sc.setURL("http://api.zippopotam.us/us/10011");
        sc.connect();
        String mystring = sc.get();
        System.out.println(mystring);
        sc = new ServiceCommunicator();
        System.out.println(sc.getResults("http://api.zippopotam.us/us/92024"));
        System.out.println(sc.getResults("https://itunes.apple.com/search?term=bbking\\&limit=1"));
        System.out.println("==================================");
        System.out.println(sc.getResults("http://www.google.com"));
    }
}
