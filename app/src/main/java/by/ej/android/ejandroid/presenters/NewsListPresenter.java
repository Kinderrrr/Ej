package by.ej.android.ejandroid.presenters;

import android.widget.BaseAdapter;

import by.ej.android.ejandroid.adapters.NewsListAdapter;
import by.ej.android.ejandroid.fragments.BaseFragment;
import by.ej.android.ejandroid.managers.DataManager;
import by.ej.android.ejandroid.model.events.FeedItem;

/**
 * Created by etb on 23.7.15.
 */
public class NewsListPresenter extends BasePresenter {

    View mView;
    NewsListAdapter mAdapter;

    public NewsListPresenter(BaseFragment fragment) {
        super(fragment);
        mView = (View) fragment;
    }

    @Override
    public void start() {
        super.start();
        mView.showSpinner();
        DataManager.from(getContext()).For(DataManager.DataType.NEWS).with("http://ej.by/news/economy/economy.rss").get();
    }

    public void onEvent(FeedItem[] feeds){

        mAdapter = new NewsListAdapter(getContext(), feeds);

        mView.hideSpinner();
        mView.setNewsAdapter(mAdapter);
    }

    @Override
    public boolean registerInBus() {
        return true;
    }

    public interface View extends BaseView{

        public void setNewsAdapter(BaseAdapter adapter);
    }
}
