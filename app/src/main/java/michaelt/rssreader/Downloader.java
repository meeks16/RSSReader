package michaelt.rssreader;

import android.os.AsyncTask;
import java.io.*;
import java.net.*;


/**
 * Created by test on 10/20/15.
 */
public class Downloader extends AsyncTask<String, Void, String>{
    public String doInBackground(String... urls){
        String rUrl = urls[0];
        try{
            URL rssUrl = new URL(rUrl);
            BufferedReader in = new BufferedReader(new InputStreamReader(rssUrl.openStream()));
            String sourceCode = "";
            String line;
            while ((line = in.readLine()) != null) {
                sourceCode +=  line;
            }
            in.close();
            return sourceCode;
        }catch (MalformedURLException ue){
            System.out.println("Malformed URL");
        }catch (IOException ioe){
            System.out.println("Something went wrong reading the content");
        }
        return null;
    }

}
