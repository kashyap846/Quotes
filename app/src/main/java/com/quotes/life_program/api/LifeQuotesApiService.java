package com.quotes.life_program.api;

import com.quotes.life_program.model.LifeQuotesInfo;
import com.quotes.life_program.model.LifeQuotesList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface LifeQuotesApiService {
    @GET("v2/quotes/all?page=1&limit=100")
    Call<LifeQuotesList> getLifeQuotesList();

    @GET("v2/quotes/random")
    Call<LifeQuotesList> getLifeRandomQuote();

}
