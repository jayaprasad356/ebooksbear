package com.gm.ebooksbear;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;

import com.gm.ebooksbear.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class HomePageActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    BottomNavigationView bottomNavigationView;

    public static Fragment homeFragment,booksFragment,personFragment,rackFragment;

    public static FragmentManager fm = null;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        bottomNavigationView = findViewById(R.id.bottomNavigationView);

        homeFragment = new HomeFragment();
        booksFragment = new BooksFragment();
         personFragment = new PersonFragment();
        rackFragment = new RackFragment();
        fm = getSupportFragmentManager();
        bottomNavigationView.setSelectedItemId(R.id.home);
        bottomNavigationView.setOnItemSelectedListener(this);
        getSupportFragmentManager().beginTransaction().replace(R.id.container,homeFragment).commit();


    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.home:
                getSupportFragmentManager().beginTransaction().replace(R.id.container, homeFragment).commit();
                return true;

            case R.id.rack:
                getSupportFragmentManager().beginTransaction().replace(R.id.container, rackFragment).commit();
                return true;

            case R.id.books:
                getSupportFragmentManager().beginTransaction().replace(R.id.container, booksFragment).commit();
                return true;


            case R.id.human:
                getSupportFragmentManager().beginTransaction().replace(R.id.container, personFragment).commit();
                return true;
        }
        return false;
    }
}