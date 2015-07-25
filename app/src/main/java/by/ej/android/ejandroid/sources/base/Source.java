package by.ej.android.ejandroid.sources.base;

import java.util.concurrent.Future;

/**
 * Created by etb on 21.7.15.
 */
public interface Source<T> {

    public void get();

    public Future<T> makeWithFuture();

    public Future<T> getLast();
}
