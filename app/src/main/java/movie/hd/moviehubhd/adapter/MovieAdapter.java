package movie.hd.moviehubhd.adapter;

import android.content.Context;
import android.content.Intent;
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
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubeThumbnailLoader;
import com.google.android.youtube.player.YouTubeThumbnailView;

import java.util.ArrayList;
import java.util.List;

import movie.hd.moviehubhd.R;
import movie.hd.moviehubhd.activity.FirebaseSetup;
import movie.hd.moviehubhd.activity.MainActivity;
import movie.hd.moviehubhd.activity.PlayerAct;
import movie.hd.moviehubhd.api.YoutubeAdd;
import movie.hd.moviehubhd.model.FavModel;
import movie.hd.moviehubhd.model.MovieModel;


public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieHolder> implements Filterable {

    Context context;
    RecyclerView recyclerView;
    List<MovieModel> movieList, searchList;

    public MovieAdapter(Context context, RecyclerView recyclerView, List<MovieModel> movieList) {
        this.context = context;
        this.recyclerView = recyclerView;
        this.movieList = movieList;
        this.searchList = movieList;
    }

    public MovieAdapter(List<MovieModel> movieList, Context context) {
        this.context = context;
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

        final MovieModel movieModel = movieList.get(position);
        holder.titleTxt.setText(movieList.get(position).getname());

        holder.imageThumble.initialize(YoutubeAdd.getApi_KEY(), new YouTubeThumbnailView.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubeThumbnailView youTubeThumbnailView, final YouTubeThumbnailLoader youTubeThumbnailLoader) {

                youTubeThumbnailLoader.setVideo(movieModel.getLink());
                youTubeThumbnailLoader.setOnThumbnailLoadedListener(new YouTubeThumbnailLoader.OnThumbnailLoadedListener() {
                    @Override
                    public void onThumbnailLoaded(YouTubeThumbnailView youTubeThumbnailView, String s) {
                        youTubeThumbnailLoader.release();
                    }

                    @Override
                    public void onThumbnailError(YouTubeThumbnailView youTubeThumbnailView, YouTubeThumbnailLoader.ErrorReason errorReason) {

                    }
                });
            }

            @Override
            public void onInitializationFailure(YouTubeThumbnailView youTubeThumbnailView, YouTubeInitializationResult youTubeInitializationResult) {

            }
        });

        if (MainActivity.favDatabase.favoriteDao().isFavorite(movieModel.getId()) == 1) {
            holder.fav_btn.setImageResource(R.drawable.fav_red);
        } else {
            holder.fav_btn.setImageResource(R.drawable.fav_white);

        }


        holder.fav_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FavModel favModel = new FavModel();

                int id = movieModel.getId();
                String name = movieModel.getname();
                String des = movieModel.getDescription();
                String keyid = movieModel.getKey_id();
                String length = movieModel.getLength();
                String date = movieModel.getDate();
                String link = movieModel.getLink();


                favModel.setId(id);
                favModel.setName(name);
                favModel.setDescription(des);
                favModel.setKey_id(keyid);
                favModel.setLength(length);
                favModel.setLink(link);
                favModel.setDate(date);

                if (MainActivity.favDatabase.favoriteDao().isFavorite(id) != 1) {
                    holder.fav_btn.setImageResource(R.drawable.fav_red);
                    MainActivity.favDatabase.favoriteDao().addData(favModel);
                    Toast.makeText(context, "added", Toast.LENGTH_SHORT).show();
                } else {
                    holder.fav_btn.setImageResource(R.drawable.fav_white);
                    MainActivity.favDatabase.favoriteDao().delete(favModel);
                    Toast.makeText(context, "remove", Toast.LENGTH_SHORT).show();
                }


            }
        });
        holder.movie_Layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               context.startActivity(new Intent(context, PlayerAct.class).putExtra("video_id",movieModel.getLink()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {

                String charString = charSequence.toString();
                if (charString.isEmpty()) {
                    movieList = searchList;
                } else {
                    List<MovieModel> filterList = new ArrayList<>();

                    for (MovieModel MovieModel : searchList) {
                        if (MovieModel.getname().toLowerCase().contains(charString)) {
                            filterList.add(MovieModel);
                        }
                    }
                    movieList = filterList;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = movieList;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                movieList = (List<MovieModel>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }

    public class MovieHolder extends RecyclerView.ViewHolder {

        YouTubeThumbnailView imageThumble;
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
