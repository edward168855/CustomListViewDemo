package com.example.customlistviewdemo;

import java.util.ArrayList;
import java.util.List;

import android.opengl.Visibility;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;

public class MainActivity extends Activity {

	List<ListItem> listListItem = new ArrayList<ListItem>();
	ListItemAdapter adapter = null;
	Handler handler = null; 
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		adapter = new ListItemAdapter(this, listListItem);
		addData();
		
		final ListView listView = (ListView) findViewById(R.id.listView);
		
        handler = new Handler() {
        	@Override
        	public void handleMessage(Message msg) {
                switch (msg.what) {
                case 0:
                	addData();
                	adapter.notifyDataSetChanged();
    			default:
    				break;
                }

            }

        };
		
		Button buttonFooter = new Button(this);
		buttonFooter.setText("查看更多");
        buttonFooter.setOnClickListener(new View.OnClickListener() {        
            @Override
            public void onClick(View v) {
				Message msg = new Message();
				msg.what = 0;
				handler.sendMessage(msg);
            }
        });		
		listView.addFooterView(buttonFooter);
		
		listViewBindData();	
	}
		
	void addData() {
		ListView listView = (ListView) findViewById(R.id.listView);
		int i = listView.getCount() + 1;
		for(int j = i;j < i + 15;j++) {
			ListItem item = new ListItem();
			item.setText("text" + j);
			listListItem.add(item);
		}
	}
	
	void listViewBindData() {
		ListView listView = (ListView) findViewById(R.id.listView);
		adapter.notifyDataSetChanged();
		listView.setAdapter(adapter);
	}

}
