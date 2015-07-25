package by.ej.android.ejandroid.model.events;

/**
 * Created by etb on 21.7.15.
 */
public class Category {

    public final Subcategory[] subcategories;
    public final String name;

    public Category(String name, Subcategory[] subcategories){
        this.name = name;
        this.subcategories = subcategories;
    }

}
