package by.ej.android.ejandroid.sources;

import android.content.Context;

import java.util.concurrent.Future;

import by.ej.android.ejandroid.sources.base.Source;

/**
 * Created by etb on 21.7.15.
 */
public abstract class DataSource<T,V> {

    protected Context mContext;

    public void setContext(Context context){
        mContext = context;
    }

    public abstract Source<V> with(T param);

    public abstract Future<V> getLast();

}
