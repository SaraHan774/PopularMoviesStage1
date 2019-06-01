package com.example.popular_movies_stage1;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;



public class MainActivity extends AppCompatActivity{
    private RecyclerView mRecyclerView;
    private MovieAdapter movieAdapter;
    private ArrayList<MovieItem> mMovieList = new ArrayList<>();
    private RequestQueue mRequestQueue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRequestQueue = Volley.newRequestQueue(this);
        mRecyclerView = findViewById(R.id.rv_movie);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this,2));
        parseJSON(MovieAPI.queryUrl(R.id.popular));
    }

    @Override
    //Activity 객체 만들어 질 때 자동으로 호출되는 메서드
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.movie_menu, menu);
        return true; //true를 반환하면 메뉴가 나타난다.
    }

    public boolean onOptionsItemSelected(MenuItem item){
        int itemId = item.getItemId();
        switch (itemId){
            case R.id.top_rated:
                Toast.makeText(this, "TOP RATED", Toast.LENGTH_LONG).show();
                mMovieList.clear();
                parseJSON(MovieAPI.queryUrl(R.id.top_rated));
                movieAdapter.notifyDataSetChanged();
                return true;
            case R.id.popular:
                Toast.makeText(this, "POPULAR", Toast.LENGTH_LONG).show();
                mMovieList.clear();
                parseJSON(MovieAPI.queryUrl(R.id.popular));
                movieAdapter.notifyDataSetChanged();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


    private void parseJSON(String url){

        final String BASE_URL = "http://image.tmdb.org/t/p/";
        final String IMAGE_SIZE ="w185";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray = response.getJSONArray("results");
                            for(int i =0; i < jsonArray.length(); i++){
                                JSONObject result = jsonArray.getJSONObject(i);

                                String MovieName = result.getString("title");
                                String imageUrl = BASE_URL + IMAGE_SIZE + result.getString("poster_path");
                                String synopsis = result.getString("overview");
                                String voteAverage = result.getString("vote_average");
                                String releaseDate = result.getString("release_date");
                                String popularity = result.getString("popularity");

                                mMovieList.add(new MovieItem(imageUrl, MovieName, synopsis, releaseDate , voteAverage, popularity));
                            }

                        }catch (JSONException e){
                            e.printStackTrace();
                        }
                        movieAdapter = new MovieAdapter(MainActivity.this, mMovieList);
                        mRecyclerView.setAdapter(movieAdapter);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        mRequestQueue.add(request);
    }


}
