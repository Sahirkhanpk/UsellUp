package com.example.usellup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.MenuItemCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.util.Util;
import com.example.usellup.adapter.ViewPagerAdapter;
import com.example.usellup.fragments.Stuff_HomeFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.view.View.VISIBLE;

public class MainActivity extends AppCompatActivity {



    @BindView(R.id.bottomNavigationView)
    BottomNavigationView bottomNavigationView;

    @BindView(R.id.tabLayout)
    TabLayout tabLayout;
    @BindView(R.id.view_pager)
    ViewPager viewPager;

    @BindView(R.id. title)
    TextView title;



    @BindView(R.id.idSearchView)
    SearchView idSearchView;

    private Fragment fragment;
    private FragmentManager fragmentManager;
    FragmentTransaction transaction;


    @BindView(R.id.close_img)
    ImageView close_img;

    @BindView(R.id.up_img)
    ImageView up_img;

    @BindView(R.id.down_img)
    ImageView down_img;



    Context context;
    Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);



        Toolbar toolbar = findViewById(R.id.toolbar);


        setSupportActionBar(toolbar);
//
        context =MainActivity.this;
        activity = MainActivity.this;



        fragmentManager = getSupportFragmentManager();
        transaction = fragmentManager.beginTransaction();
        fragment = new Stuff_HomeFragment();
        transaction = fragmentManager.beginTransaction();




        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new Stuff_HomeFragment(), getString(R.string.head0));
        adapter.addFragment(new Stuff_HomeFragment(), getString(R.string.head1));
        adapter.addFragment(new Stuff_HomeFragment(), getString(R.string.head2));
        adapter.addFragment(new Stuff_HomeFragment(), getString(R.string.head3));

        viewPager.setAdapter(adapter);
        //set ViewPager
        tabLayout.setupWithViewPager(viewPager);
        changeTabsFont();
        viewPager.setOffscreenPageLimit(4);




        idSearchView. setOnQueryTextFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    // searchView expanded
                    bottomNavigationView.setVisibility(View.GONE);
                    up_img.setVisibility(VISIBLE);
                    down_img.setVisibility(VISIBLE);
                    close_img.setVisibility(VISIBLE);
                    title.setVisibility(View.GONE);
                } else {
                    // searchView not expanded
                    up_img.setVisibility(View.GONE);
                    down_img.setVisibility(View.GONE);
                    bottomNavigationView.setVisibility(VISIBLE);
                    close_img.setVisibility(View.GONE);
                    title.setVisibility(VISIBLE);
                }
            }
        });




        idSearchView.setOnSearchClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //do what you want when search view expended
                bottomNavigationView.setVisibility(View.GONE);
                up_img.setVisibility(VISIBLE);
                down_img.setVisibility(VISIBLE);
                close_img.setVisibility(VISIBLE);
                title.setVisibility(View.GONE);
            }
        });
        idSearchView.setOnCloseListener(new SearchView.OnCloseListener() {
            @Override
            public boolean onClose() {
                //do what you want  searchview is not expanded
                up_img.setVisibility(View.GONE);
                down_img.setVisibility(View.GONE);
                bottomNavigationView.setVisibility(VISIBLE);
                close_img.setVisibility(View.GONE);
                title.setVisibility(VISIBLE);
                return false;
            }
        });



        close_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                idSearchView.clearFocus();
            }
        });


        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.mi_account:
                        idSearchView.onActionViewExpanded();
                        idSearchView.performClick();
                        idSearchView.requestFocus();


                        break;

                    case R.id.mi_home:


                        fragment = new Stuff_HomeFragment();
                        transaction = fragmentManager.beginTransaction();

                        break;




                }


                return true;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.home, menu);
        MenuItem searchViewItem = menu.findItem(R.id.action_search);
        final SearchView searchViewAndroidActionBar = (SearchView) MenuItemCompat.getActionView(searchViewItem);
        searchViewAndroidActionBar.setQueryHint("Type here");
        searchViewAndroidActionBar.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                searchViewAndroidActionBar.clearFocus();
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.action_search: {
               MainActivity.this.startActivity(new Intent(MainActivity.this, MainActivity.class));

                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }



    private void changeTabsFont() {
        ViewGroup vg = (ViewGroup) tabLayout.getChildAt(0);
        int tabsCount = vg.getChildCount();
        for (int j = 0; j < tabsCount; j++) {
            ViewGroup vgTab = (ViewGroup) vg.getChildAt(j);
            int tabChildsCount = vgTab.getChildCount();
            for (int i = 0; i < tabChildsCount; i++) {
                View tabViewChild = vgTab.getChildAt(i);
                if (tabViewChild instanceof TextView) {
                    Typeface custom_font = ResourcesCompat.getFont(getApplicationContext(), R.font.nunito_semi_bold);
                    ((TextView) tabViewChild).setTypeface(custom_font);
                }
            }
        }
    }



    @Override
    public void onResume() {
        super.onResume();  // Always call the superclass method first

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new Stuff_HomeFragment(), getString(R.string.head0));
        adapter.addFragment(new Stuff_HomeFragment(), getString(R.string.head1));
        adapter.addFragment(new Stuff_HomeFragment(), getString(R.string.head2));
        adapter.addFragment(new Stuff_HomeFragment(), getString(R.string.head3));


        viewPager.setAdapter(adapter);

        //set ViewPager
        tabLayout.setupWithViewPager(viewPager);
        changeTabsFont();
        viewPager.setOffscreenPageLimit(4);
    }




}