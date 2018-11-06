package com.rest.restapi.ui.main;

import com.rest.restapi.Movie;
import com.rest.restapi.RetrofitClient;

import retrofit2.Callback;
import retrofit2.Response;

public class MainPresenter {

    private MainContract mainContract;

    public MainPresenter(MainContract mainContract) {
        this.mainContract = mainContract;
    }

    public void getPopularMovies() {
        retrofit2.Call<Movie> call = RetrofitClient.getApiService().getAllMovies(RetrofitClient.API_KEY); // second offline в офисе еотвлекают засранцы ужааас
        call.enqueue(new Callback<Movie>() {
            @Override
            public void onResponse(retrofit2.Call<Movie> call, Response<Movie> response) {

                // теперь обратный ход от сервера в активити))
                mainContract.showPopularMovies(response.body());
                mainContract.hideProgress();
            }

            @Override
            public void onFailure(retrofit2.Call<Movie> call, Throwable t) {
                t.printStackTrace(); // в случае ошибки - в консоль выведется лог
                mainContract.showError(t.getMessage());
                mainContract.hideProgress();
            }
        });
    }
}
