package com.quotes.life_program.model;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

public class ProgramQuotesInfo {
    @SerializedName("_id")
    String id;
    @SerializedName("en")
    String programQuoteText;
    @SerializedName("author")
    String programQuoteAuthor;

    public String getId() {
        return id;
    }

    public String getProgramQuoteText() {
        return programQuoteText;
    }

    public String getProgramQuoteAuthor() {
        return programQuoteAuthor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProgramQuotesInfo that = (ProgramQuotesInfo) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
