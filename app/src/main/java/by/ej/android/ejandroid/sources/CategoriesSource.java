package by.ej.android.ejandroid.sources;

import android.content.Context;

import com.koushikdutta.async.parser.AsyncParser;

import java.util.Date;
import java.util.List;
import java.util.concurrent.Future;

import javax.sql.*;

import by.ej.android.ejandroid.Constants;
import by.ej.android.ejandroid.model.events.Category;
import by.ej.android.ejandroid.parsers.CategoriesParser;
import by.ej.android.ejandroid.sources.base.NetworkSourceImpl;
import by.ej.android.ejandroid.sources.base.Source;

/**
 * Created by etb on 21.7.15.
 */
public class CategoriesSource extends DataSource<Void, Category[]>{

    NetworkSourceImpl<Category[]> mNetworkSource;

    @Override
    public Source<Category[]> with(Void param) {

        mNetworkSource = new NetworkCategoriesSource(mContext, Constants.HOST);
        return mNetworkSource;
    }

    @Override
    public Future<Category[]> getLast() {
        if(mNetworkSource == null)
            return null;

        return mNetworkSource.getLast();
    }

    private class NetworkCategoriesSource extends NetworkSourceImpl<Category[]>{

        public NetworkCategoriesSource(Context context, String url) {
            super(context, url);
        }

        protected AsyncParser<Category[]> getParser(){
            return new CategoriesParser();
        }
    }
}
