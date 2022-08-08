package com.example.letngo;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class HomePage extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;

//declaration of everything nice
    ImageView imageView;
    ImageView imageView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        bottomNavigationView = findViewById(R.id.bottomNavView);

        replaceFragment(new FragmentExplore());
        bottomNavigationView.setSelectedItemId(R.id.fragmentExplore);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch (item.getItemId()) {
                        case R.id.fragment_GuestNewsfeed:
                            replaceFragment(new Fragment_GuestNewsfeed());
                            break;
                        case R.id.fragmentCategories2:
                            replaceFragment(new FragmentCategories());
                            break;
                        case R.id.fragmentExplore:
                            replaceFragment(new FragmentExplore());
                            break;
                        case R.id.fragment_GuestNotification:
                            replaceFragment(new Fragment_GuestNotification());
                            break;
                        case R.id.fragment_GuestAccount:
                            replaceFragment(new Fragment_GuestAccount());
                            break;
                    }
                    return true;
            }
        });

//        replaceFragment(new Fragment_home());
//        bottomNavigationView.setSelectedItemId(R.id.home);
//        bottomNavigationView.setOnNavigationItemReselectedListener();

        //Start of connection para ma click mo
        imageView = (ImageView) findViewById(R.id.imageMessage);
        imageView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v){

                show_login();
            }
        });
        //End of connection para ma click mo

//        imageView1 = (ImageView) findViewById(R.id.menuNewsfeed);
//        imageView1.setOnClickListener(new View.OnClickListener()
//        {
//            @Override
//            public void onClick(View v){
//
//                show_newsfeed();
//            }
//        });
    }

//    private void replaceFragment()
//    {
//        getSupportFragmentManager().beginTransaction().replace(R.id.menuNewsfeed, fragment).comit();
//    }

    //Method for message button
    public void show_login()
    {
        Intent intent = new Intent(this,new_login.class);
        startActivity(intent);
    }

    private void replaceFragment(Fragment fragment){
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentlayout,fragment).commit();
    }
}