package com.example.mobileexam;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;

import com.example.mobileexam.databinding.ActivityViewOrderScreenBinding;

public class ViewOrderScreen extends AppCompatActivity {

    //region Attributes
    //region Class Constant
    private ActivityViewOrderScreenBinding actBinding;
    private Activity activity;
    private final String TAG = "ViewOrderScreen";
    //endregion Class Constant

    int widthScreen;
    //endregion Attributes

    //region Initialization
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {}
        actBinding = ActivityViewOrderScreenBinding.inflate(getLayoutInflater());
        setContentView(actBinding.getRoot());
        activity = this;
        AppController.getInstance().setCurrentActivity(activity);

        initialize();
    }

    private void initialize(){
        widthScreen = Resources.getSystem().getDisplayMetrics().widthPixels;

        drawUI();
    }

    private void drawUI(){

    }
}