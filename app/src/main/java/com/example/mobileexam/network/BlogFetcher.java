package com.example.mobileexam.network;

import android.util.Log;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class BlogFetcher {
	private BlogApi blogApi;
	
	public BlogFetcher() {
		Retrofit retrofit = RetrofitClient.getRetrofitInstance();
		blogApi = retrofit.create(BlogApi.class);
	}
	
	public void fetchBlogs() {
		Call<List<Blog>> call = blogApi.getBlogs();
		call.enqueue(new Callback<List<Blog>>() {
			@Override
			public void onResponse(Call<List<Blog>> call, Response<List<Blog>> response) {
				if (response.isSuccessful() && response.body() != null) {
					List<Blog> blogs = response.body();
					// Handle the list of blogs
					for (Blog blog : blogs) {
						Log.d("BlogFetcher", "Blog title: " + blog.getTitle());
					}
				}
			}
			
			@Override
			public void onFailure(Call<List<Blog>> call, Throwable t) {
				// Handle failure
				Log.e("BlogFetcher", "Error fetching blogs", t);
			}
		});
	}
}
