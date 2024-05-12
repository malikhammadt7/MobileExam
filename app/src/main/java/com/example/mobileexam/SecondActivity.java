package com.example.mobileexam;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
	
	private TextView numbersTextView, resultTextView;
	private Button addButton, subtractButton, multiplyButton, divideButton;
	
	private String firstNum, secondNum;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		
		// Initialize views
		numbersTextView = findViewById(R.id.numbersTextView);
		resultTextView = findViewById(R.id.resultTextView);
		addButton = findViewById(R.id.addButton);
		subtractButton = findViewById(R.id.subtractButton);
		multiplyButton = findViewById(R.id.multiplyButton);
		divideButton = findViewById(R.id.divideButton);
		
		// Retrieve data from SharedPreferences
		SharedPreferences sharedPreferences = getSharedPreferences("MyPref", MODE_PRIVATE);
		firstNum = sharedPreferences.getString("FirstNum", "");
		secondNum = sharedPreferences.getString("SecondNum", "");
		
		// Retrieve data from intent
		Bundle extras = getIntent().getExtras();
		if (extras != null) {
			firstNum = extras.getString("FirstNum", firstNum);
			secondNum = extras.getString("SecondNum", secondNum);
		}
		
		// Display entered numbers
		String numbersEntered = "The Two numbers are " + firstNum + " and " + secondNum;
		numbersTextView.setText(numbersEntered);
		
		// Set click listeners for operation buttons
		addButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				performOperation("+", Double.parseDouble(firstNum) + Double.parseDouble(secondNum));
			}
		});
		
		subtractButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				performOperation("-", Double.parseDouble(firstNum) - Double.parseDouble(secondNum));
			}
		});
		
		multiplyButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				performOperation("*", Double.parseDouble(firstNum) * Double.parseDouble(secondNum));
			}
		});
		
		divideButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if (!secondNum.equals("0")) {
					performOperation("/", Double.parseDouble(firstNum) / Double.parseDouble(secondNum));
				} else {
					resultTextView.setText("Cannot divide by zero");
				}
			}
		});
	}
	
	private void performOperation(String operation, double result) {
		String message = "The " + operation + " of two numbers is: " + result;
		resultTextView.setText(message);
	}
}
