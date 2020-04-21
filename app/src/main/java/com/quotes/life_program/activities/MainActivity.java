package com.quotes.life_program.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;

import com.quotes.life_program.R;
import com.quotes.life_program.api.LifeQuotesServiceGenerator;
import com.quotes.life_program.fragments.QuotesAdapter;
import com.quotes.life_program.model.LifeQuotesList;
import com.quotes.life_program.views.LifeQuotesAdapter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView ;
    private LifeQuotesAdapter adapter;
    private LifeQuotesList lifeQuotesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Added viewpager and Main adapter
        ViewPager myView = findViewById(R.id.viewPager);
        QuotesAdapter myAdapter = new QuotesAdapter(
                getSupportFragmentManager(),
                FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
        );
        //Linking main adapter and view pager
        myView.setAdapter(myAdapter);
    }
}
