package com.example.myapplication;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    BottomNavigationView navigationView;
    Contact contact;
    Contact2 contact2;
    public void getFragment(Fragment fragment) {
        try {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, fragment)
                    .commit();
        } catch (Exception e) {
            e.printStackTrace();
            Log.d(TAG, "getFragment: " + e.getMessage());
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTitle("Messager");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navigationView = findViewById(R.id.nav);
        contact = new Contact("Mr A");
        contact2 = new Contact2("MrA:","helloooo!!!");

        getFragment(Home_Fragment.newInstance(contact));
        getFragment(MessFragment.newInstance2(contact2));

        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.friends:
                        getFragment(Home_Fragment.newInstance(contact));
                        break;
                    case R.id.messagers:
                        getFragment(MessFragment.newInstance2(contact2));
                        break;
                }

                return false;
            }
        });
    }

}
