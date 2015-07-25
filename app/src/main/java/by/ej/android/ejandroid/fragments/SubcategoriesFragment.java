package by.ej.android.ejandroid.fragments;

import android.view.View;
import android.widget.BaseAdapter;
import android.widget.ListView;

import butterknife.Bind;
import butterknife.ButterKnife;
import by.ej.android.ejandroid.R;
import by.ej.android.ejandroid.presenters.BasePresenter;
import by.ej.android.ejandroid.presenters.SubcategoriesPresenter;

/**
 * Created by etb on 21.7.15.
 */
public class SubcategoriesFragment extends BaseFragment implements SubcategoriesPresenter.View {

    @Bind(R.id.subcategories_list)ListView mList;

    @Override
    protected void injectView(View view) {
        ButterKnife.bind(this, view);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_subcategories;
    }

    @Override
    protected BasePresenter getPresenter() {
        return new SubcategoriesPresenter(this);
    }

    @Override
    public void setAdapter(BaseAdapter adapter) {
        mList.setAdapter(adapter);
    }
}
