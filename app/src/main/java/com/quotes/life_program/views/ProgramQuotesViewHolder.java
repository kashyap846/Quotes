package com.quotes.life_program.views;

import android.app.AlertDialog;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.quotes.life_program.R;
import com.quotes.life_program.model.LifeQuotesInfo;
import com.quotes.life_program.model.ProgramQuotesInfo;

import java.util.ArrayList;

public class ProgramQuotesViewHolder extends RecyclerView.ViewHolder {
    private ArrayList<ProgramQuotesInfo> data;
    private TextView quotesText;

    public TextView getQuotesText() {
        return quotesText;
    }


    public ProgramQuotesViewHolder(@NonNull View itemView) {
        super(itemView);
        this.quotesText = itemView.findViewById(R.id.quote_text);
    }

    public void populate(ProgramQuotesInfo programQuotesInfo){
        quotesText.setText(programQuotesInfo.getProgramQuoteText());
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(v.getContext())
                        .setTitle(R.string.life_quote_title)
                        .setMessage("Quote::"+programQuotesInfo.getProgramQuoteText()+"\n\n"+
                                "Author::"+formatText(programQuotesInfo.getProgramQuoteAuthor()+"\n"))
                        .setNegativeButton(R.string.quote_cancel,(d,which) -> {})
                        .show();


            }
        });
    }

    public String formatText(String authorName){
        Log.e("formatText: ", "uu"+authorName.length());
        if(authorName.length()==1){
            Log.e("formatText: ", "emptyyy"+authorName);
            return "Unknown";
        }
        return authorName;

    }
}
