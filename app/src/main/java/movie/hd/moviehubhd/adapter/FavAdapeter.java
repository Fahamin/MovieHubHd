package movie.hd.moviehubhd.adapter;

import android.content.Context;
import android.os.Vibrator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import movie.hd.moviehubhd.R;
import movie.hd.moviehubhd.activity.MainActivity;
import movie.hd.moviehubhd.model.FavModel;
import movie.hd.moviehubhd.model.MovieModel;

public class FavAdapeter extends RecyclerView.Adapter<FavAdapeter.MovieHolder>  {

    Context context;
    RecyclerView recyclerView;
    List<FavModel> movieList;

    public FavAdapeter(Context context, RecyclerView recyclerView, List<FavModel> movieList) {
        this.context = context;
        this.recyclerView = recyclerView;
        this.movieList = movieList;
    }

    @NonNull
    @Override
    public MovieHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_layout_movie, null);
        return new MovieHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MovieHolder holder, final int position) {
        final FavModel movieModel = movieList.get(position);
        holder.titleTxt.setText(movieList.get(position).getName());

        holder.imageThumble.setImageResource(R.drawable.ic_search);


        if (MainActivity.favDatabase.favoriteDao().isFavorite(movieModel.getId()) == 1) {
            holder.fav_btn.setImageResource(R.drawable.fav_red);
        } else {
            holder.fav_btn.setImageResource(R.drawable.fav_white);

        }


        holder.fav_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FavModel favModel = new FavModel();


                holder.fav_btn.setImageResource(R.drawable.fav_white);
                MainActivity.favDatabase.favoriteDao().delete(favModel);
                Toast.makeText(context, "remove", Toast.LENGTH_SHORT).show();


            }
        });
        holder.movie_Layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, movieList.get(position).getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }



    @Override
    public int getItemCount() {
        return movieList.size();
    }


    public class MovieHolder extends RecyclerView.ViewHolder {

        ImageView imageThumble;
        TextView titleTxt;
        RelativeLayout movie_Layout;
        ImageView fav_btn;

        public MovieHolder(@NonNull View itemView) {
            super(itemView);

            imageThumble = itemView.findViewById(R.id.imageViewID);
            titleTxt = itemView.findViewById(R.id.movieTitleTV);
            movie_Layout = itemView.findViewById(R.id.fulllaMOVIyoutID);
            fav_btn = itemView.findViewById(R.id.favId);

        }

    }
}
