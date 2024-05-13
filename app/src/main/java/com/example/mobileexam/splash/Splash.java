package com.example.mobileexam.splash;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateInterpolator;

import androidx.appcompat.app.AppCompatActivity;

import com.example.testproject.AppController;
import com.example.testproject.HomeActivity;
import com.example.testproject.databinding.ActivitySplashBinding;

public class Splash extends AppCompatActivity {
	
	//region Attributes
	//region Class Constant
	private ActivitySplashBinding actBinding;
	private Activity activity;
	private final String TAG = "SplashActivity";
	//endregion Class Constant
	
	int widthScreen;
	int widthLogo;
	//endregion Attributes
	
	//region Initialization
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if (savedInstanceState != null) {}
		actBinding = ActivitySplashBinding.inflate(getLayoutInflater());
		setContentView(actBinding.getRoot());
		activity = this;
		AppController.getInstance().setCurrentActivity(activity);
		
		initialize();
	}
	
	private void initialize(){
		actBinding.imgLogoname.setAlpha(0f);
		widthScreen = Resources.getSystem().getDisplayMetrics().widthPixels;
		
		drawUI();
	}
	
	private void drawUI(){
		actBinding.getRoot().getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
			@Override
			public void onGlobalLayout() {
				actBinding.getRoot().getViewTreeObserver().removeOnGlobalLayoutListener(this);
				widthLogo = actBinding.imgLogo.getWidth();

// Define your target scale and animation duration
				float targetScaleX = 2f;
				float targetScaleY = 2f;
				long duration = 500; // 1 second
				float interpolatorFactor = 1.5f; // Example interpolator factor

// Call the animScaleUp method with your parameters
				animScaleUp(actBinding.imgLogo, targetScaleX, targetScaleY, duration, interpolatorFactor);
				animScaleUp(actBinding.imgLogoname, targetScaleX, targetScaleY, duration, interpolatorFactor);
			}
		});
	}
	//endregion Initialization
	
	public void animScaleUp(final View view, float targetScaleX, float targetScaleY, long duration, float interpolatorFactor) {
		// Create a ValueAnimator for scaling up
		ValueAnimator animatorScaleX = ValueAnimator.ofFloat(view.getScaleX(), targetScaleX);
		ValueAnimator animatorScaleY = ValueAnimator.ofFloat(view.getScaleY(), targetScaleY);
		
		// Set the duration of the animation
		animatorScaleX.setDuration(duration);
		animatorScaleY.setDuration(duration);
		
		// Set the interpolator for smooth acceleration
		AccelerateInterpolator interpolator = new AccelerateInterpolator(interpolatorFactor);
		animatorScaleX.setInterpolator(interpolator);
		animatorScaleY.setInterpolator(interpolator);
		
		// Add update listener to update the scale values
		animatorScaleX.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
			@Override
			public void onAnimationUpdate(ValueAnimator animation) {
				float currentScaleX = (float) animation.getAnimatedValue();
				view.setScaleX(currentScaleX);
				view.setScaleY(currentScaleX);
			}
		});
		
		// Start the animation
		animatorScaleX.start();
		animatorScaleY.start();
		
		// Once the animation completes, start the activity after 1 second delay
		new Handler().postDelayed(new Runnable() {
			@Override
			public void run() {
				startNextActivity();
			}
		}, duration + 1000);
	}
	
	private void startNextActivity() {
		Intent intent = new Intent(this, HomeActivity.class);
		startActivity(intent);
		finish();
	}
}




