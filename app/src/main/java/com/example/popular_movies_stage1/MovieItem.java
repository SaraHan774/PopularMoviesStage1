package com.example.popular_movies_stage1;


public class MovieItem{

    private String mImageUrl;
    private String mMovieName;
    private String mSynopsis;
    private String mReleaseDate;
    private String mVoteAverage;
    private String mPopular;

    public MovieItem(String mImageUrl, String mMovieName, String mSynopsis, String mReleaseDate
    , String mVoteAverage, String mPopular){
        this.mImageUrl =  mImageUrl;
        this.mMovieName = mMovieName;
        this.mSynopsis = mSynopsis;
        this.mReleaseDate = mReleaseDate;
        this.mVoteAverage = mVoteAverage;
        this.mPopular = mPopular;
    }


    public String getmImageUrl(){
        return mImageUrl;
    }

    public String getmMovieName(){
        return mMovieName;
    }

    public String getmSynopsis() {
        return mSynopsis;
    }

    public String getmReleaseDate() {
        return mReleaseDate;
    }

    public String getmVoteAverage() {
        return mVoteAverage;
    }

    public String getmPopular() {
        return mPopular;
    }



}
