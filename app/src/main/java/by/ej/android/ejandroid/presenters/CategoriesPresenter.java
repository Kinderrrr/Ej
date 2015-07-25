package by.ej.android.ejandroid.presenters;

import android.util.Log;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

import by.ej.android.ejandroid.adapters.ListViewAdapter;
import by.ej.android.ejandroid.fragments.CategoriesFragment;
import by.ej.android.ejandroid.model.events.Category;

/**
 * Created by etb on 21.7.15.
 */
public class CategoriesPresenter extends BasePresenter{

    View mView;

    public CategoriesPresenter(CategoriesFragment fragment){
        super(fragment);
        mView = fragment;
    }

    public void InitList() {

        List<String> mMyArray = new ArrayList<String>();
        mMyArray.add("Avto");
        mMyArray.add("Nedv");
        mMyArray.add("Heakh");

        ListViewAdapter adapter = new ListViewAdapter(getContext(), mMyArray);
        mView.setAdapter(adapter);

    }


    @Override
    public void start() {

        super.start();
        Log.d("CATEGORY", "CATEGORY");
        InitList();
    }

    public void onEvent(Category[] categories){
        mView.hideSpinner();
        Log.d("TAG", "Event");
    }

    @Override
    public boolean registerInBus() {
        return true;
    }

    public static interface View extends BaseView{

        public void setAdapter(BaseAdapter adapter);
    }
}
