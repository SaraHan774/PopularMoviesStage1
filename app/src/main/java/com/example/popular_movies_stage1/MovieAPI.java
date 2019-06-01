package com.example.popular_movies_stage1;


import android.net.Uri;

public class MovieAPI{

    private static final String MOVIE_API_POPULARITY =
            "https://api.themoviedb.org/3/movie/popular?&api_key=";

    private static final String MOVIE_API_VOTE_AVERAGE =
            "https://api.themoviedb.org/3/movie/top_rated?api_key=";

    //TODO : Your API Key goes here
    private static final String API_KEY = "";


    public static String queryUrl(int item){
        if(item == R.id.top_rated){
            return MOVIE_API_VOTE_AVERAGE + API_KEY;
        }
        return MOVIE_API_POPULARITY + API_KEY;
    }


}
