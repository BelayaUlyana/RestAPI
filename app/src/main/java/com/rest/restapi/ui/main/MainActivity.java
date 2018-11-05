package com.rest.restapi.ui.main;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.rest.restapi.Movie;
import com.rest.restapi.R;

public class MainActivity extends AppCompatActivity implements MainContract {
    private MovieAdapter adapter;
    ProgressDialog progressDialog;

    private MainPresenter presenter;

    // вообще у тебя здесь все плохо))
    // не используешь никакой паттерн(mvc, mvp, mvvm, clean) - задание переделать это с использованием паттерна МВП
    // у тебя будет активити + презентер + модель + сервис
    // в активити в ОнКрэйт вызывается метод из презентера - презентер в свою чередь вызывает метод из модели - модель образается
    // в сервис - сервис на сервер -> сервер отдает в сервис - сервис в модель - модель в презентер - презентер в активити
    // связь между активити и презентером происходит через интерфейсы

    // ЗАДАЧА - ПОПРАКТИКОВАТЬСЯ С ПАТТЕРНОМ МВП! :)

    @Override
    public void showPopularMovies(Movie movie) {
        adapter.addALL(movie.getResults());
    }

    @Override
    public void hideProgress() {
        progressDialog.dismiss(); // one of the ways to go
    }

    @Override
    public void showError(String error) {
        progressDialog.dismiss();
        Toast.makeText(this, "Error:"+error, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new MainPresenter(this);
        presenter.getPopularMovies();

        RecyclerView recyclerView = findViewById(R.id.customRecyclerView);
        adapter = new MovieAdapter(this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setMessage("Loading....");
        progressDialog.show();
    }
}
