package com.example.usellup.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.usellup.R;
import com.example.usellup.models.main_cat_model;

import java.util.HashMap;
import java.util.List;

public class main_cat_adapter extends RecyclerView.Adapter<com.example.usellup.adapter.main_cat_adapter.MyViewHolder> {



    private List<main_cat_model> list;
    private Context context;
    private boolean isNewTask;

    public main_cat_adapter(List<main_cat_model> list, Context con, boolean isNewTask) {
        this.list = list;

        this.context = con;
        this.isNewTask = isNewTask;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_main_cat, parent, false);
        return new MyViewHolder(itemView);
    }





    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        final main_cat_model obj = list.get(position);


        if(obj.getCatname()!=null)
            holder.cat_name.setText(obj.getCatname().toString());
        if(obj.getCattype()!=null)
            holder.cat_type.setText(obj.getCattype());









    }





    @Override
    public int getItemCount() {
        return list.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private CardView taskCard;
        private TextView cat_type,cat_name;
        private ImageView shopAvatar;

        private MyViewHolder(View view) {
            super(view);
            taskCard = view.findViewById(R.id.task_card);
            cat_type = view.findViewById(R.id.tv_cat_type);
            cat_name = view.findViewById(R.id.tv_cat_name);


            taskCard.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();

        }

    }






}
