package com.rest.restapi.ui.Info;


public class InfoPresenter implements InfoContract.Presenter {

    private InfoContract.View mView;
    private InfoContract.Adapter mAdapter;

    //Сообщение
    private String message = "Нажата кнопка";

    public InfoPresenter(InfoContract.View mView) {
        this.mView = mView;
        this.mAdapter = new InfoAdapter();
    }

    @Override
    public void onButtonWasClicked() {
        message = mAdapter.loadOverview();
        mView.showOverviewMovies(message);
    }

}
