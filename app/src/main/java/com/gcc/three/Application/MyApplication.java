package com.gcc.three.Application;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import java.util.List;
public class MyApplication extends Application {
	
	public static Context instance;
	

	@Override
	public void onCreate() {
		super.onCreate();
		instance = getApplicationContext();
	}



}
