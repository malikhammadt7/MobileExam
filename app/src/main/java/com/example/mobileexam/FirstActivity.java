package com.example.mobileexam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class FirstActivity extends AppCompatActivity {
	
	private EditText etNum1, etNum2;
	private Button btnSample;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_first);
		
		etNum1 = findViewById(R.id.et1);
		etNum2 = findViewById(R.id.et2);
		btnSample = findViewById(R.id.btnSample);
		
		btnSample.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				String number1 = etNum1.getText().toString();
				String number2 = etNum2.getText().toString();
				
				SharedPreferences sharedPreferences = getSharedPreferences("MyPref", MODE_PRIVATE);
				SharedPreferences.Editor editor = sharedPreferences.edit();
				editor.putString("FirstNum", number1);
				editor.putString("SecondNum", number2);
				editor.apply();
				
				Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
				intent.putExtra("FirstNum", number1);
				intent.putExtra("SecondNum", number2);
				startActivity(intent);
			}
		});
	}
}