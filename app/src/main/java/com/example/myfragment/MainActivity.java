package com.example.myfragment;

import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.annotation.NonNull;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadFragment(new HomeFragment());
        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Fragment homeFragment = null;

        switch (menuItem.getItemId()){
            case R.id.navigation_dashboard:
                homeFragment =new DashboardFragment();
                break;
            case R.id.navigation_home:
                homeFragment =new HomeFragment();
                break;
            case R.id.navigation_profile:
                homeFragment =new ProfileFragment();
                break;
            case R.id.navigation_notifications:
                homeFragment =new NotificationFragment();
                break;
        }

        return loadFragment(homeFragment);
    }

    private boolean loadFragment(Fragment homeFragment) {
        if (homeFragment != null){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, homeFragment)
                    .commit();
            return true;
        }
        return false;
    }
}
