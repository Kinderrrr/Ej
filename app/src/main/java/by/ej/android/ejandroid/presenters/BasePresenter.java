package by.ej.android.ejandroid.presenters;

import android.app.Activity;
import android.content.Context;

import by.ej.android.ejandroid.activity.Router;
import by.ej.android.ejandroid.fragments.BaseFragment;

/**
 * Created by etb on 21.7.15.
 */
public class BasePresenter {

    private Context mContext;
    private Router mRouter;

    public BasePresenter(BaseFragment fragment){
        Activity activity = fragment.getActivity();
        mRouter = (Router) activity;
        mContext = activity;

    }

    protected Context getContext(){
        return mContext;
    }

    protected Router getRouter(){
        return mRouter;
    }

    public boolean registerInBus(){
        return false;
    }

    public void start(){}

    public void stop(){}

    public void pause(){}

    public void resume(){}



    public interface BaseView {

        public void showSpinner();

        public void hideSpinner();

    }


}
