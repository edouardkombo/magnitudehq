package com.magnitude.plugin.sample;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import org.json.JSONObject;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import com.magnitude.libs.PoiAttributes;

public class SamplePlugin extends Service{

	
	private JSONObject jo;
	public ArrayList<PoiAttributes> poiArray = new ArrayList<PoiAttributes>();
	public static final String POI_ARRAY = "poiArray";
	private static int SERVICE_TYPE_TOUCHEABLE = 0;
	private static int SERVICE_TYPE_GETTER = 1;
	boolean started = false;
	TimerTask task;
	Timer timer;
	public class MyBinder extends Binder {
		SamplePlugin getService() {
			return SamplePlugin.this;
		}
	}
	
	@Override
	public IBinder onBind(Intent arg0) {
		return new MyBinder();
	}

	@Override
	public void onCreate() {	
		timer = new Timer();
		task = new TimerTask() {
		
			@Override
			public void run() {
				//Create the response Intent core Magnitude app will receive.
				Intent intent = new Intent("com.magnitude.plugin.sample.BACK_EVENT");
				
				//Get POI json from the web. 
				//JSON is certainly the best for communicating with Android devices.
				//You can use our helper class to get json objects.
				jo = JSONHelper.getJSONObject("http://www.etud.insa-toulouse.fr/~benattar/android/poi.json");
				
				//Parse the JSONObject to create POIAttributes
				ParsePOI p = new ParsePOI(jo);
				poiArray = p.parseObjects();
				
				//This is important. You should set the type of service you're creating
				//SERVICE_TYPE_GETTER : A Service that will only get POIs
				//SERVICE_TYPE_TOUCHEABLE : A service that can launch an activity and do more stuff
				//Have a look at our WhereIsMy plugin sample to see an example of TOUCHEABLE plugin.
				intent.putExtra("type", SERVICE_TYPE_GETTER);
				
				//Put the poiAttributes into the Intent. 
				//The core magnitude app will read them and create MagnitudePOI objects.
				intent.putExtra(POI_ARRAY, poiArray);
				
				//Notify the core you're done and it have some data available
				SamplePlugin.this.sendBroadcast(intent);
			}
		};
		super.onCreate();
	}
	
	@Override
	public void onStart(Intent intent, int startId) {
		if (started == false){
			//If you need to do your treatment perodically, you should
			//modify that.
			timer.schedule(task, 0);
			started = true;
		}
			
		super.onStart(intent, startId);
	}
	@Override
	public void onDestroy() {
		timer.cancel();
		super.onDestroy();
	}
	
}
