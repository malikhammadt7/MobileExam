package com.example.mobileexam;

import android.app.Activity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class AppController {
	
	//region Singleton
	private static AppController instance;
	private AppController() {}
	public static synchronized AppController getInstance() {
		if (instance == null) {
			instance = new AppController();
		}
		return instance;
	}
	//endregion Singleton
	
	//region Attributes
	//region Class Constants
	public static final String TAG = "AppController";
	//endregion Class Constants
	
	private Activity currentActivity;
	//endregion Attributes
	
	//region Initialization
	public void initialize() {
	}
	//endregion Initialization
	
	//region Getter/Setter
	public Activity getCurrentActivity() {
		return currentActivity;
	}
	public void setCurrentActivity(Activity currentActivity) {
		this.currentActivity = currentActivity;
	}
	//endregion Getter/Setter
	
	// Method to get current time in milliseconds
	public static long getCurrentTimeMillis() {
		return System.currentTimeMillis();
	}
	
	// Method to format time in milliseconds to a human-readable string
	public static String formatTime(long timeInMillis) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.getDefault());
		return sdf.format(new Date(timeInMillis));
	}
	
	// Method to format time in milliseconds to a custom format
	public static String formatTime(long timeInMillis, String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.getDefault());
		return sdf.format(new Date(timeInMillis));
	}
	
	// Method to format time in milliseconds to a time string (HH:mm:ss)
	public static String formatTimeOnly(long timeInMillis) {
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss", Locale.getDefault());
		return sdf.format(new Date(timeInMillis));
	}
	
	// Method to format time in milliseconds to a date string (dd/MM/yyyy)
	public static String formatDateOnly(long timeInMillis) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
		return sdf.format(new Date(timeInMillis));
	}
	
	// Method to format time in milliseconds to a time and date string (dd/MM/yyyy HH:mm:ss)
	public static String formatDateTime(long timeInMillis) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.getDefault());
		return sdf.format(new Date(timeInMillis));
	}
}
