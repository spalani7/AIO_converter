package com.example.aio_converter;

import java.util.ArrayList;
import java.util.Collections;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {

	
	String[] itemArray = {"Temperature","Distance and Length"};
		/*,"Speed","Area","Capacity and Volume","Mass and Weight","Time","Acceleration","Density","Stress and Pressure","Energy and Work","Power","Force"};*/

	private ListView itemListView;
	 
	 private ArrayAdapter<String> arrayAdapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ArrayList<String> arraylist;
		itemListView = (ListView) findViewById(R.id.listView1);
		//itemListView.setTextFilterEnabled(true);
		arraylist= new ArrayList<String>();
        for(int i=0;i<itemArray.length;i++)
        {
            arraylist.add(itemArray[i]);
        }
        
        Collections.sort(arraylist);
        arrayAdapter = new ArrayAdapter<String>(this, R.layout.listview_layout, arraylist);
		itemListView.setAdapter(arrayAdapter);
		
		itemListView.setOnItemClickListener(new OnItemClickListener() {
		
			public void onItemClick(AdapterView<?> a, View v, int position, long id){
				//String pos= (String) itemListView.getItemAtPosition(position);
				//Toast.makeText(MainActivity.this,"Item no."+position+itemListView.getSelectedItem(),Toast.LENGTH_LONG).show();
				
			
				switch (position) {
				case 0:
					Intent myIntent1 = new Intent(v.getContext(),Distance_length.class);
				    //myIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				   // myIntent.putExtra("pos", position);
				    startActivityForResult(myIntent1, 0);
					break;
				case 1:
					Intent myIntent0 = new Intent(v.getContext(),Temperature.class);
				    //myIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				   // myIntent.putExtra("pos", position);
				    startActivityForResult(myIntent0, 0);
					break;
				default:
					break;
				}
				
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
