package com.rest.restapi;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    @GET("movie/popular")
    Call<Movie> getAllMovies(@Query("api_key") String API_KEY);
}
