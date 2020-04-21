package com.quotes.life_program.model;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

public class LifeQuotesInfo {
    @SerializedName("_id")
    String id;
    @SerializedName("quoteText")
    String quoteText;
    @SerializedName("quoteAuthor")
    String quoteAuthor;

    public String getId() {
        return id;
    }

    public String getQuoteText() {
        return quoteText;
    }

    public String getQuoteAuthor() {
        return quoteAuthor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LifeQuotesInfo that = (LifeQuotesInfo) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
