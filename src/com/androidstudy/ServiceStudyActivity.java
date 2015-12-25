package com.androidstudy;

import com.androidstudy.Service.FirstService;
import com.androidstudy.Service.FirstServiceConnection;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;

public class ServiceStudyActivity extends Activity implements OnClickListener{

	private Intent intent;
	private FirstServiceConnection serviceConn;
	
	private EditText et;
	private TextView tvOut;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_service_study);
		
		intent = new Intent(ServiceStudyActivity.this,FirstService.class);
		serviceConn = new FirstServiceConnection();
		serviceConn.setActivity(this);
		et = (EditText) findViewById(R.id.serviceEditText);
		tvOut = (TextView)findViewById(R.id.tvOut);
		
		//启动一个服务
		findViewById(R.id.startFirstService).setOnClickListener(this);
		//停止一个服务
		findViewById(R.id.stopFirstService).setOnClickListener(this);
		//绑定一个服务
		findViewById(R.id.bindFirstService).setOnClickListener(this);
		//解除绑定一个服务
		findViewById(R.id.bindFirstService).setOnClickListener(this);
		//同步绑定数据
		findViewById(R.id.syncFirstServiceData).setOnClickListener(this);
	}

	@Override
	public void onClick(View view){
		switch(view.getId()){
			case R.id.startFirstService:
				intent.putExtra("data", et.getText().toString());
				startService(intent);
				break;
			case R.id.stopFirstService:
				stopService(intent);
				break;
			case R.id.bindFirstService:
				bindService(intent,serviceConn,Context.BIND_AUTO_CREATE);
				break;
			case R.id.unBindFirstService:
				unbindService(serviceConn);
				break;
			case R.id.syncFirstServiceData:
				FirstService.MyBinder mybinder = serviceConn.getMyBinder();
				if(mybinder!=null){
					mybinder.setData(et.getText().toString());
				}
				break;
		}
	}

	public TextView getTvOut() {
		return tvOut;
	}
}
