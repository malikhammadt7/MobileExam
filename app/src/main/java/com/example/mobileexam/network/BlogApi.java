package com.example.mobileexam.network;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface BlogApi {
	@GET("path/to/blogs")  // Replace with your endpoint
	Call<List<Blog>> getBlogs();
}
