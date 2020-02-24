package com.phoenixapps.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.phoenixapps.fragments.Fragments.HomeFragment;
import com.phoenixapps.fragments.Fragments.SearchFragment;

public class MainActivity extends AppCompatActivity {
    private Fragment mHomeFragment;
    private Fragment mSearchFragment;

    private BottomNavigationView mBottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialize();
    }

    private void initialize() {
        mHomeFragment = new HomeFragment();
        mSearchFragment = new SearchFragment();

        mBottomNavigationView = findViewById(R.id.bnv);
        mBottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                changeFragment(
                        menuItem.getItemId() == R.id.home
                            ? mHomeFragment
                            : mSearchFragment
                );
                return true;
            }
        });

        changeFragment(mHomeFragment);
    }

    private void onBottomNavigationClick() {

    }

    private void changeFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, fragment)
                .commit();
    }
}
