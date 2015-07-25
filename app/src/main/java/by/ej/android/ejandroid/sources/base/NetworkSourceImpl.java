package by.ej.android.ejandroid.sources.base;

import android.content.Context;
import android.util.Log;

import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.async.parser.AsyncParser;
import com.koushikdutta.ion.Ion;

import java.util.concurrent.Future;

import de.greenrobot.event.EventBus;


public abstract class NetworkSourceImpl<T> implements Source<T> {


    private Future mFuture;
    private Context mContext;
    private String mUrl;

    public NetworkSourceImpl(Context context, String url){
        mContext = context;
        mUrl = url;
    }

    @Override
    public void get() {
        make();
    }

    @Override
    public Future<T> makeWithFuture() {
        make();
        return mFuture;
    }

    @Override
    public Future<T> getLast() {
        return mFuture;
    }

    protected  abstract <E extends AsyncParser<T>> E getParser();

    private void make(){

        mFuture = Ion.with(mContext)
                .load(mUrl)
                .as(getParser())
                .setCallback(new FutureCallback<T>() {
            @Override
            public void onCompleted(Exception e, T result) {
                Log.d("Networking", "request to:" + mUrl + " onComplete with result: " + result);
                EventBus.getDefault().post(result);
            }
        });


    }


}
