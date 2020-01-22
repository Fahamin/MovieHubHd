package movie.hd.moviehubhd.fragment;

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

import java.util.ArrayList;
import java.util.List;

import movie.hd.moviehubhd.R;
import movie.hd.moviehubhd.activity.MainActivity;
import movie.hd.moviehubhd.adapter.FavAdapeter;
import movie.hd.moviehubhd.model.FavModel;
import movie.hd.moviehubhd.model.MovieModel;


public class FavoriteFrag extends Fragment {


    RecyclerView recyclerView;
    List<FavModel> list;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favorite, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.favRecViewId);
        list = new ArrayList<>();

        list =  MainActivity.favDatabase.favoriteDao().getFavoriteData();
        FavAdapeter adapter = new FavAdapeter(getContext(),recyclerView, list);    //    MainAdapter adapter = new MainAdapter(getContext(),list);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),3));
        //recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);
    }
}
