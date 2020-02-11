package movie.hd.moviehubhd.fragment;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;


import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;
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
import movie.hd.moviehubhd.adapter.MovieAdapter;
import movie.hd.moviehubhd.model.DataHomeModel;
import movie.hd.moviehubhd.model.MovieModel;

import static movie.hd.moviehubhd.classfile.Utils.actionF;
import static movie.hd.moviehubhd.classfile.Utils.adventureF;
import static movie.hd.moviehubhd.classfile.Utils.animationF;
import static movie.hd.moviehubhd.classfile.Utils.comedyF;
import static movie.hd.moviehubhd.classfile.Utils.crimeF;
import static movie.hd.moviehubhd.classfile.Utils.horrorF;
import static movie.hd.moviehubhd.classfile.Utils.progressDialog;
import static movie.hd.moviehubhd.classfile.Utils.romanceF;
import static movie.hd.moviehubhd.classfile.Utils.sportF;
import static movie.hd.moviehubhd.classfile.Utils.thillerF;
import static movie.hd.moviehubhd.classfile.Utils.warF;


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

        progressDialog = new ProgressDialog(getContext());
        progressDialog.setMessage("Loading data. Please wait....");
        progressDialog.setCancelable(false);
        progressDialog.show();

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


        homeList.add(new DataHomeModel(actionMovieList,"Action Movie"));
        homeList.add(new DataHomeModel(adventureMovieList,"Advenure Movie"));
        homeList.add(new DataHomeModel(animationMovieList,"Animation Movie"));
        homeList.add(new DataHomeModel(sportMovieList,"Sport Movie"));
        homeList.add(new DataHomeModel(comedyMovieList,"Comedy Movie"));
        homeList.add(new DataHomeModel(crimeMovieList,"Crime Movie"));
        homeList.add(new DataHomeModel(romanceMovieList,"Romance Movie"));
        homeList.add(new DataHomeModel(warMovieList,"War Movie"));
        homeList.add(new DataHomeModel(thillerMovieList,"Thiler Movie"));
        homeList.add(new DataHomeModel(horrorMovieList,"Horror Movie"));


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

        warF.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                warMovieList.clear();
                Iterable<DataSnapshot> allSingleItem = dataSnapshot.getChildren();

                for (DataSnapshot singleItem : allSingleItem) {
                    MovieModel dataModel = singleItem.getValue(MovieModel.class);
                    warMovieList.add(dataModel);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

    private void thillerMovieFun() {


        thillerF.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                thillerMovieList.clear();
                Iterable<DataSnapshot> allSingleItem = dataSnapshot.getChildren();

                for (DataSnapshot singleItem : allSingleItem) {
                    MovieModel dataModel = singleItem.getValue(MovieModel.class);
                    thillerMovieList.add(dataModel);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    private void sportMovieFun() {

        sportF.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                sportMovieList.clear();
                Iterable<DataSnapshot> allSingleItem = dataSnapshot.getChildren();

                for (DataSnapshot singleItem : allSingleItem) {
                    MovieModel dataModel = singleItem.getValue(MovieModel.class);
                    sportMovieList.add(dataModel);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    private void romanceMovieFun() {

        romanceF.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                romanceMovieList.clear();
                Iterable<DataSnapshot> allSingleItem = dataSnapshot.getChildren();

                for (DataSnapshot singleItem : allSingleItem) {
                    MovieModel dataModel = singleItem.getValue(MovieModel.class);
                    romanceMovieList.add(dataModel);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

    private void horrorMovieFun() {


        horrorF.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                horrorMovieList.clear();
                Iterable<DataSnapshot> allSingleItem = dataSnapshot.getChildren();

                for (DataSnapshot singleItem : allSingleItem) {
                    MovieModel dataModel = singleItem.getValue(MovieModel.class);
                    horrorMovieList.add(dataModel);
                    progressDialog.dismiss();
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                progressDialog.dismiss();

            }
        });
    }

    private void crimeMovieFun() {
        crimeF.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                crimeMovieList.clear();
                Iterable<DataSnapshot> allSingleItem = dataSnapshot.getChildren();

                for (DataSnapshot singleItem : allSingleItem) {
                    MovieModel dataModel = singleItem.getValue(MovieModel.class);
                    crimeMovieList.add(dataModel);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

    private void comedyMovieFun() {
        comedyF.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                comedyMovieList.clear();
                Iterable<DataSnapshot> allSingleItem = dataSnapshot.getChildren();

                for (DataSnapshot singleItem : allSingleItem) {
                    MovieModel dataModel = singleItem.getValue(MovieModel.class);
                    comedyMovieList.add(dataModel);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

    private void animationMovieFun() {
        animationF.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                animationMovieList.clear();
                Iterable<DataSnapshot> allSingleItem = dataSnapshot.getChildren();

                for (DataSnapshot singleItem : allSingleItem) {
                    MovieModel dataModel = singleItem.getValue(MovieModel.class);
                    animationMovieList.add(dataModel);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

    private void adventureMovieFun() {
        adventureF.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                adventureMovieList.clear();
                Iterable<DataSnapshot> allSingleItem = dataSnapshot.getChildren();

                for (DataSnapshot singleItem : allSingleItem) {
                    MovieModel dataModel = singleItem.getValue(MovieModel.class);
                    adventureMovieList.add(dataModel);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    private void actionmovieFun() {
        actionF.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                actionMovieList.clear();
                Iterable<DataSnapshot> allSingleItem = dataSnapshot.getChildren();

                for (DataSnapshot singleItem : allSingleItem) {
                    MovieModel dataModel = singleItem.getValue(MovieModel.class);
                    actionMovieList.add(dataModel);
                    progressDialog.dismiss();
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                progressDialog.dismiss();

            }
        });

    }
}
