package movie.hd.moviehubhd.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import movie.hd.moviehubhd.R;
import movie.hd.moviehubhd.adapter.HomeAdapter;
import movie.hd.moviehubhd.model.DataHomeModel;
import movie.hd.moviehubhd.model.MovieModel;


public class HomeFragment extends Fragment {


    RecyclerView recyclerView;
    List<DataHomeModel> homeList;


    List<MovieModel>actionMovieList;
    List<MovieModel>adventureMovieList;
    List<MovieModel>animationMovieList;
    List<MovieModel>comedyMovieList;
    List<MovieModel>crimeMovieList;
    List<MovieModel>horrorMovieList;
    List<MovieModel>romanceMovieList;
    List<MovieModel>sportMovieList;
    List<MovieModel>thillerMovieList;
    List<MovieModel>warMovieList;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        homeList = new ArrayList<>();

        recyclerView = view.findViewById(R.id.homeRecleviewID);
        actionMovieList = new ArrayList<>();
        adventureMovieList = new ArrayList<>();
        animationMovieList = new ArrayList<>();
        comedyMovieList = new ArrayList<>();
        crimeMovieList = new ArrayList<>();
        horrorMovieList = new ArrayList<>();
        romanceMovieList = new ArrayList<>();
        sportMovieList = new ArrayList<>();
        thillerMovieList = new ArrayList<>();
        warMovieList = new ArrayList<>();

        warMovieFun();
        thillerMovieFun();
        sportMovieFun();
        romanceMovieFun();
        horrorMovieFun();
        crimeMovieFun();
        comedyMovieFun();
        animationMovieFun();
        actionmovieFun();
        adventureMovieFun();


        homeList.add(new DataHomeModel(actionMovieList,"Action"));
        homeList.add(new DataHomeModel(adventureMovieList,"Advenure"));
        homeList.add(new DataHomeModel(animationMovieList,"Animation"));
        homeList.add(new DataHomeModel(sportMovieList,"Sport"));
        homeList.add(new DataHomeModel(comedyMovieList,"Comedy"));
        homeList.add(new DataHomeModel(crimeMovieList,"Crime"));
        homeList.add(new DataHomeModel(romanceMovieList,"Romance"));
        homeList.add(new DataHomeModel(warMovieList,"War"));
        homeList.add(new DataHomeModel(thillerMovieList,"Thiler"));
        homeList.add(new DataHomeModel(horrorMovieList,"Horror"));


        HomeAdapter adapter = new HomeAdapter(homeList,getContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);
    }

    private void warMovieFun() {
        warMovieList.add(new MovieModel(1,"k","tt","dd","23","12.12","hlll"));
        warMovieList.add(new MovieModel(2,"k","trr","dd","23","12.12","hlll"));
        warMovieList.add(new MovieModel(3,"k","thjk","dd","23","12.12","hlll"));
        warMovieList.add(new MovieModel(4,"k","ee","dd","23","12.12","hlll"));

    }

    private void thillerMovieFun() {
        thillerMovieList.add(new MovieModel(1,"k","tt","dd","23","12.12","hlll"));
        thillerMovieList.add(new MovieModel(1,"k","tt","dd","23","12.12","hlll"));
        thillerMovieList.add(new MovieModel(1,"k","tt","dd","23","12.12","hlll"));
        thillerMovieList.add(new MovieModel(1,"k","tt","dd","23","12.12","hlll"));

    }

    private void sportMovieFun() {
        sportMovieList.add(new MovieModel(1,"k","tt","dd","23","12.12","hlll"));
        sportMovieList.add(new MovieModel(1,"k","tt","dd","23","12.12","hlll"));
        sportMovieList.add(new MovieModel(1,"k","tt","dd","23","12.12","hlll"));
        sportMovieList.add(new MovieModel(1,"k","tt","dd","23","12.12","hlll"));

    }

    private void romanceMovieFun() {
        romanceMovieList.add(new MovieModel(1,"k","tt","dd","23","12.12","hlll"));
        romanceMovieList.add(new MovieModel(1,"k","tt","dd","23","12.12","hlll"));
        romanceMovieList.add(new MovieModel(1,"k","tt","dd","23","12.12","hlll"));
        romanceMovieList.add(new MovieModel(1,"k","tt","dd","23","12.12","hlll"));

    }

    private void horrorMovieFun() {
        horrorMovieList.add(new MovieModel(1,"k","tt","dd","23","12.12","hlll"));
        horrorMovieList.add(new MovieModel(1,"k","tt","dd","23","12.12","hlll"));
        horrorMovieList.add(new MovieModel(1,"k","tt","dd","23","12.12","hlll"));
        horrorMovieList.add(new MovieModel(1,"k","tt","dd","23","12.12","hlll"));

    }

    private void crimeMovieFun() {
        crimeMovieList.add(new MovieModel(1,"k","tt","dd","23","12.12","hlll"));
        crimeMovieList.add(new MovieModel(1,"k","tt","dd","23","12.12","hlll"));
        crimeMovieList.add(new MovieModel(1,"k","tt","dd","23","12.12","hlll"));

    }

    private void comedyMovieFun() {
        comedyMovieList.add(new MovieModel(1,"k","tt","dd","23","12.12","hlll"));
        comedyMovieList.add(new MovieModel(1,"k","tt","dd","23","12.12","hlll"));
        comedyMovieList.add(new MovieModel(1,"k","tt","dd","23","12.12","hlll"));
        comedyMovieList.add(new MovieModel(1,"k","tt","dd","23","12.12","hlll"));

    }

    private void animationMovieFun() {
        animationMovieList.add(new MovieModel(1,"k","tt","dd","23","12.12","hlll"));
        animationMovieList.add(new MovieModel(1,"k","tt","dd","23","12.12","hlll"));
        animationMovieList.add(new MovieModel(1,"k","tt","dd","23","12.12","hlll"));
        animationMovieList.add(new MovieModel(1,"k","tt","dd","23","12.12","hlll"));

    }

    private void adventureMovieFun() {
        adventureMovieList.add(new MovieModel(1,"k","tt","dd","23","12.12","hlll"));
        adventureMovieList.add(new MovieModel(1,"k","tt","dd","23","12.12","hlll"));
        adventureMovieList.add(new MovieModel(1,"k","tt","dd","23","12.12","hlll"));
        adventureMovieList.add(new MovieModel(1,"k","tt","dd","23","12.12","hlll"));

    }

    private void actionmovieFun() {
        actionMovieList.add(new MovieModel(1,"k","tt","dd","23","12.12","hlll"));
        actionMovieList.add(new MovieModel(1,"k","tt","dd","23","12.12","hlll"));
        actionMovieList.add(new MovieModel(1,"k","tt","dd","23","12.12","hlll"));
        actionMovieList.add(new MovieModel(1,"k","tt","dd","23","12.12","hlll"));
    }
}
