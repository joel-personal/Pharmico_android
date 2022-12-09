package com.example.pharam;

import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuInflater;
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

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.pharam.databinding.ActivityHomeBinding;

public class HomeActivity extends AppCompatActivity {

    BottomNavigationView navView;
    ImageView iv_menu;

    Fragment searchFragment, listFragment, homeFragment, orderFragment, chatFragment, notiFragment, active;
    FragmentManager fm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        navView = findViewById(R.id.nav_view);
        iv_menu = findViewById(R.id.iv_menu);

        searchFragment = new SearchFragment();
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

    public void showPopup(View v) {
        PopupMenu popup = new PopupMenu(this, v);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.side_menu, popup.getMenu());
        popup.show();
    }

    private void handleClickEvents() {
        iv_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopup(view);
            }
        });
    }

}