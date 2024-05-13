package com.example.mobileexam;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.example.testproject.databinding.ActivityHomeBinding;
import com.example.testproject.home.HomeVM;

import java.util.Random;

public class HomeActivity extends AppCompatActivity {
	
	//region Attributes
	//region Class Constant
	private ActivityHomeBinding binding;
	public static final String TAG = "HomeActivity";
	private HomeVM viewModel;
	//endregion Class Constant

	private String username;
	//endregion Attributes
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		binding = DataBindingUtil.setContentView(this,R.layout.activity_home);
		
		viewModel = new ViewModelProvider(this).get(HomeVM.class);
		binding.setViewModel(viewModel);
		binding.setLifecycleOwner(this);
		
//		viewModel.setUsername("John");
//		viewModel.setCoins("100");
//
//		viewModel.addCoins(50); // Add 50 coins
//		viewModel.subtractCoins(20); // Subtract 20 coins
		binding.btnSample.setOnClickListener(view -> {
			viewModel.addCoins(20);
		});
	}
	
	Random random = new Random();
	// Generate a random integer between 0 (inclusive) and 100 (exclusive)
	int randomNumber = random.nextInt(100);
	
	int absValue = Math.abs(-10); // absValue will be 10
	int minValue = Math.min(5, 10); // minValue will be 5
	int maxValue = Math.max(5, 10); // maxValue will be 10
	double sqrtValue = Math.sqrt(16); // sqrtValue will be 4.0
	double powValue = Math.pow(2, 3); // powValue will be 8.0 (2 raised to the power of 3)
	double ceilValue = Math.ceil(5.2); // ceilValue will be 6.0
	double floorValue = Math.floor(5.9); // floorValue will be 5.0
	long roundValue = Math.round(5.6); // roundValue will be 6
	double randomValue = Math.random(); // randomValue will be between 0.0 and 1.0


//	//region Attributes
//	//region Class Constant
//	private ActivityHomeBinding binding;
//	public static final String TAG = "HomeActivity";
//	//endregion Class Constant
//
//	private String username;
//	//endregion Attributes
//
//	//region Initialization
//	@Override
//	protected void onCreate(Bundle savedInstanceState) {
//		super.onCreate(savedInstanceState);
//		if (savedInstanceState != null) {}
//		binding = ActivityHomeBinding.inflate(getLayoutInflater());
//		setContentView(binding.getRoot());
//		AppController.getInstance().setCurrentActivity(this);
//
//		initialize();
//	}
//	public void initialize(){
//		drawUI();
//	}
//	public void drawUI(){
//
//		binding.btnSample.setOnClickListener(new View.OnClickListener() {
//			@Override
//			public void onClick(View view) {
//				int number1 = (EditText) findViewById(R.id.et1).
//			}
//		});
//	}
	//endregion Initialization
//
//	//region Methods
//
//	public void methodNAME(){
//		Log.d(TAG, "-------- METHOD STARTED (methodNAME): ");
//
////		return value;
//		Log.d(TAG, "-------- METHOD ENDED (methodNAME): ");
//	}
//
//	//region ViewModel
//	private void fetchBundleData(Bundle savedInstanceState){
//		if (savedInstanceState != null) {
//
//		}
//	}
//	private void fillInstanceData(){
//	}
//	//endregion ViewModel
//
//	//region SubSection
//	//endregion SubSection
//
//	//endregion Methods
//
//	//region Overrides
//	@Override
//	protected void onSaveInstanceState(@NonNull Bundle outState) {
//		super.onSaveInstanceState(outState);
//		fillInstanceData();
//	}
//	//endregion Overrides
}