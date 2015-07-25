package by.ej.android.ejandroid.parsers;

import java.lang.reflect.Type;

import by.ej.android.ejandroid.model.events.Category;

/**
 * Created by etb on 23.7.15.
 */
public class CategoriesParser extends BaseHtmlParser<Category[]> {
    @Override
    protected Category[] parseHtml(String html) {
        return new Category[]{ new Category("test", null)};
    }

    @Override
    public Type getType() {
        return Category[].class;
    }
}
