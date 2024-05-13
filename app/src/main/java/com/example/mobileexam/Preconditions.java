package com.example.mobileexam;

public class Preconditions {
	
	// Check if a string is null or empty
	public static boolean isNullOrEmpty(String str) {
		return str == null || str.isEmpty();
	}
	
	// Check if a string is null, empty, or contains only whitespace
	public static boolean isNullOrWhitespace(String str) {
		return str == null || str.trim().isEmpty();
	}
	
	// Check if an integer is positive
	public static boolean isPositive(int num) {
		return num > 0;
	}
	
	// Check if an integer is negative
	public static boolean isNegative(int num) {
		return num < 0;
	}
	
	// Check if a string is not null and has a certain length
	public static boolean hasLength(String str, int length) {
		return str != null && str.length() == length;
	}
	
	// Check if a string is not null and has a minimum length
	public static boolean hasMinLength(String str, int minLength) {
		return str != null && str.length() >= minLength;
	}
	
	// Check if a string is not null and has a maximum length
	public static boolean hasMaxLength(String str, int maxLength) {
		return str != null && str.length() <= maxLength;
	}
	
}
