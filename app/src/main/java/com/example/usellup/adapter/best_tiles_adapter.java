package com.example.usellup.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.usellup.R;
import com.example.usellup.models.main_cat_model;

import java.util.List;

public class best_tiles_adapter extends RecyclerView.Adapter<com.example.usellup.adapter.best_tiles_adapter.MyViewHolder> {



    private List<main_cat_model> list;
    private Context context;
    private boolean isNewTask;

    public best_tiles_adapter(List<main_cat_model> list, Context con, boolean isNewTask) {
        this.list = list;

        this.context = con;
        this.isNewTask = isNewTask;

    }

    @Override
    public best_tiles_adapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_best_tile, parent, false);
        return new best_tiles_adapter.MyViewHolder(itemView);
    }





    @Override
    public void onBindViewHolder(final best_tiles_adapter.MyViewHolder holder, final int position) {
        final main_cat_model obj = list.get(position);


      /*  if(obj.getCatname()!=null)
            holder.cat_name.setText(obj.getCatname().toString());
        if(obj.getCattype()!=null)
            holder.cat_type.setText(obj.getCattype());*/


        if(position%2==0){
            holder.img.setBackgroundResource(R.drawable.shopping);
        }else {
            holder.img.setBackgroundResource(R.drawable.family);
        }






    }





    @Override
    public int getItemCount() {
        return list.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private CardView taskCard;
        private TextView cat_type,cat_name;
        private ImageView img;

        private MyViewHolder(View view) {
            super(view);
            taskCard = view.findViewById(R.id.task_card);
            cat_type = view.findViewById(R.id.tv_cat_type);
            cat_name = view.findViewById(R.id.tv_cat_name);
            img=(ImageView) view.findViewById(R.id.img);


            taskCard.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();

        }

    }






}

