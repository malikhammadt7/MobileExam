package com.example.mobileexam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.mobileexam.databinding.ActivityHomeScreenBinding;


public class HomeScreen extends AppCompatActivity {


    //region Attributes
    //region Class Constant
    private ActivityHomeScreenBinding binding;
    public static final String TAG = "HomeActivity";
    private HomeViewModel viewModel;
    //endregion Class Constant

    private String username;
    //endregion Attributes

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_home_screen);

        viewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        binding.setHomeViewModel(viewModel);
        binding.setLifecycleOwner(this);

        binding.btnLaptops.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToProducts("Laptops");
            }
        });

        binding.btnSmartphones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToProducts("Smartphones");
            }
        });

        binding.btnHomeAppliances.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToProducts("Home Appliances");
            }
        });

        binding.btnViewCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeScreen.this, ViewCartScreen.class));
            }
        });

        binding.btnViewOrders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeScreen.this, ViewOrderScreen.class));
            }
        });
    }

    private void navigateToProducts(String category) {
        Intent intent = new Intent(this, ProductListScreen.class);
        intent.putExtra("category", category);
        startActivity(intent);
    }
}