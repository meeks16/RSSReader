package michaelt.rssreader;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import java.util.concurrent.ExecutionException;

public class HeadlinesActivity extends AppCompatActivity {
    EditText rssUrl;
    ReadRss rr;
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_headlines);
        rssUrl = (EditText)findViewById(R.id.RssUrlEditText);
        lv = (ListView)findViewById(R.id.listView);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_headlines, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void searchUrl(View v) throws InterruptedException, ExecutionException {
        String url = rssUrl.getText().toString();
        rr = new ReadRss(url);
        //headlines = new String[]{"yellow", "blue", "green", "red", "orange", "purple"};

        StringArrayAdapter ad = new StringArrayAdapter(rr, this);
        lv.setAdapter(ad);
    }

}
