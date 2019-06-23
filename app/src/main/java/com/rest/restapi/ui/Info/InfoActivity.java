package com.rest.restapi.ui.Info;


import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class InfoActivity extends AppCompatActivity implements InfoContract.View {


    private InfoContract.Presenter mPresenter;
    private Button mButton;

    {
        mPresenter = new InfoPresenter(this);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.onButtonWasClicked();
            }
        });
    }

    @Override
    public void showOverviewMovies(String message) {

    }
}
