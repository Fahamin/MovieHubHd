package movie.hd.moviehubhd.fragment;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.core.view.MenuItemCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import movie.hd.moviehubhd.R;
import movie.hd.moviehubhd.activity.MainActivity;
import movie.hd.moviehubhd.activity.TabAct;
import movie.hd.moviehubhd.adapter.MovieAdapter;
import movie.hd.moviehubhd.model.MovieModel;



public class WarMovie extends Fragment {
    public SearchView searchView;
    public static  SearchView.OnQueryTextListener queryTextListener;
    public static RecyclerView recyclerView;
    public static  ArrayList<MovieModel> list;
    MovieAdapter adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_war_movie, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.warMovieID);

        list = new ArrayList<>();

        list.add(new MovieModel("k","tt","dd","23","12.12","hlll"));
        list.add(new MovieModel("k","trr","dd","23","12.12","hlll"));
        list.add(new MovieModel("k","thjk","dd","23","12.12","hlll"));
        list.add(new MovieModel("k","ee","dd","23","12.12","hlll"));
        list.add(new MovieModel("k","oo","dd","23","12.12","hlll"));
        list.add(new MovieModel("k","pp","dd","23","12.12","hlll"));
        list.add(new MovieModel("k","ll","dd","23","12.12","hlll"));
        list.add(new MovieModel("k","ww","dd","23","12.12","hlll"));

      MovieAdapter  adapter = new MovieAdapter(getContext(),recyclerView,list);
        // recyclerView.setLayoutManager(new GridLayoutManager(getContext(),3));
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);

    }


    @Override
    public void onDestroyOptionsMenu() {
        super.onDestroyOptionsMenu();

        if (searchView != null &&
                !searchView.getQuery().toString().isEmpty()) {

            searchView.setIconified(true);
            searchView.setIconified(true);
        }
    }
}
