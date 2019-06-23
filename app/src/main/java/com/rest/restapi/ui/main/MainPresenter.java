package com.rest.restapi.ui.main;

import com.rest.restapi.Movie;
import com.rest.restapi.RetrofitClient;

import retrofit2.Callback;
import retrofit2.Response;

class MainPresenter {

    private MainContract mainContract;

    MainPresenter(MainContract mainContract) {
        this.mainContract = mainContract;
    }

    void getPopularMovies() {
        retrofit2.Call<Movie> call = RetrofitClient.getApiService().getAllMovies(RetrofitClient.API_KEY);
        call.enqueue(new Callback<Movie>() {
            @Override
            public void onResponse(retrofit2.Call<Movie> call, Response<Movie> response) {
                mainContract.showPopularMovies(response.body());
                mainContract.hideProgress();
            }

            @Override
            public void onFailure(retrofit2.Call<Movie> call, Throwable t) {
                t.printStackTrace();
                mainContract.showError(t.getMessage());
                mainContract.hideProgress();
            }
        });
    }
}
