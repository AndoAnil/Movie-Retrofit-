package com.example.moviesretrofit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.Viewholder> {

    private Context context;
    private List<Movie> movies;

    public MovieAdapter(Context context, List<Movie> movies) {
        this.context = context;
        this.movies = movies;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_item, parent, false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
     holder.title.setText(movies.get(position).getTitle());
     holder.duration.setText(movies.get(position).getTitle());
     holder.category.setText(movies.get(position).getMoreDetails().getCategory());
     holder.releasedate.setText(movies.get(position).getMoreDetails().getRelease());
     holder.ratingBar.setRating(Float.parseFloat(String.valueOf(movies.get(position).getRating())));
     Glide.with(context).load(movies.get(position).getPoster()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder
    {
         ImageView imageView;
         TextView title,duration,category,releasedate;
         RatingBar ratingBar;
        public Viewholder(@NonNull View itemView) {
            super(itemView);
            imageView=(ImageView) itemView.findViewById(R.id.imageView);
            title =(TextView) itemView.findViewById(R.id.textView2);
            duration=(TextView) itemView.findViewById(R.id.textView3);
            category=(TextView) itemView.findViewById(R.id.textView);
            releasedate=(TextView) itemView.findViewById(R.id.textView4);
            ratingBar=(RatingBar) itemView.findViewById(R.id.ratingBar);
        }
    }
}
