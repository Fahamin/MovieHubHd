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
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import movie.hd.moviehubhd.R;
import movie.hd.moviehubhd.adapter.MovieAdapter;
import movie.hd.moviehubhd.model.MovieModel;


public class AdventureMovie extends Fragment {


    public SearchView searchView;
    public static  SearchView.OnQueryTextListener queryTextListener;
    public static RecyclerView recyclerView;
    public static  ArrayList<MovieModel> list;
    MovieAdapter adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_adventure_movie, container, false);


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.advencherMovieID);

        list = new ArrayList<>();

        list.add(new MovieModel("k","tt","dd","23","12.12","hlll"));
        list.add(new MovieModel("k","trr","dd","23","12.12","hlll"));
        list.add(new MovieModel("k","thjk","dd","23","12.12","hlll"));
        list.add(new MovieModel("k","ee","dd","23","12.12","hlll"));
        list.add(new MovieModel("k","oo","dd","23","12.12","hlll"));
        list.add(new MovieModel("k","pp","dd","23","12.12","hlll"));
        list.add(new MovieModel("k","ll","dd","23","12.12","hlll"));
        list.add(new MovieModel("k","ww","dd","23","12.12","hlll"));

        adapter = new MovieAdapter(getContext(),recyclerView,list);
        // recyclerView.setLayoutManager(new GridLayoutManager(getContext(),3));
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);

    }



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu, menu);
        MenuItem searchItem = menu.findItem(R.id.serchID);
        SearchManager searchManager = (SearchManager) getActivity().getSystemService(Context.SEARCH_SERVICE);

        if (searchItem != null) {
            searchView = (SearchView) searchItem.getActionView();
        }
        if (searchView != null) {
            searchView.setSearchableInfo(searchManager.getSearchableInfo(getActivity().getComponentName()));

            queryTextListener = new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextChange(String newText) {
                    Log.i("onQueryTextChange", newText);

                    if (adapter != null) {
                        adapter.getFilter().filter(newText);
                    }

                    return true;
                }
                @Override
                public boolean onQueryTextSubmit(String query) {
                    Log.i("onQueryTextSubmit", query);

                    return true;
                }
            };
            searchView.setOnQueryTextListener(queryTextListener);
        }
        super.onCreateOptionsMenu(menu, inflater);
    }
}