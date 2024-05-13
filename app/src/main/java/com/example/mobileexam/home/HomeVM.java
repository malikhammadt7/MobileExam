package com.example.mobileexam.home;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeVM extends ViewModel {
	public MutableLiveData<String> username = new MutableLiveData<>();
	public MutableLiveData<Integer> coins = new MutableLiveData<>();
	
	public HomeVM() {
		username.setValue("");
		coins.setValue(0);
	}
	
	public MutableLiveData<String> getUsername() {
		return username;
	}
	
	public void setUsername(String usernameValue) {
		username.setValue(usernameValue);
	}
	
	public MutableLiveData<Integer> getCoins() {
		return coins;
	}
	
	public void setCoins(Integer coinsValue) {
		coins.setValue(coinsValue);
	}
	
	public void addCoins(int amount) {
		int currentCoins = coins.getValue();
		currentCoins += amount;
		coins.setValue(currentCoins);
	}
	
	public void subtractCoins(int amount) {
		int currentCoins = coins.getValue();
		currentCoins -= amount;
		coins.setValue(currentCoins);
	}
}
