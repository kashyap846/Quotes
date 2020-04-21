package com.quotes.life_program.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.quotes.life_program.R;
import com.quotes.life_program.api.LifeQuotesServiceGenerator;
import com.quotes.life_program.api.ProgramQuotesServiceGenerator;
import com.quotes.life_program.model.LifeQuotesList;
import com.quotes.life_program.model.ProgramQuotesInfo;
import com.quotes.life_program.views.LifeQuotesAdapter;
import com.quotes.life_program.views.ProgramQuotesAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProgramQuotesFragment extends Fragment {
    RecyclerView recyclerView ;
    private ProgramQuotesAdapter adapter;
    private ArrayList<ProgramQuotesInfo> programQuotesList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.view_fragment_life_quotes,container,false);
        recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(container.getContext()));
        ProgramQuotesServiceGenerator.getService().getProgramQuotesList().enqueue(new Callback<ArrayList<ProgramQuotesInfo>>() {
            @Override
            public void onResponse(Call<ArrayList<ProgramQuotesInfo>> call, Response<ArrayList<ProgramQuotesInfo>> response) {
                Log.e("onResponse: ","success" );
                programQuotesList =response.body();
                adapter = new ProgramQuotesAdapter(programQuotesList);
                recyclerView.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<ArrayList<ProgramQuotesInfo>> call, Throwable t) {
                Log.e("onFailure: ","failure" );

            }
        });


        return view;
    }
}
