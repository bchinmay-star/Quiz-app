package com.example.helloworldappgaurav.quiz.controller;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.helloworldappgaurav.quiz.R;
import com.example.helloworldappgaurav.quiz.view.FilmViewHolder;

import java.util.List;

import model.QuizQuestion;

public class CardStackAdapter extends RecyclerView.Adapter<FilmViewHolder> {

    private Context mContext;
    private List<QuizQuestion> mFilmQuestions;
    private LayoutInflater mLayoutInflator;


    public CardStackAdapter(Context context, List<QuizQuestion> filmQuestions) {
        mContext = context;
        mFilmQuestions = filmQuestions;
        mLayoutInflator = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public FilmViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mLayoutInflator.inflate(R.layout.film_view, parent, false);
        return new FilmViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FilmViewHolder holder, int position) {
        holder.getTxtFilmQuestion().setText(mFilmQuestions.get(position).getQuestionText());
        holder.getImgButtonTrue().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mFilmQuestions.get(position).isTrueAnswer()){
                    Toast.makeText(mContext, "Congratulations! You have correctly answered the question.", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(mContext, "Sorry, your answer is incorrect.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        holder.getImgButtonFalse().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mFilmQuestions.get(position).isTrueAnswer()){
                    Toast.makeText(mContext, "Sorry, your answer is incorrect. Try again!", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(mContext, "Congratulations! You have correctly answered the question.", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

    @Override
    public int getItemCount() {
        return mFilmQuestions.size();
    }
}
