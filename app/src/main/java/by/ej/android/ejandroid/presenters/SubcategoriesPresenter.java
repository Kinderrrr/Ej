package by.ej.android.ejandroid.presenters;


import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

import by.ej.android.ejandroid.adapters.ListViewAdapter;
import by.ej.android.ejandroid.fragments.SubcategoriesFragment;

/**
 * Created by etb on 21.7.15.
 */
public class SubcategoriesPresenter extends BasePresenter {

    View mView;

    public SubcategoriesPresenter(SubcategoriesFragment fragment) {
        super(fragment);
      mView=fragment;
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
        InitList();

    }

    @Override
    public void stop() {

    }

    public static interface View extends BaseView {

        public void showSpinner();

        public void setAdapter(BaseAdapter adapter);
    }

}
