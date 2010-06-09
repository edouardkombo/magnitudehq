package com.magnitude.plugin.whereIsMy;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.magnitude.libs.PoiAttributes;

public class WhereIsMySave extends Activity implements OnClickListener {
	private double latitude;
	private double longitude;
	private String name;  // dtc
	private Intent i;
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		latitude = 0;
		longitude = 0;
		if(getIntent().getExtras().containsKey("latitude")) latitude = getIntent().getExtras().getDouble("latitude");
		if(getIntent().getExtras().containsKey("longitude")) longitude = getIntent().getExtras().getDouble("longitude");
		
		TextView latitudeText = (TextView) findViewById(R.id.latitude);
		latitudeText.setText("Latitude : "+String.valueOf(latitude));
		
		TextView longitudeText = (TextView) findViewById(R.id.longitude);
		longitudeText.setText("Longitude : "+String.valueOf(longitude));
		
		Button button = (Button) findViewById(R.id.save);
		button.setOnClickListener(this);
	}
	
	@Override
	public void onClick(View v) {
		EditText nameText = (EditText) findViewById(R.id.name);
		name = nameText.getText().toString();
		if(name.equals("")) name = new String("Here");
	
		ArrayList<PoiAttributes> poiArray = new ArrayList<PoiAttributes>();
		
		PoiAttributes poi = new PoiAttributes(name,"com.magnitude.poi",latitude,longitude,0);
		poiArray.add(poi);
		
		i = new Intent("com.magnitude.plugin.whereIsMy.END_ACTIVITY");
		i.putExtra("poiArray", poiArray);
		setResult(42,i);
        
		this.finish();
	}	
}
