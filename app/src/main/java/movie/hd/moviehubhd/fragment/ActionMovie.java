package movie.hd.moviehubhd.fragment;

import android.app.ProgressDialog;
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
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import static movie.hd.moviehubhd.classfile.Utils.actionMovie;
import static movie.hd.moviehubhd.classfile.Utils.progressDialog;
import java.util.ArrayList;
import java.util.List;

import movie.hd.moviehubhd.R;
import movie.hd.moviehubhd.adapter.MovieAdapter;
import movie.hd.moviehubhd.model.MovieModel;

public class ActionMovie extends Fragment {
    public SearchView searchView;
    public static  SearchView.OnQueryTextListener queryTextListener;
    public static RecyclerView recyclerView;
    public static List<MovieModel> list;
    MovieAdapter adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_action_movie, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        list = new ArrayList<>();

        recyclerView = view.findViewById(R.id.actionMovieID);
        progressDialog = new ProgressDialog(getContext());
        progressDialog.setMessage("Loading data. Please wait....");
        progressDialog.setCancelable(false);
        progressDialog.show();

        loadData();

    }

    private void loadData() {
        actionMovie.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list.clear();
                Iterable<DataSnapshot> allSingleItem = dataSnapshot.getChildren();

                for (DataSnapshot singleItem : allSingleItem) {
                    MovieModel dataModel = singleItem.getValue(MovieModel.class);
                    list.add(dataModel);
                }

                adapter = new MovieAdapter(getContext(),recyclerView,list);
                recyclerView.setLayoutManager(new GridLayoutManager(getContext(),3));
                // recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                recyclerView.setAdapter(adapter);

                progressDialog.dismiss();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getContext(), "Loading Failed ! Check Network Connection", Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();
            }
        });
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


