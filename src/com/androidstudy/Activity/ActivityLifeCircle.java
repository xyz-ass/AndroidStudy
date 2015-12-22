package com.androidstudy.Activity;

import com.androidstudy.R;
import com.androidstudy.R.id;
import com.androidstudy.R.layout;
import com.androidstudy.R.menu;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

/**
 * @author Ynb007
 * Activity的生命周期
 */
public class ActivityLifeCircle extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		System.out.println("onCreateView");
		setContentView(R.layout.activity_activity_life_circle);
	}

	@Override
	public View onCreateView(String name, Context context, AttributeSet attrs) {
		System.out.println("onCreateView");
		return super.onCreateView(name, context, attrs);
	}

	@Override
	protected void onDestroy() {
		System.out.println("onDestroy");
		super.onDestroy();
	}

	@Override
	protected void onPause() {
		System.out.println("onCreateView");
		super.onPause();
	}

	@Override
	protected void onRestart() {
		System.out.println("onCreateView");
		super.onRestart();
	}

	@Override
	protected void onResume() {
		System.out.println("onCreateView");
		super.onResume();
	}

	@Override
	protected void onStart() {
		System.out.println("onCreateView");
		super.onStart();
	}

	@Override
	protected void onStop() {
		System.out.println("onCreateView");
		super.onStop();
	}
}
