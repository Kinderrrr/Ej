package by.ej.android.ejandroid.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import by.ej.android.ejandroid.R;
import by.ej.android.ejandroid.presenters.BasePresenter;
import de.greenrobot.event.EventBus;

/**
 * Created by etb on 21.7.15.
 */
public abstract class BaseFragment extends Fragment implements BasePresenter.BaseView{

    private boolean isLoading;
    private View mLoadingScreen;

    protected View mView;
    private BasePresenter mPresenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView = inflater.inflate(getLayoutId(), container, false);

        FrameLayout framelayout = new FrameLayout(getActivity());
        framelayout.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));

        framelayout.addView(mView);

        injectView(mView);
        return framelayout;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mPresenter = getPresenter();
    }


    private void registerPresenterInBus(){
        if(mPresenter.registerInBus())
            EventBus.getDefault().register(mPresenter);
    }

    private void unregisterPresenterInBus(){
        if(mPresenter.registerInBus())
            EventBus.getDefault().unregister(mPresenter);
    }

    @Override
    public void onStart() {
        super.onStart();
        registerPresenterInBus();

        mPresenter.start();
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.resume();
    }

    @Override
    public void onStop() {
        super.onStop();
        unregisterPresenterInBus();

        mPresenter.stop();
    }



    @Override
    public void onPause() {
        super.onPause();
        mPresenter.pause();
    }
    private void stopLoadingSpinner() {
        if(!isLoading) { return;}
        final View view = getFragmentView();
        if (view != null) {
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            removeLoadingSpinner(viewGroup);
        }
    }

    private void removeLoadingSpinner(ViewGroup viewGroup) {
        viewGroup.removeView(mLoadingScreen);
        isLoading = false;
    }



    private void addLoadingSpinner(ViewGroup viewGroup, LayoutInflater inflater) {
        mLoadingScreen = inflater.inflate(R.layout.include_loading, viewGroup, false);
        viewGroup.addView(mLoadingScreen);
        isLoading = true;
    }

    protected View getFragmentView(){
        return mView;
    }

    protected abstract void injectView(View view);


    @Override
    public void showSpinner() {
        startLoadingSpinner();
    }

    private void startLoadingSpinner() {
        if(isLoading) {
            return;
        }
        LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
        if(mView == null)
            return;

        ViewGroup viewGroup = (ViewGroup) getFragmentView().getParent();
        addLoadingSpinner(viewGroup, layoutInflater);

    }

    @Override
    public void hideSpinner() {
        stopLoadingSpinner();
    }


    protected abstract int getLayoutId();

    protected abstract BasePresenter getPresenter();
}
