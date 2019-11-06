package com.ics.qzaro;

import android.content.Context;
import android.os.Bundle;

import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.ui.AppBarConfiguration;

import com.google.android.material.navigation.NavigationView;
import com.ics.qzaro.ui.Home_Fragment;
import com.ics.qzaro.ui.Quiz_Fragment;
import com.ics.qzaro.ui.Wallet_Fragment;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    NavigationView navigationView;
    DrawerLayout drawer;

    private FragmentManager fragmentmanager;
    private FragmentTransaction fragmentTransaction;
    private Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ///Toolbar toolbar = findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        setUpNavigation();

        fragment = new Home_Fragment();
        fragmentmanager = getSupportFragmentManager();
        fragmentTransaction =fragmentmanager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_layout,fragment);
        fragmentTransaction.commit();

        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("font/Roboto-Regular.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));    }


    public void openDrawer() {
        unlockDrawer();
        drawer.openDrawer(GravityCompat.START);    }

    public void closeDrawer() {
        drawer.closeDrawers();
    }

    public void lockDrawer(){  drawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);  }

    public void unlockDrawer(){ drawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED); }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    private void setUpNavigation(){
            navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                    switch (menuItem.getItemId()){

                        case R.id.nav_home:

                            fragment = new Home_Fragment();
                            fragmentmanager = getSupportFragmentManager();
                            fragmentTransaction = fragmentmanager.beginTransaction();
                            fragmentTransaction.replace(R.id.fragment_layout,fragment);
                            fragmentTransaction.commit();
                            closeDrawer();
                            break;

                        case R.id.nav_quiz:
                            Call_QUIZ("Normal Quiz");
                            closeDrawer();
                            break;

                        case R.id.nav_zara:
                            Call_QUIZ("ZARA HATKE QUIZ");
                            closeDrawer();
                            break;

                        case R.id.nav_mlm:
                            closeDrawer();
                            break;

                        case R.id.nav_wallet:
                            fragment = new Wallet_Fragment();
                            fragmentmanager = getSupportFragmentManager();
                            fragmentTransaction = fragmentmanager.beginTransaction();
                            fragmentTransaction.replace(R.id.fragment_layout,fragment);
                            fragmentTransaction.addToBackStack("WALLET");
                            fragmentTransaction.commit();
                            closeDrawer();
                            break;

                        case R.id.nav_share:
                            closeDrawer();
                            break;

                    }

                    return true;
                }
            });
    }


    public void Call_QUIZ(String head){

        Bundle bn = new Bundle();

        fragment = new Quiz_Fragment();
        bn.putString("head",""+head);

        fragment.setArguments(bn);
        fragmentmanager = getSupportFragmentManager();
        fragmentTransaction = fragmentmanager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_layout,fragment);
        fragmentTransaction.addToBackStack("QUIZ");
        fragmentTransaction.commit();
        closeDrawer();
    }


}
