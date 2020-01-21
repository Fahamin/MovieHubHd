package movie.hd.moviehubhd.adapter;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import movie.hd.moviehubhd.R;
import movie.hd.moviehubhd.model.DataHomeModel;


/**
 * Created by enyason on 10/4/18.
 */

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.HomeViewHolder> {


    private Context context;
    private List<DataHomeModel> singleList;


    private MovieAdapter horizontalAdapter;
    private RecyclerView.RecycledViewPool recycledViewPool;

    public HomeAdapter(List<DataHomeModel> data, Context context) {
        this.singleList = data;
        this.context = context;

        recycledViewPool = new RecyclerView.RecycledViewPool();

    }


    @NonNull
    @Override
    public HomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View theView = LayoutInflater.from(context).inflate(R.layout.row_layout_home, parent, false);


        return new HomeViewHolder(theView);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeViewHolder holder, final int position) {

        holder.movieCategoryTxt.setText(singleList.get(position).getMovieCatagoryName());

        horizontalAdapter = new MovieAdapter(singleList.get(position).getList(), context);
        holder.recyclerViewHorizontal.setAdapter(horizontalAdapter);

        holder.recyclerViewHorizontal.setRecycledViewPool(recycledViewPool);


       /* holder.fullLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, singleList.get(position).getList().get(position).getTitle(), Toast.LENGTH_SHORT).show();
            }
        });*/

    }


    @Override
    public int getItemCount() {
        return singleList.size();

    }


    public class HomeViewHolder extends RecyclerView.ViewHolder {

        private RecyclerView recyclerViewHorizontal;
        private TextView movieCategoryTxt;

        private LinearLayoutManager horizontalManager = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);

        RelativeLayout fullLayout;
        public HomeViewHolder(View itemView) {
            super(itemView);

            recyclerViewHorizontal = itemView.findViewById(R.id.home_recycler_view_horizontal);
            recyclerViewHorizontal.setHasFixedSize(true);
            recyclerViewHorizontal.setNestedScrollingEnabled(false);
            recyclerViewHorizontal.setLayoutManager(horizontalManager);
            recyclerViewHorizontal.setItemAnimator(new DefaultItemAnimator());

            movieCategoryTxt = itemView.findViewById(R.id.movie_category);

            fullLayout = itemView.findViewById(R.id.relativeLayout);


        }
    }
}
