package com.quotes.life_program.fragments;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class QuotesAdapter extends FragmentStatePagerAdapter {
    public QuotesAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch(position){
            case 0: return new LifeQuotesFragment();
            case 1: return new ProgramQuotesFragment();
            default: return new LifeQuotesFragment();

        }
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if(position==0){
            return "Life Quotes";
        }else{
            return "Program Quotes";
        }
    }

    @Override
    public int getCount() {
        return 2;
    }
}
