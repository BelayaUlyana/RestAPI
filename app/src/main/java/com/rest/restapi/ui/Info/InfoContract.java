package com.rest.restapi.ui.Info;


public interface InfoContract {

    interface View {
        void showOverviewMovies(String message);
    }

    interface Presenter {
        void onButtonWasClicked();

    }

    interface Adapter {
        String loadOverview();
    }
}
