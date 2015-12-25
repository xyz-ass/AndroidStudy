package com.androidstudy;

import com.androidstudy.Activity.ActivityExtraUser;
import com.androidstudy.Activity.ActivityWidthResult;
import com.androidstudy.Activity.AnotherActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class ActivityStudyActivity extends Activity {

	private TextView tv;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_activity_study);
		tv = (TextView) findViewById(R.id.textView1);
		tv.setText(String.format("TaskId:%d,\n Current Activity Id:%s",getTaskId(),toString()));
		
		findViewById(R.id.startAnotherActivity).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				//启动另外一个activity并传值
				Intent i = new Intent(ActivityStudyActivity.this,AnotherActivity.class);
				//传递简单数据参数
				i.putExtra("keyTest", "这是传过去的东西哈哈哈");
				
				//以Bundle的方式传值
				Bundle bundle = new Bundle();
				bundle.putString("data1", "我要飞得更高");
				bundle.putInt("data2", 2);
				i.putExtras(bundle);
				
				//以对象的方式传值,安卓最好使用Parcelable方式传值而不是Seriable，因为效率高
				ActivityExtraUser user = new ActivityExtraUser();
				user.setId("userId is no.1");
				user.setName("username is Lily");
				i.putExtra("user", user);
				
				startActivity(i);
				
				//启动浏览器并打开指定网址
				//startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("http://www.baidu.com")));
			}
		});
		
		findViewById(R.id.startWidthRsultActivity).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				//启动带有返回值的activity
				Intent i = new Intent(ActivityStudyActivity.this,ActivityWidthResult.class);
				startActivityForResult(i, 1);
			}
		});
		
		findViewById(R.id.startActivityByHiddenIntent).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Intent i = new Intent("com.app1.activity.intent.ActivityHidden");
				startActivity(i);
			}
		});
		
		//启动自身activity 可以尝试以Standard、singleTop、singleTask、singleInstance四种模式启动，默认是standard
		findViewById(R.id.startStandardActivity).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				startActivity(new Intent(ActivityStudyActivity.this,MainActivity.class));
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_study, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
