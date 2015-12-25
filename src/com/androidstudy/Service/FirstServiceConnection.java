package com.androidstudy.Service;

import com.androidstudy.ServiceStudyActivity;
import com.androidstudy.Service.FirstService.CallBack;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;

public class FirstServiceConnection implements ServiceConnection{
	
	private FirstService.MyBinder myBinder;
	private ServiceStudyActivity activity;
	
	private Handler handler = new Handler(){
		public void handleMessage(android.os.Message msg) {
			activity.getTvOut().setText(msg.getData().getString("data"));
		};
	};
	
	@Override
	public void onServiceConnected(ComponentName arg0, IBinder binder) {
		myBinder = (FirstService.MyBinder) binder;
		myBinder.getService().setCallback(new CallBack(){
			@Override
			public void messageChanged(String msg) {
				Message message = new Message();
				Bundle b = new Bundle();
				b.putString("data", msg);
				message.setData(b);
				handler.sendMessage(message);
			}
		});
		System.out.println("绑定服务啦~~~");
	}

	@Override
	public void onServiceDisconnected(ComponentName arg0) {
		System.out.println("服务解除绑定啦~~哦也");
	}
	
	public FirstService.MyBinder getMyBinder(){
		return myBinder;
	}
	
	public ServiceStudyActivity getActivity() {
		return activity;
	}

	public void setActivity(ServiceStudyActivity activity) {
		this.activity = activity;
	}
}
