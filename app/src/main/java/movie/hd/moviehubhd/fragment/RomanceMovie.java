package movie.hd.moviehubhd.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
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


public class RomanceMovie extends Fragment {


    public SearchView searchView;
    public static  SearchView.OnQueryTextListener queryTextListener;
    public static RecyclerView recyclerView;
    public static  ArrayList<MovieModel> list;
    MovieAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_romance_movie, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        recyclerView = view.findViewById(R.id.romanceMovieID);

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


}
