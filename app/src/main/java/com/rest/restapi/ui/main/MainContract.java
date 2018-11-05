package com.rest.restapi.ui.main;

import com.rest.restapi.Movie;

public interface MainContract {
    void showPopularMovies(Movie movie);
    void showError(String error);
    void hideProgress();
}
