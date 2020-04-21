package com.quotes.life_program.views;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import com.quotes.life_program.R;
import com.quotes.life_program.model.LifeQuotesInfo;
import com.quotes.life_program.model.ProgramQuotesInfo;

import java.util.ArrayList;

public class ProgramQuotesAdapter extends ListAdapter<ProgramQuotesInfo,ProgramQuotesViewHolder> {

        private ArrayList<ProgramQuotesInfo> data;
        private static final DiffUtil.ItemCallback<ProgramQuotesInfo> DIFF_CALLBACK = new DiffUtil.ItemCallback<ProgramQuotesInfo>() {
            @Override
            public boolean areItemsTheSame(@NonNull ProgramQuotesInfo oldItem, @NonNull ProgramQuotesInfo newItem) {
                return oldItem.equals(newItem);
            }

            @Override
            public boolean areContentsTheSame(@NonNull ProgramQuotesInfo oldItem, @NonNull ProgramQuotesInfo newItem) {
                return oldItem.equals(newItem);
            }
        };
    public ProgramQuotesAdapter(ArrayList<ProgramQuotesInfo> data) {
        super(DIFF_CALLBACK);
        this.data = data;
        submitList(data);
    }

        @Override
        public int getItemCount() {
        return data.size();
    }

        @NonNull
        @Override
        public ProgramQuotesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_life_quotes_recyclerview,parent,false);
        return new ProgramQuotesViewHolder(view);
    }

        @Override
        public void onBindViewHolder(@NonNull ProgramQuotesViewHolder holder, int position) {
        //holder.getQuotesText().setText(data.get(position).getQuoteText());
        holder.populate(data.get(position));
    }
    }

