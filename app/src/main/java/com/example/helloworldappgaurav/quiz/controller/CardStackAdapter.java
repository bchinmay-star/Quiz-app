package com.example.helloworld.quiztruefalseapp.controller;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.helloworld.quiztruefalseapp.R;
import com.example.helloworld.quiztruefalseapp.view.FilmViewHolder;

import java.util.List;

public class CardStackAdapter extends RecyclerView.Adapter<FilmViewHolder> {

    private Context mContext;
    private List<String> mFilmNames;
    private LayoutInflater mLayoutInflator;


    public CardStackAdapter(Context mContext, List<String> mFilmNames) {
        this.mContext = mContext;
        this.mFilmNames = mFilmNames;
        mLayoutInflator=LayoutInflater.from(mContext);
    }

    @NonNull
    @Override
    public FilmViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=mLayoutInflator.inflate(R.layout.film_view, parent, false);
        return new FilmViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FilmViewHolder holder, int position) {
        holder.getTxtFilmQuestion().setText(mFilmNames.get(position));
        holder.getImgButtonTrue().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "True is tapped", Toast.LENGTH_SHORT).show();
            }
        });

        holder.getImgButtonFalse().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "False is tapped", Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    public int getItemCount() {
        return mFilmNames.size();
    }
}
