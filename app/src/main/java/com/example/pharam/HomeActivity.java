package com.example.pharam;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.example.pharam.fragment.ChatFragment;
import com.example.pharam.fragment.HomeFragment;
import com.example.pharam.fragment.ListFragment;
import com.example.pharam.fragment.NotificationFragment;
import com.example.pharam.fragment.OrderFragment;
import com.example.pharam.fragment.SearchFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationBarView;

public class HomeActivity extends AppCompatActivity {

    BottomNavigationView navView;
    ImageView iv_menu, iv_profile;

    Fragment searchFragment, listFragment, homeFragment, orderFragment, chatFragment, notiFragment, active;
    FragmentManager fm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        navView = findViewById(R.id.nav_view);
        iv_menu = findViewById(R.id.iv_menu);
        iv_profile = findViewById(R.id.iv_profile);

        navView.setOnItemSelectedListener(onItemSelectedListener);

        searchFragment = new SearchFragment(); //not using, check search activity
        listFragment = new ListFragment();
        homeFragment = new HomeFragment();
        orderFragment = new OrderFragment();
        chatFragment = new ChatFragment();
        notiFragment = new NotificationFragment();
        active = homeFragment;
        fm = getSupportFragmentManager();
        fm.beginTransaction().add(R.id.home_frame, listFragment, "2").hide(listFragment).commit();
//        fm.beginTransaction().add(R.id.home_frame, searchFragment, "3").hide(searchFragment).commit();
        fm.beginTransaction().add(R.id.home_frame, orderFragment, "3").hide(orderFragment).commit();
        fm.beginTransaction().add(R.id.home_frame, chatFragment, "4").hide(chatFragment).commit();
        fm.beginTransaction().add(R.id.home_frame, notiFragment, "5").hide(notiFragment).commit();
        fm.beginTransaction().add(R.id.home_frame, homeFragment, "1").commit();


        handleClickEvents();


    }

    private NavigationBarView.OnItemSelectedListener  onItemSelectedListener = new NavigationBarView.OnItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.n_home:
                    fm.beginTransaction().hide(listFragment).commit();
                    fm.beginTransaction().hide(orderFragment).commit();
                    fm.beginTransaction().hide(chatFragment).commit();
                    fm.beginTransaction().hide(notiFragment).commit();
                    fm.beginTransaction().hide(active).show(homeFragment).commit();
                    active = homeFragment;
                    return true;
                case R.id.n_list:
                    fm.beginTransaction().hide(homeFragment).commit();
                    fm.beginTransaction().hide(orderFragment).commit();
                    fm.beginTransaction().hide(chatFragment).commit();
                    fm.beginTransaction().hide(notiFragment).commit();
                    fm.beginTransaction().hide(active).show(listFragment).commit();
                    active = listFragment;
                    return true;
                case R.id.n_order:
                    fm.beginTransaction().hide(homeFragment).commit();
                    fm.beginTransaction().hide(listFragment).commit();
                    fm.beginTransaction().hide(chatFragment).commit();
                    fm.beginTransaction().hide(notiFragment).commit();
                    fm.beginTransaction().hide(active).show(orderFragment).commit();
                    active = orderFragment;
                    return true;
                case R.id.n_chat:
                    fm.beginTransaction().hide(homeFragment).commit();
                    fm.beginTransaction().hide(listFragment).commit();
                    fm.beginTransaction().hide(orderFragment).commit();
                    fm.beginTransaction().hide(notiFragment).commit();
                    fm.beginTransaction().hide(active).show(chatFragment).commit();
                    active = chatFragment;
                    return true;
                case R.id.n_notification:
                    fm.beginTransaction().hide(homeFragment).commit();
                    fm.beginTransaction().hide(listFragment).commit();
                    fm.beginTransaction().hide(orderFragment).commit();
                    fm.beginTransaction().hide(chatFragment).commit();
                    fm.beginTransaction().hide(active).show(notiFragment).commit();
                    active = notiFragment;
                    return true;
            }
            return false;
        }
    };

    public void showPopup(View v) {
        PopupMenu popup = new PopupMenu(this, v);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.side_menu, popup.getMenu());
        popup.show();
        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.m_search:
                        startActivity(new Intent(HomeActivity.this, SearchActivity.class));
                        return true;
                    default:
                        return false;
                }
            }
        });
    }

    private void handleClickEvents() {
        iv_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopup(view);
            }
        });
        iv_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, ProfileActivity.class));
            }
        });
    }

}