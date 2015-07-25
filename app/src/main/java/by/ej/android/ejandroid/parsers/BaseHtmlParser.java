package by.ej.android.ejandroid.parsers;

import com.koushikdutta.async.DataEmitter;
import com.koushikdutta.async.DataSink;
import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.future.Future;
import com.koushikdutta.async.future.TransformFuture;
import com.koushikdutta.async.parser.AsyncParser;
import com.koushikdutta.async.parser.StringParser;

/**
 * Created by etb on 21.7.15.
 */
public abstract class BaseHtmlParser<T> implements AsyncParser<T> {

    @Override
    public Future<T> parse(DataEmitter emitter) {
        return new StringParser()
                .parse(emitter)
                .then(new TransformFuture<T, String>() {
                    @Override
                    protected void transform(String html) throws Exception {
                        T parsedData = parseHtml(html);
                         setComplete(parsedData);
                    }
                });
    }

    protected abstract T parseHtml(String html);

    @Override
    public void write(DataSink sink, T value, CompletedCallback completed) { }

}
