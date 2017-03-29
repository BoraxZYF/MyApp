package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.borax.myapp.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by borax on 2016/12/11.
 */

public class CardViewGalleryAdapter extends BaseAdapter {

    private Context context;
    private List<String> list = new ArrayList<String>();

    public CardViewGalleryAdapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public String getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {

        String str = list.get(i);

        View view = LayoutInflater.from(context).inflate(R.layout.cardview_item, null);
        TextView text = (TextView) view.findViewById(R.id.text);

        text.setText(str);

        return view;
    }
}
