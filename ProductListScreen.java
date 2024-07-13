package com.example.mobileexam;// ProductListScreen.java
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.example.mobileexam.AdapterProduct;
import com.example.mobileexam.Product;
import com.example.mobileexam.R;
import com.example.mobileexam.databinding.ActivityProductListScreenBinding;

import java.util.ArrayList;
import java.util.List;

public class ProductListScreen extends AppCompatActivity {

    private ActivityProductListScreenBinding binding;
    private List<Product> productList;
    private AdapterProduct productAdapter;
    private String selectedCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProductListScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Retrieve category information from Intent extras
        if (getIntent().hasExtra("category")) {
            selectedCategory = getIntent().getStringExtra("category");
        } else {
            finish();
        }

        initialize();
    }

    private void initialize() {
        // Set title as category name
        setTitle(selectedCategory);

        // Example: Fetch products for the selected category
        productList = new ArrayList<>();
        // Populate productList based on selectedCategory (example)
        if (selectedCategory.equals("Laptops")) {
            productList.add(new Product("Laptop 1", "Laptops", 999.99, R.drawable.ic_launcher_background));
            productList.add(new Product("Laptop 2", "Laptops", 1299.99, R.drawable.ic_launcher_background));
        } else if (selectedCategory.equals("Smartphones")) {
            productList.add(new Product("Phone 1", "Smartphones", 499.99, R.drawable.ic_launcher_background));
            productList.add(new Product("Phone 2", "Smartphones", 699.99, R.drawable.ic_launcher_background));
        } else if (selectedCategory.equals("Home Appliances")) {
            productList.add(new Product("Appliance 1", "Home Appliances", 199.99, R.drawable.ic_launcher_background));
            productList.add(new Product("Appliance 2", "Home Appliances", 299.99, R.drawable.ic_launcher_background));
        }

        // Set up RecyclerView
        setupRecyclerView();
    }

    private void setupRecyclerView() {
        productAdapter = new AdapterProduct(productList);
        binding.recyclerViewProducts.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerViewProducts.setAdapter(productAdapter);
    }
}
