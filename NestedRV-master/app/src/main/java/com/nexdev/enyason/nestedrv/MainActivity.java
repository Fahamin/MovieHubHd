package com.nexdev.enyason.nestedrv;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.nexdev.enyason.nestedrv.Adapter.HomeAdapter;
import com.nexdev.enyason.nestedrv.Api.RetrofitSingleton;
import com.nexdev.enyason.nestedrv.Model.Data;
import com.nexdev.enyason.nestedrv.Model.HomeBodyResponse;
import com.nexdev.enyason.nestedrv.Model.Movie;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {


    private static final String TAG = "MainActivity";


    private List<Data> dataList;

    List<Movie> aclist, adlist, splist;

    //android viewa
    private ProgressBar progressBar;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        dataList = new ArrayList<>();
        aclist = new ArrayList<>();
        adlist = new ArrayList<>();
        splist = new ArrayList<>();


        aclistfun();
        adlistfun();
        splistdun();


        dataList.add(new Data(aclist, "gen", "action"));
        dataList.add(new Data(adlist, "gen", "action"));
        dataList.add(new Data(splist, "gen", "action"));


        adapter = new HomeAdapter(dataList, this);
        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);


        recyclerView = findViewById(R.id.rv_main);
        progressBar = findViewById(R.id.pb_home);


        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);


/*
        Call<HomeBodyResponse> responseCall = RetrofitSingleton.getInstance().getApi().getMovieByCategory();

        responseCall.enqueue(new Callback<HomeBodyResponse>() {
            @Override
            public void onResponse(Call<HomeBodyResponse> call, Response<HomeBodyResponse> response) {
                progressBar.setVisibility(View.GONE);

                for (Data data : response.body().getData().getData()) {

                    dataList.add(data);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<HomeBodyResponse> call, Throwable t) {

                progressBar.setVisibility(View.GONE);

            }
        });*/
    }

    private void splistdun() {
        splist.add(new Movie("HH", "DD", "TT", "LL"));
        splist.add(new Movie("HH", "DD", "TT", "LL"));
        splist.add(new Movie("HH", "DD", "TT", "LL"));
        splist.add(new Movie("HH", "DD", "TT", "LL"));
        splist.add(new Movie("HH", "DD", "TT", "LL"));
        splist.add(new Movie("HH", "DD", "TT", "LL"));

    }

    private void adlistfun() {
        adlist.add(new Movie("HH", "DD", "TT", "LL"));
        adlist.add(new Movie("HH", "DD", "TT", "LL"));
        adlist.add(new Movie("HH", "DD", "TT", "LL"));
        adlist.add(new Movie("HH", "DD", "TT", "LL"));
        adlist.add(new Movie("HH", "DD", "TT", "LL"));
        adlist.add(new Movie("HH", "DD", "TT", "LL"));
        adlist.add(new Movie("HH", "DD", "TT", "LL"));

    }

    private void aclistfun() {
        aclist.add(new Movie("HH", "DD", "TT", "LL"));
        aclist.add(new Movie("HH", "DD", "TT", "LL"));
        aclist.add(new Movie("HH", "DD", "TT", "LL"));
        aclist.add(new Movie("HH", "DD", "TT", "LL"));
        aclist.add(new Movie("HH", "DD", "TT", "LL"));
        aclist.add(new Movie("HH", "DD", "TT", "LL"));
        aclist.add(new Movie("HH", "DD", "TT", "LL"));
        aclist.add(new Movie("HH", "DD", "TT", "LL"));
        aclist.add(new Movie("HH", "DD", "TT", "LL"));


    }
}
