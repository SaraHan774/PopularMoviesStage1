package com.example.popular_movies_stage1;


import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

//ADAPTER
public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {
    private Context mContext;
    private ArrayList<MovieItem> mMovieItem;


    public MovieAdapter(Context context, ArrayList<MovieItem> movieItems){
        mContext = context;
        mMovieItem = movieItems;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.movie_cardview, viewGroup, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MovieViewHolder holder, int position) {
        final MovieItem currentItem = mMovieItem.get(position);
        final String imageUrl = currentItem.getmImageUrl();
        final String movieName = currentItem.getmMovieName();
        final String synopsis = currentItem.getmSynopsis();
        final String releaseDate = currentItem.getmReleaseDate();
        final String voteAverage = currentItem.getmVoteAverage();
        final String popularity = currentItem.getmPopular();

        holder.mTextViewName.setText(movieName);
        Picasso.get().load(imageUrl)
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)
                .fit().centerInside().into(holder.mImageView);

        holder.itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, DetailActivity.class);
                intent.putExtra("imageUrl", imageUrl);
                intent.putExtra("movieName", movieName);
                intent.putExtra("synopsis", synopsis);
                intent.putExtra("releaseDate", releaseDate);
                intent.putExtra("voteAverage", voteAverage);
                intent.putExtra("popular", popularity);
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mMovieItem.size();
    }


//VIEW HOLDER
    public class MovieViewHolder extends RecyclerView.ViewHolder{
        public ImageView mImageView;
        public TextView mTextViewName;

        public MovieViewHolder(View itemView) {
            super(itemView);

            mImageView = itemView.findViewById(R.id.image_view);
            mTextViewName = itemView.findViewById(R.id.tv_movieName);

        }
    }
}
