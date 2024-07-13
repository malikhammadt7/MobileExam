package com.example.mobileexam;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class HomeViewModel extends ViewModel {

    private MutableLiveData<List<Product>> productList;

    public HomeViewModel() {
        productList = new MutableLiveData<>();
        productList.setValue(new ArrayList<>());
    }

    public LiveData<List<Product>> getProductList() {
        return productList;
    }

    public void addProducts(List<Product> products) {
        List<Product> currentList = productList.getValue();
        currentList.addAll(products);
        productList.setValue(currentList);
    }

    public void clearProducts() {
        productList.setValue(new ArrayList<>());
    }
}
