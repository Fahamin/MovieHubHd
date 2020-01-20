package movie.hd.moviehubhd.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import movie.hd.moviehubhd.R;
import movie.hd.moviehubhd.model.MovieModel;


public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieHolder>implements Filterable {

    Context context;
    RecyclerView recyclerView;
    ArrayList<MovieModel> movieList,searchList;

    public MovieAdapter(Context context, RecyclerView recyclerView, ArrayList<MovieModel> movieList) {
        this.context = context;
        this.recyclerView = recyclerView;
        this.movieList = movieList;
        this.searchList = movieList;
    }

    @NonNull
    @Override
    public MovieHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.movie_view, null);

        return new MovieHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieHolder holder, final int position) {

        holder.titleTxt.setText(movieList.get(position).getTitle());
        holder.imageThumble.setImageResource(R.drawable.ic_search);


        holder.movie_Layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, movieList.get(position).getTitle(), Toast.LENGTH_SHORT).show();
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
                if(charString.isEmpty())
                {
                    movieList =searchList;
                }
                else {
                    ArrayList<MovieModel> filterList = new ArrayList<>();

                    for(MovieModel MovieModel : searchList)
                    {
                        if(MovieModel.getTitle().toLowerCase().contains(charString))
                        {
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
                movieList = (ArrayList<MovieModel>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }

    public class MovieHolder extends RecyclerView.ViewHolder {

        ImageView imageThumble;
        TextView titleTxt;
        ConstraintLayout movie_Layout;

        public MovieHolder(@NonNull View itemView) {
            super(itemView);

            imageThumble = itemView.findViewById(R.id.imageViewID);
            titleTxt = itemView.findViewById(R.id.movieTitleTV);
            movie_Layout = itemView.findViewById(R.id.fullMovieLayout);

        }

    }
}
