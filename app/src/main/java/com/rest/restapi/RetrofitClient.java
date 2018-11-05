package com.rest.restapi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static final String BASE_URL = "https://api.themoviedb.org/3/";
    public static final String API_KEY = "5bf9785bda774c34b29d8d4e2902e0f6";
    public static final String API_KEY_IMG = "https://image.tmdb.org/t/p/w500";

    public static Retrofit getRetrofitInstance() {
        return new Retrofit.Builder()
                .baseUrl(BASE_URL) //Базовая часть адреса
                .addConverterFactory(GsonConverterFactory.create()) //Конвертер, необходимый для преобразования JSON'а в объекты
                .build();
    }

    public static ApiService getApiService(){
        return getRetrofitInstance().create(ApiService.class); //Создаем объект, при помощи которого будем выполнять запросы
    }
}
