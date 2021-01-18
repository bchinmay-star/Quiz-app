package com.example.helloworld.quiztruefalseapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.helloworld.quiztruefalseapp.controller.CardStackAdapter;
import com.example.helloworldappgaurav.quiz.VolleySingleton;
import com.yuyakaido.android.cardstackview.CardStackLayoutManager;
import com.yuyakaido.android.cardstackview.CardStackView;

import org.json.JSONObject;

import java.util.ArrayList;

import javax.xml.transform.ErrorListener;

public class MainActivity extends AppCompatActivity {

    private RequestQueue mRequestQueue;
    private String url;
    private CardStackView mCardStackView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCardStackView=findViewById(R.id.myCardStackView);
        mCardStackView.setLayoutManager(new CardStackLayoutManager(this));

        ArrayList<String> testFilms=new ArrayList<>();
        testFilms.add("Matrix");
        testFilms.add("On Golden pond");
        testFilms.add("At close range");
        testFilms.add("The pledge");
        testFilms.add("Basketball diaries");

        mCardStackView.setAdapter(new CardStackAdapter(this, testFilms));

        mRequestQueue= VolleySingleton.getInstance().getRequestQueue();
        url="https://opentdb.com/api.php?amount=10&category=23&difficulty=medium&type=boolean";
        JsonObjectRequest filmJsonObjectRequest= new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.i("myTag", response+"");
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        mRequestQueue.add(filmJsonObjectRequest);
    }
}