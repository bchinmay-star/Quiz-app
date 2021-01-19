package com.example.helloworldappgaurav.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.helloworldappgaurav.quiz.R;
import com.example.helloworldappgaurav.quiz.controller.CardStackAdapter;
import com.example.helloworldappgaurav.quiz.VolleySingleton;
import com.yuyakaido.android.cardstackview.CardStackLayoutManager;
import com.yuyakaido.android.cardstackview.CardStackView;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import javax.xml.transform.ErrorListener;

import model.QuizManager;
import model.QuizQuestion;

public class MainActivity extends AppCompatActivity {

    private QuizManager mQuizManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mQuizManager = new QuizManager(this);
        mQuizManager.getQuizQuestions(this);
    }
}