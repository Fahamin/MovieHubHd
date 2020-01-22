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
import android.widget.ImageView;
import android.widget.Toast;


import com.smarteist.autoimageslider.DefaultSliderView;
import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderLayout;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.List;

import movie.hd.moviehubhd.R;
import movie.hd.moviehubhd.activity.MainActivity;
import movie.hd.moviehubhd.adapter.HomeAdapter;
import movie.hd.moviehubhd.model.DataHomeModel;
import movie.hd.moviehubhd.model.MovieModel;


public class HomeFragment extends Fragment {

    SliderLayout sliderLayout;


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

        sliderLayout = view.findViewById(R.id.imageSlider);
        sliderLayout.setIndicatorAnimation(IndicatorAnimations.SWAP); //set indicator animation by using SliderLayout.IndicatorAnimations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        sliderLayout.setSliderTransformAnimation(SliderAnimations.FADETRANSFORMATION);
        sliderLayout.setScrollTimeInSec(3); //set scroll delay in seconds :
        setSliderViews();
        setSliderViews();


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

    private void setSliderViews() {
        for (int i = 0; i <= 4; i++) {

            DefaultSliderView sliderView = new DefaultSliderView(getContext());

            switch (i) {
                case 0:
                    sliderView.setImageDrawable(R.drawable.ic_menu_camera);
                    sliderView.setDescription("Action");
                    break;
                case 1:
                    sliderView.setImageDrawable(R.drawable.ic_menu_gallery);
                    sliderView.setDescription("war");
                    break;
                case 2:
                    sliderView.setImageDrawable(R.drawable.ic_menu_manage);
                    sliderView.setDescription("heelo");
                    break;

                case 3:
                    sliderView.setImageDrawable(R.drawable.ic_menu_share);
                    sliderView.setDescription("crime");
                  //  sliderView.setImageUrl("https://images.pexels.com/photos/547114/pexels-photo-547114.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260");
                    break;

            }

            sliderView.setImageScaleType(ImageView.ScaleType.CENTER_CROP);

            final int finalI = i;
            sliderView.setOnSliderClickListener(new SliderView.OnSliderClickListener() {
                @Override
                public void onSliderClick(SliderView sliderView) {
                    Toast.makeText(getContext(), "This is slider " + (finalI + 1), Toast.LENGTH_SHORT).show();
                }
            });

            //at last add this view in your layout :
            sliderLayout.addSliderView(sliderView);
        }
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
