package by.ej.android.ejandroid.fragments;

import android.view.View;
import android.widget.BaseAdapter;
import android.widget.ListView;

import butterknife.Bind;
import butterknife.ButterKnife;
import by.ej.android.ejandroid.R;
import by.ej.android.ejandroid.presenters.BasePresenter;
import by.ej.android.ejandroid.presenters.NewsListPresenter;

/**
 * Created by etb on 23.7.15.
 */
public class NewsListFragment extends BaseFragment implements NewsListPresenter.View{

    @Bind(R.id.news_list)ListView mList;

    @Override
    protected void injectView(View view) {
        ButterKnife.bind(this, view);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_news_list;
    }

    @Override
    protected BasePresenter getPresenter() {
        return new NewsListPresenter(this);
    }

    @Override
    public void setNewsAdapter(BaseAdapter adapter) {
        mList.setAdapter(adapter);
    }
}
