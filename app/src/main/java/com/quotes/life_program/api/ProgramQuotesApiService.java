package com.quotes.life_program.api;

import com.quotes.life_program.model.LifeQuotesList;
import com.quotes.life_program.model.ProgramQuotesInfo;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ProgramQuotesApiService {
    @GET("quotes")
    Call<ArrayList<ProgramQuotesInfo>> getProgramQuotesList();

    @GET("quotes/random")
    Call<ProgramQuotesInfo> getProgramRandomQuote();
}
