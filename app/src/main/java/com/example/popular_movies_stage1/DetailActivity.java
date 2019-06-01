package com.example.popular_movies_stage1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;



public class DetailActivity extends AppCompatActivity {

    TextView movieTitle;
    TextView mSynopsis;
    TextView mReleaseDate;
    TextView mVoteAverage;
    TextView mPopular;
    ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        movieTitle = findViewById(R.id.tv_title);
        mSynopsis = findViewById(R.id.tv_plot_synopsis);
        mReleaseDate = findViewById(R.id.tv_release_date);
        mVoteAverage = findViewById(R.id.tv_vote_average);
        mPopular = findViewById(R.id.tv_popularity);
        mImageView = findViewById(R.id.detail_image_view);

        Intent intent = getIntent();

        String imageUrl = intent.getExtras().getString("imageUrl");
        String movieName = intent.getExtras().getString("movieName");
        String synopsis = intent.getExtras().getString("synopsis");
        String releaseDate = intent.getExtras().getString("releaseDate");
        String voteAverage = intent.getExtras().getString("voteAverage");
        String popularity = intent.getExtras().getString("popular");

        Picasso.get().load(imageUrl)
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)
                .fit().centerInside().into(mImageView);
        movieTitle.append(movieName);
        mSynopsis.append(synopsis);
        mReleaseDate.append(releaseDate);
        mVoteAverage.append(voteAverage);
        mPopular.append(popularity);
        }
}
