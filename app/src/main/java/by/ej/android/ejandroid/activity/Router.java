package by.ej.android.ejandroid.activity;

import by.ej.android.ejandroid.fragments.BaseFragment;
import by.ej.android.ejandroid.model.events.FeedItem;

/**
 * Created by etb on 23.7.15.
 */
public interface Router {

    public void goToList();

    public void goToNewsDetails(FeedItem item);

}
