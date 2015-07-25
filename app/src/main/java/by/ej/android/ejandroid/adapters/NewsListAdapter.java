package by.ej.android.ejandroid.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import by.ej.android.ejandroid.R;
import by.ej.android.ejandroid.model.events.FeedItem;

/**
 * Created by etb on 23.7.15.
 */
public class NewsListAdapter extends ArrayAdapter<FeedItem> {


    public NewsListAdapter(Context context, FeedItem[] items) {
        super(context, 0, items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_feed, null);

            ViewHolder holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }

        ViewHolder holder = (ViewHolder) convertView.getTag();
        holder.mmFeedTitle.setText(getItem(position).title);

        return convertView;


    }

    static class ViewHolder{

        @Bind(R.id.news_item_title)TextView mmFeedTitle;

        public ViewHolder(View view){
            ButterKnife.bind(this, view);
        }
    }
}
