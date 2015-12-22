package com.androidstudy;

import com.androidstudy.Activity.ActivityLifeCircle;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class MainActivity extends Activity {

	private TextView tv;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		tv = (TextView) findViewById(R.id.textView1);
		tv.setText(String.format("TaskId:%d,\n Current Activity Id:%s",getTaskId(),toString()));
		
		findViewById(R.id.startAnotherActivity).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				//启动另外一个activity
				startActivity(new Intent(MainActivity.this,ActivityLifeCircle.class));
				
				//启动浏览器并打开指定网址
				//startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("http://www.baidu.com")));
			}
		});
		
		//启动自身activity 可以尝试以Standard、singleTop、singleTask、singleInstance四种模式启动，默认是standard
		findViewById(R.id.startStandardActivity).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				startActivity(new Intent(MainActivity.this,MainActivity.class));
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
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
