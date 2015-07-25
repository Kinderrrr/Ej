package by.ej.android.ejandroid.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import by.ej.android.ejandroid.R;

public class ListViewAdapter extends ArrayAdapter<String> {

	
	private final Context context;
    private List<String> ListItem =new ArrayList<String>();


    public ListViewAdapter(Context context, List<String> ListItem) {
        super(context, R.layout.list_view,ListItem);
        this.context = context;
        this.ListItem = ListItem;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        
    	LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        
        View view = inflater.inflate(R.layout.list_item, parent, false);
		TextView textView1 =(TextView) view.findViewById(R.id.textViewListItem);
		textView1.setText(ListItem.get(position));
		
		
		return view;
    }
}
