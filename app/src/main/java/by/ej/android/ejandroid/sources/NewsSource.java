package by.ej.android.ejandroid.sources;

import android.content.Context;

import com.koushikdutta.async.parser.AsyncParser;

import java.util.concurrent.Future;

import by.ej.android.ejandroid.model.events.FeedItem;
import by.ej.android.ejandroid.parsers.NewsParser;
import by.ej.android.ejandroid.sources.base.NetworkSourceImpl;
import by.ej.android.ejandroid.sources.base.Source;

/**
 * Created by etb on 23.7.15.
 */
public class NewsSource extends DataSource<String, FeedItem[]> {

    @Override
    public Source with(String param) {
        return new NewsNetworkSource(mContext, param);
    }

    @Override
    public Future getLast() {
        return null;
    }

    private class NewsNetworkSource extends NetworkSourceImpl<FeedItem[]>{


        public NewsNetworkSource(Context context, String url) {
            super(context, url);
        }

        @Override
        public AsyncParser<FeedItem[]> getParser(){
            return new NewsParser();
        }
    }
}
