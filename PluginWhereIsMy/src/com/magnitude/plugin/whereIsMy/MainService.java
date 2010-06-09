package com.magnitude.plugin.whereIsMy;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

public class MainService extends Service{
	private static int SERVICE_TYPE_TOUCHEABLE = 0;
	@SuppressWarnings("unused")
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
				Intent intent = new Intent("com.magnitude.plugin.whereIsMy.BACK_EVENT");
				intent.putExtra("type",SERVICE_TYPE_TOUCHEABLE);		
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
