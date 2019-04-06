package com.example.accountsample;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView menu_icon;
    DrawerLayout drawerLayout;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_layout);
        menu_icon = (ImageView) findViewById(R.id.open_menu);
        drawerLayout = (DrawerLayout) findViewById(R.id.menu_drawer);
        navigationView = (NavigationView) findViewById(R.id.menu_navigation);
        menu_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(Gravity.RIGHT);
            }
        });

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId())
                {
                    case R.id.signIn_mItem:
                        GoToSignIn();
                        break;
                    case R.id.activationCode_mItem:
                        GoToActivatinLayout();
                        break;
                    case R.id.logIn_mItem:
                        GoToLogIn();
                        break;
                    case R.id.signOut_mItem:
                        break;

                }
                return false;
            }
        });

    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(Gravity.RIGHT)) {
            drawerLayout.closeDrawer(Gravity.RIGHT);
        } else {
            super.onBackPressed();
        }
    }

    public  void  GoToSignIn()
    {
        Intent intent=new Intent(MainActivity.this,SignInLayout.class);
        startActivity(intent);
    }
    public  void  GoToLogIn()
    {
        Intent intent=new Intent(MainActivity.this,LogInLayout.class);
        startActivity(intent);
    }
    public  void  GoToActivatinLayout()
    {
        Intent intent=new Intent(MainActivity.this,ActivationCodeLayout.class);
        startActivity(intent);
    }




}
