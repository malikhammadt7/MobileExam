package com.example.mobileexam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.mobileexam.databinding.ActivityViewCartScreenBinding;
import com.example.mobileexam.databinding.ActivityViewOrderScreenBinding;

import java.util.ArrayList;
import java.util.List;

public class ViewCartScreen extends AppCompatActivity {

    private ActivityViewCartScreenBinding actBinding;
    private List<Product> cartProducts;
    private AdapterProduct cartAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        actBinding = ActivityViewCartScreenBinding.inflate(getLayoutInflater());
        setContentView(actBinding.getRoot());

        RecyclerView recyclerView = actBinding.recyclerViewCartItems;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        cartProducts = getCartProducts();
        cartAdapter = new AdapterProduct(cartProducts);
        recyclerView.setAdapter(cartAdapter);

        actBinding.btnCheckout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ViewCartScreen.this, "Checkout clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private List<Product> getCartProducts() {
        List<Product> products = new ArrayList<>();
        products.add(new Product("Product 1", "Category A", 10.00, R.drawable.ic_launcher_background));
        products.add(new Product("Product 2", "Category B", 5.00, R.drawable.ic_launcher_background));
        return products;
    }
}