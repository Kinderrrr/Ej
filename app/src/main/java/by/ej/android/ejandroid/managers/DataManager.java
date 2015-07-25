package by.ej.android.ejandroid.managers;

import android.content.Context;

import by.ej.android.ejandroid.sources.CategoriesSource;
import by.ej.android.ejandroid.sources.DataSource;
import by.ej.android.ejandroid.sources.NewsSource;

/**
 * Created by etb on 21.7.15.
 */
public class DataManager {

    private Context mContext;
    private static DataManager sInstance;

    public enum DataType{

        CATEGORIES(new CategoriesSource()),
        NEWS(new NewsSource());

        private DataSource mmSource;

        private DataSource getSource(Context context){
            mmSource.setContext(context);
            return mmSource;
        }

        private DataType(DataSource source){
            mmSource = source;
        }
    }

    private DataManager(Context context){
        mContext = context;
    }

    public static DataManager from(Context context){
        if(sInstance == null)
            sInstance = new DataManager(context);

        return sInstance;
    }

    public DataSource For( DataType type){
        return type.getSource(mContext);
    }
}
