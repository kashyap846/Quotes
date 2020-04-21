package com.quotes.life_program.views;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.quotes.life_program.R;
import com.quotes.life_program.model.LifeQuotesInfo;

import java.util.ArrayList;

public class LifeQuotesAdapter extends ListAdapter<LifeQuotesInfo, LifeQuotesViewHolder> {
    private ArrayList<LifeQuotesInfo> data;
    private static final DiffUtil.ItemCallback<LifeQuotesInfo> DIFF_CALLBACK = new DiffUtil.ItemCallback<LifeQuotesInfo>() {
        @Override
        public boolean areItemsTheSame(@NonNull LifeQuotesInfo oldItem, @NonNull LifeQuotesInfo newItem) {
            return oldItem.equals(newItem);
        }

        @Override
        public boolean areContentsTheSame(@NonNull LifeQuotesInfo oldItem, @NonNull LifeQuotesInfo newItem) {
            return oldItem.equals(newItem);
        }
    };
    public LifeQuotesAdapter(ArrayList<LifeQuotesInfo> data) {
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
    public LifeQuotesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_life_quotes_recyclerview,parent,false);
        return new LifeQuotesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LifeQuotesViewHolder holder, int position) {
        //holder.getQuotesText().setText(data.get(position).getQuoteText());
        holder.populate(data.get(position));
    }
}
