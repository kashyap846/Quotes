package com.quotes.life_program.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LifeQuotesServiceGenerator {
    private static LifeQuotesApiService SERVICE;

    private static void initialize() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://quote-garden.herokuapp.com/api/")
                .addConverterFactory(GsonConverterFactory.create()).build();

        SERVICE = retrofit.create(LifeQuotesApiService.class);
    }

    public static LifeQuotesApiService getService() {
        if (SERVICE == null) {
            initialize();
        }
        return SERVICE;
    }
}
