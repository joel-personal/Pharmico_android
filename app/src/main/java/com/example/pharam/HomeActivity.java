package com.example.pharam;

import android.os.Bundle;
import android.widget.FrameLayout;

import com.example.pharam.fragment.ChatFragment;
import com.example.pharam.fragment.HomeFragment;
import com.example.pharam.fragment.ListFragment;
import com.example.pharam.fragment.NotificationFragment;
import com.example.pharam.fragment.OrderFragment;
import com.example.pharam.fragment.SearchFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.pharam.databinding.ActivityHomeBinding;

public class HomeActivity extends AppCompatActivity {

    BottomNavigationView navView;
    Fragment searchFragment, listFragment, homeFragment, orderFragment, chatFragment, notiFragment, active;
    FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        navView = findViewById(R.id.nav_view);
        frameLayout = findViewById(R.id.home_frame);

        searchFragment = new SearchFragment();
        listFragment = new ListFragment();
        homeFragment = new HomeFragment();
        orderFragment = new OrderFragment();
        chatFragment = new ChatFragment();
        notiFragment = new NotificationFragment();
        active = homeFragment;

    }

}