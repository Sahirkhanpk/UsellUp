package com.example.usellup.fragments;

import android.app.Activity;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.usellup.R;
import com.example.usellup.adapter.best_tiles_adapter;
import com.example.usellup.adapter.main_cat_adapter;
import com.example.usellup.adapter.top_shops_adapter;
import com.example.usellup.adapter.top_tiles_adapter;
import com.example.usellup.models.main_cat_model;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


public class Stuff_HomeFragment extends Fragment
{


    private Fragment fragment;
    private FragmentManager fragmentManager;
    FragmentTransaction transaction;



    String Keyword="";





    @BindView(R.id.rv_main_cat)
    RecyclerView rv_main_cat;

    @BindView(R.id.layout_today)
    RelativeLayout layoutToday;

    @BindView(R.id.layout_completed)
    RelativeLayout layoutCompleted;

    @BindView(R.id.layout_tomorrow)
    RelativeLayout layoutTomorrow;




    @BindView(R.id.rv_best_tiles)
    RecyclerView rv_best_tiles;



    @BindView(R.id.rv_top_tiles)
    RecyclerView rv_top_tiles;

    @BindView(R.id.rv_top_shops)
    RecyclerView rv_top_shops;


    @BindView(R.id.rv_best_tiles_two)
    RecyclerView rv_best_tiles_two;











    Context context;
    Activity activity;




    Unbinder unbinder;

    List<main_cat_model>  main_cat;

main_cat_adapter main_cat_Adapter;
    best_tiles_adapter Best_tiles_adapter,best_tiles_adapter_two;
    top_tiles_adapter Top_tiles_adapter;

    top_shops_adapter Top_shops_adapter;

    public Stuff_HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_stuff_home, container, false);
        unbinder = ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        context = getContext();
        activity = getActivity();
        main_cat= new ArrayList<>();
        main_cat_model main_cat_model1= new main_cat_model();
        main_cat_model1.setCattype("Main");
        main_cat_model1.setCatname("Garments");
        main_cat.add(main_cat_model1);
        main_cat_model main_cat_model2= new main_cat_model();
        main_cat_model2.setCattype("Main");
        main_cat_model2.setCatname("Perfumes");
        main_cat.add(main_cat_model2);
        main_cat_model main_cat_model3= new main_cat_model();
        main_cat_model3.setCattype("Sub");
        main_cat_model3.setCatname("jeanez");
        main_cat.add(main_cat_model3);

        main_cat_model main_cat_model4= new main_cat_model();
        main_cat_model4.setCattype("Main");
        main_cat_model4.setCatname("food");
        main_cat.add(main_cat_model4);

        main_cat_model main_cat_model5= new main_cat_model();
        main_cat_model5.setCattype("Sub");
        main_cat_model5.setCatname("gril Cheken");
        main_cat.add(main_cat_model5);

        main_cat_model main_cat_model6= new main_cat_model();
        main_cat_model6.setCattype("Sub");
        main_cat_model6.setCatname("franch perfume");
        main_cat.add(main_cat_model6);


        main_cat_model main_cat_model7= new main_cat_model();
        main_cat_model7.setCattype("Sub");
        main_cat_model7.setCatname("Arabic perfume");
        main_cat.add(main_cat_model7);

        main_cat_model main_cat_model8= new main_cat_model();
        main_cat_model8.setCattype("Main");
        main_cat_model8.setCatname("Sports");
        main_cat.add(main_cat_model8);
        main_cat_model main_cat_model9= new main_cat_model();
        main_cat_model9.setCattype("sub");
        main_cat_model9.setCatname("Sports crikit");
        main_cat.add(main_cat_model9);
        main_cat_Adapter= new main_cat_adapter(main_cat,context,false);

        rv_main_cat.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));
        // tomorrow_task_rv.setLayoutManager(mLayoutManager);
        rv_main_cat.setItemAnimator(new DefaultItemAnimator());
        rv_main_cat.setAdapter(main_cat_Adapter);

        //  createNotificationChannel();
 Best_tiles_adapter = new best_tiles_adapter(main_cat,context,false);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(context,3, GridLayoutManager.VERTICAL,false);
rv_best_tiles.setLayoutManager(gridLayoutManager);
        rv_best_tiles.setItemAnimator(new DefaultItemAnimator());
        rv_best_tiles.setAdapter(Best_tiles_adapter);


        Top_tiles_adapter= new top_tiles_adapter(main_cat,context,false);


        rv_top_tiles.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));

        rv_top_tiles.setItemAnimator(new DefaultItemAnimator());
        rv_top_tiles.setAdapter(Top_tiles_adapter);



        Top_shops_adapter= new top_shops_adapter(main_cat,context,false);


        rv_top_shops.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));

        rv_top_shops.setItemAnimator(new DefaultItemAnimator());
        rv_top_shops.setAdapter(Top_shops_adapter);




       best_tiles_adapter_two = new best_tiles_adapter(main_cat,context,false);

        rv_best_tiles_two.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));
        rv_best_tiles_two.setItemAnimator(new DefaultItemAnimator());
        rv_best_tiles_two.setAdapter(best_tiles_adapter_two);





    }



    @Override
    public void onResume() {
        super.onResume();
      //  getAlltasks();


    }























}


