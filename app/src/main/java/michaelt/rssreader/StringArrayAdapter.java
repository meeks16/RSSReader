package michaelt.rssreader;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by test on 10/19/15.
 */
public class StringArrayAdapter extends BaseAdapter{

    Context myContext;
    LayoutInflater myInflator;
    ReadRss myDataSource;

    public StringArrayAdapter(ReadRss ds, Context c){

        myDataSource = ds;
        myContext = c;
        myInflator = (LayoutInflater)myContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return myDataSource.getListSize();
    }

    @Override
    public Object getItem(int arg0){
//        return myDataSource.indexOf(arg0);
        return null;
    }

    @Override
    public long getItemId(int arg0) {
        return 0;
    }

    @Override
    public View getView(int arg0, View arg1, ViewGroup arg2){
        //creat the cell and populate it with an element of an array
        TextView title;
        TextView desc;
        TextView link;

        if (arg1 == null)
            arg1 = myInflator.inflate(R.layout.list_item_layout, arg2, false);

        title = (TextView)arg1.findViewById(R.id.title);
        title.setText(myDataSource.getTitleList().get(arg0));

        desc = (TextView)arg1.findViewById(R.id.description);
        desc.setText(myDataSource.getDescriptionList().get(arg0));

        link = (TextView)arg1.findViewById(R.id.link);
        link.setText(myDataSource.getLinkList().get(arg0));

        return arg1;
    }


}
