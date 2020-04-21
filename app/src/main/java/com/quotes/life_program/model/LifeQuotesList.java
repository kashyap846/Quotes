package com.quotes.life_program.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

public class LifeQuotesList implements Serializable {
    @SerializedName("quotes")
    ArrayList<LifeQuotesInfo> quotesArray;

    @SerializedName("quote")
    LifeQuotesInfo quote;

    public LifeQuotesInfo getQuote() {
        return quote;
    }

    public ArrayList<LifeQuotesInfo> getQuotesArray(){
        return quotesArray;
    }

}
