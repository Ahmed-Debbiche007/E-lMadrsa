
package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.URL;
import java.net.URLConnection;
import java.net.HttpURLConnection;

public class get_jod {

    public static void main(String[] args) throws IOException {
        URL url = new URL("http://api.fungenerators.com/fact/random");

        try{
            //make connection
            HttpURLConnection urlc = (HttpURLConnection) url.openConnection();
            urlc.setRequestMethod("GET");
            // set the content type
            urlc.setRequestProperty("Content-Type", "application/json");
            
            System.out.println("Connect to: " + url.toString());
            urlc.setAllowUserInteraction(false);
            urlc.connect();

            //get result
            BufferedReader br = new BufferedReader(new InputStreamReader(urlc.getInputStream()));
            String l = null;
            while ((l=br.readLine())!=null) {
                System.out.println(l);
            }
            br.close();
        } catch (Exception e){
            System.out.println("Error occured");
            System.out.println(e.toString());
        }
    }

}