package com.androidstudy.Service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

/**
 * @author Ynb007
 * 第一个Service程序
 */
public class FirstService extends Service{

	private boolean isServiceRuning = false;
	
	public String outerMsg = "这是默认信息";
	
	public int time = 0;
	
	@Override
	public IBinder onBind(Intent arg0) {
		MyBinder mybinder =  new MyBinder();
		return mybinder;
	}

	public class MyBinder extends Binder{
		public void setData(String data){
			FirstService.this.outerMsg = data;
		}
		public FirstService getService(){
			return FirstService.this;
		}
	}
	
	
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		System.out.println("服务已经启动");
		outerMsg = intent.getStringExtra("data");
		return super.onStartCommand(intent, flags, startId);
	}

	@Override
	public void onCreate() {
		super.onCreate();
		System.out.println("Service Created");
		isServiceRuning = true;
		new Thread(){
			@Override
			public void run() {
				super.run();
				while(isServiceRuning){
					time++;
					String outMsg = time+":"+outerMsg;
					if(callback!=null){
						callback.messageChanged(outMsg);
					}
					try {
						sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			};
		}.start();
	}
	
	@Override
	public void onDestroy() {
		super.onDestroy();
		System.out.println("Service Destoried");
		isServiceRuning = false;
	}
	
	private CallBack callback;
	public CallBack getCallback() {
		return callback;
	}

	public void setCallback(CallBack callback) {
		this.callback = callback;
	}

	public static interface CallBack{
		void messageChanged(String msg);
	};
}
