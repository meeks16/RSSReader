package michaelt.rssreader;

import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.ExecutionException;

/**
 * Created by test on 10/20/15.
 */
public class ReadRss {
    private ArrayList<String> titleList;
    private ArrayList<String> descriptionList;
    private ArrayList<String> linkList;
    public ArrayList<String> getTitleList(){return this.titleList;}
    public ArrayList<String> getDescriptionList(){return this.descriptionList;}
    public ArrayList<String> getLinkList(){return this.linkList;}

    public ReadRss(String url) throws ExecutionException, InterruptedException {

        String headline;
        Downloader d = new Downloader();
        d.execute(url);
        headline = d.get();
        String[] headlines = headline.split("\\<item>");
        titleList = new ArrayList<String>();
        descriptionList = new ArrayList<String>();
        linkList = new ArrayList<String>();
        int i;
        for (i = 0; i < headlines.length; i++){
            String line = headlines[i];
            titleList.add(getElement(line, "title"));
            descriptionList.add(getElement(line, "description"));
            linkList.add(getElement(line, "link"));
        }
    }
    public String getElement(String item, String key){
        String startKey = "<" + key + ">";
        String endKey = "</" + key + ">";

        int startIndex = item.indexOf(startKey, 0);
        int endIndex = item.indexOf(endKey, startIndex);

        return item.substring(startIndex + startKey.length(), endIndex);
    }

    public int getListSize(){
        return titleList.size();
    }

}