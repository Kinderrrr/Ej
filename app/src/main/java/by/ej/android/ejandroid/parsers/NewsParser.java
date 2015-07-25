package by.ej.android.ejandroid.parsers;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.lang.reflect.Type;

import by.ej.android.ejandroid.model.events.FeedItem;

/**
 * Created by etb on 23.7.15.
 */
public class NewsParser extends BaseHtmlParser<FeedItem[]> {
    @Override
    protected FeedItem[] parseHtml(String html) {

        Document doc = Jsoup.parseBodyFragment(html);
        Element body = doc.body();
        Elements titleElem;
        titleElem =  body.getElementsByTag("title");
        FeedItem[] titles = new FeedItem[titleElem.size()];
        for (int i = 0; i < titleElem.size(); i++) {

            String title = titleElem.get(i).text();
            titles[i]=new FeedItem(title);
        }

        return titles;

    }

    @Override
    public Type getType() {
        return FeedItem[].class;
    }
}
