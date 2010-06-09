package com.magnitude.plugin.BuildingINSA;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import org.json.JSONObject;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import com.magnitude.libs.PoiAttributes;

public class MainService extends Service{

	
	private JSONObject jo;
	public ArrayList<PoiAttributes> poiArray = new ArrayList<PoiAttributes>();
	public static final String POI_ARRAY = "poiArray";
	@SuppressWarnings("unused")
	private static int SERVICE_TYPE_TOUCHEABLE = 0;
	private static int SERVICE_TYPE_GETTER = 1;
	boolean started = false;
	TimerTask task;
	Timer timer;
	public class MyBinder extends Binder {
		MainService getService() {
			return MainService.this;
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
				Intent intent = new Intent("com.magnitude.plugin.BuildingINSA.BACK_EVENT");
				//Search for the poi informations
				jo = JSONHelper.getJSONObject("http://demo.magnitudehq.com/insatoulouse/pois?deviceId=");
				//Parse the JSONObject to POIAttributes
				ParsePOI p = new ParsePOI(jo);
				poiArray = p.lancerTraitement();
				intent.putExtra("type", SERVICE_TYPE_GETTER);
				intent.putExtra(POI_ARRAY, poiArray);
				MainService.this.sendBroadcast(intent);
			}
		};
		super.onCreate();
	}
	
	@Override
	public void onStart(Intent intent, int startId) {
		if (started == false){
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
