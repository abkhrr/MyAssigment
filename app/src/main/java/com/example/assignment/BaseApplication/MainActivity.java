package com.example.assignment.BaseApplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.assignment.LoginAndRegisterActivity;
import com.example.assignment.R;
import com.example.assignment.fragments.ApprovalsFragment;
import com.example.assignment.fragments.FeedsFragment;
import com.example.assignment.fragments.HomeFragment;
import com.example.assignment.fragments.MoreFragment;
import com.example.assignment.fragments.ServicesFragment;
import com.example.assignment.logAndReg.LoginActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import de.hdodenhof.circleimageview.CircleImageView;

import static com.example.assignment.logAndReg.LoginActivity.TAG_ID;
import static com.example.assignment.logAndReg.LoginActivity.TAG_USERNAME;
import static com.example.assignment.logAndReg.LoginActivity.id;
import static com.example.assignment.logAndReg.LoginActivity.session;
import static com.example.assignment.logAndReg.LoginActivity.username;

public class MainActivity extends AppCompatActivity {

    private CircleImageView circleImageView;

    SharedPreferences sharedpreferences;
    public static String id, username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        circleImageView = (CircleImageView) findViewById(R.id.imgView1);

        sharedpreferences = getSharedPreferences(LoginActivity.my_shared_preferences, Context.MODE_PRIVATE);


        username = sharedpreferences.getString(TAG_USERNAME, "username");


        BottomNavigationView bottomNav = findViewById(R.id.navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);
        bottomNav.setItemIconTintList(null);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                new ServicesFragment()).commit();
    }

    BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener()
    {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuitem)
        {
            Fragment selectedFragment = null;
            switch (menuitem.getItemId())
            {
                case R.id.services:
                    selectedFragment = new ServicesFragment();
                    break;
                case R.id.home:
                    selectedFragment = new HomeFragment();
                    break;
                case R.id.feeds:
                    selectedFragment = new FeedsFragment();
                    break;
                case R.id.approvals:
                    selectedFragment = new ApprovalsFragment();
                    break;
                case R.id.more:
                    selectedFragment = new MoreFragment();
                    break;
            }
            assert selectedFragment != null;
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    selectedFragment).commit();
            return true;
        }
    };
}
