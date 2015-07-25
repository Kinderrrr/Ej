package by.ej.android.ejandroid.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;
import com.koushikdutta.ion.Response;

import java.util.List;

import by.ej.android.ejandroid.R;
import by.ej.android.ejandroid.fragments.BaseFragment;
import by.ej.android.ejandroid.fragments.NewsListFragment;
import by.ej.android.ejandroid.model.events.Category;
import by.ej.android.ejandroid.model.events.FeedItem;
import by.ej.android.ejandroid.parsers.CategoriesParser;
import de.greenrobot.event.EventBus;


public class MainActivity extends ActionBarActivity implements Router{

    public static final String TAG = MainActivity.class.getCanonicalName();
    public static final String TAG_MAIN_FRAGMENT = TAG + ".MainContainer";

    protected FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager  = getSupportFragmentManager();

        replaceMainFragment(new NewsListFragment());

    }


    public void replaceMainFragment(Fragment fragment) {
        Log.d("Fragment Replacement", fragment.getClass().getSimpleName());
        replaceMainFragment(fragment, false);
    }

    public void replaceMainFragment(Fragment fragment, boolean addToBackStack) {
        replaceMainFragment(fragment, addToBackStack, false);
    }

    public void replaceMainFragment(Fragment fragment, boolean addToBackStack, boolean allowStateLoss) {
        replaceMainFragment(fragment, addToBackStack, allowStateLoss, addToBackStack);
    }

    public void replaceMainFragment(final Fragment fragment, final boolean addToBackStack, final boolean allowStateLoss, final boolean animateWithSlide) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (fragment == null) {
                    return;
                }

                final FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                if (animateWithSlide) {
                    fragmentTransaction.setCustomAnimations(R.anim.enter_slide_from_left, R.anim.exit_slide_from_left, R.anim.pop_enter_slide_from_left, R.anim.pop_exit_slide_from_left);
                } else {
                    fragmentTransaction.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out, android.R.anim.fade_in, android.R.anim.fade_out);
                }

//                if (addToBackStack) {
                fragmentTransaction.addToBackStack(null);
//                }

                fragmentTransaction.replace(R.id.main_container, fragment, TAG_MAIN_FRAGMENT);

//                if (allowStateLoss) {
                fragmentTransaction.commitAllowingStateLoss();
//                } else {
//                    fragmentTransaction.commit();
//                }
            }
        });
    }


    @Override
    public void goToList() {
        //TODO: add replaceMainFragment(NewsListFragment)
    }

    @Override
    public void goToNewsDetails(FeedItem item) {
        //TODO: add replaceMainFragment(NewsDetailsFragment)
    }

}
