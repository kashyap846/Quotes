package com.quotes.life_program.appwidgets;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.RemoteViews;

import com.quotes.life_program.R;
import com.quotes.life_program.api.LifeQuotesServiceGenerator;
import com.quotes.life_program.api.ProgramQuotesServiceGenerator;
import com.quotes.life_program.model.LifeQuotesList;
import com.quotes.life_program.model.ProgramQuotesInfo;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class QuotesWidgetProvider extends AppWidgetProvider {

    private static final int LIFE_QUOTE_VIEW_ID = R.id.life_quotes;
    private static final int PROGRAM_QUOTE_VIEW_ID = R.id.program_quotes;
    private LifeQuotesList lifeQuotesList;
    private ProgramQuotesInfo programQuotesInfo;

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        for (int i = 0; i < appWidgetIds.length; i++) {

            int appWidgetId = appWidgetIds[i];
            RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.app_widget_quotes);
            populateLifeQuote(remoteViews,LIFE_QUOTE_VIEW_ID);
            populateProgramQuote(remoteViews,PROGRAM_QUOTE_VIEW_ID);
            appWidgetManager.updateAppWidget(appWidgetId, remoteViews);
        }
    }

    private void populateLifeQuote(RemoteViews remoteViews,int quoteView) {

        LifeQuotesServiceGenerator.getService().getLifeRandomQuote().enqueue(new Callback<LifeQuotesList>() {
            @Override
            public void onResponse(Call<LifeQuotesList> call, Response<LifeQuotesList> response) {

                lifeQuotesList =response.body();
                Log.e("onResponse: ","success"+lifeQuotesList.getQuote().getQuoteText() );
                remoteViews.setViewVisibility(R.id.container, View.VISIBLE);
                remoteViews.setTextViewText(quoteView,lifeQuotesList.getQuote().getQuoteText());

            }

            @Override
            public void onFailure(Call<LifeQuotesList> call, Throwable t) {
                Log.e("onFailure: ","failure" );

            }
        });



    }

    private void populateProgramQuote(RemoteViews remoteViews,int quoteView){
        ProgramQuotesServiceGenerator.getService().getProgramRandomQuote().enqueue(new Callback<ProgramQuotesInfo>() {
            @Override
            public void onResponse(Call<ProgramQuotesInfo> call, Response<ProgramQuotesInfo> response) {

                programQuotesInfo =response.body();
                Log.e("onResponse: ","success"+programQuotesInfo.getProgramQuoteText() );
                remoteViews.setViewVisibility(R.id.container, View.VISIBLE);
                remoteViews.setTextViewText(quoteView,programQuotesInfo.getProgramQuoteText());


            }

            @Override
            public void onFailure(Call<ProgramQuotesInfo> call, Throwable t) {
                Log.e("onFailure: ","failure" );

            }
        });
    }
}
