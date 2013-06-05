package com.example.customlistviewdemo;

import java.util.List;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ListItemAdapter extends BaseAdapter {

	private LayoutInflater layoutInflater;
	private List<ListItem> listListItem;
	private Context context;
	
	public  ListItemAdapter(Context context,
			List<ListItem> listListItem) {

		this.context = context;
		this.listListItem = listListItem;
		layoutInflater = LayoutInflater.from(context);
	}	
	
	@Override
	public int getCount() {
		return listListItem.size();
	}

	@Override
	public Object getItem(int position) {
		return listListItem.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View view, ViewGroup viewGroup) {
		ViewHolder viewHolder;
		
		if (view == null) {
			view = layoutInflater.inflate(R.layout.list_item, null);
			viewHolder = new ViewHolder();
			viewHolder.image = (ImageView) view.findViewById(R.id.imgIcon);
			viewHolder.text = (TextView) view.findViewById(R.id.lbText);
			view.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolder) view.getTag();
		}
		viewHolder.image.setImageResource(R.drawable.panda);
		viewHolder.text.setText(listListItem.get(position)
				.getText());

		
		return view;
	}
	
	private class ViewHolder {
		ImageView image;
		TextView text;
	}

}
