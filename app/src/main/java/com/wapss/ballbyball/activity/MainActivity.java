package com.wapss.ballbyball.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;
import com.google.android.material.navigation.NavigationView;
import com.wapss.ballbyball.R;
import com.wapss.ballbyball.fragment.HomeFragment;
import com.wapss.ballbyball.fragment.MatcheFragment;
import com.wapss.ballbyball.fragment.NewsFragment;
import com.wapss.ballbyball.fragment.Profile_Fragment;

import de.hdodenhof.circleimageview.CircleImageView;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

public class MainActivity extends AppCompatActivity {
    TextView logout, txt_name, txt_email, edit_profile;
    CircleImageView image_profile;
    private MeowBottomNavigation nav_view1;
    ImageView tv_header_notification;

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Window window = getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(getWindow().getContext(), R.color.black));

        //this will make toolbar instead of action bar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolBar);
        tv_header_notification = toolbar.findViewById(R.id.tv_header_notification);
        //toolbar.setTitle("BallByBall");
        toolbar.setCollapseIcon(R.drawable.loginicon);
        toolbar.setTitleTextColor(R.color.black);
        setSupportActionBar(toolbar);

        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);

        View hView = navigationView.getHeaderView(0);
        logout = (TextView) hView.findViewById(R.id.logout);
        txt_name = (TextView) hView.findViewById(R.id.txt_name);
        txt_email = (TextView) hView.findViewById(R.id.txt_email);
        edit_profile = (TextView) hView.findViewById(R.id.edit_profile);
        image_profile = (CircleImageView) hView.findViewById(R.id.image_profile);

        // if user select item from the navigation view it will be detected here
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
//                switch (menuItem.getItemId()){
//                    case R.id.item1 : System.out.println("item 1 selected") ; break;
//                    case R.id.item2 : System.out.println("item 2 selected") ; break;
//                }
                int id = menuItem.getItemId();
                if (id == R.id.wallet) {
//                    Intent intent = new Intent(MainActivity.this, WalletsActivity.class);
//                    startActivity(intent);
                } else if (id == R.id.logOut) {
                   // callLogOut();
                }
                return true;
            }
        });

        // this is important part to add button in the toolbar
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_nav, R.string.close_nav);

        actionBarDrawerToggle.syncState();

        drawerLayout.setDrawerListener(actionBarDrawerToggle);

        //navigation
        nav_view1 = findViewById(R.id.nav_view1);
        nav_view1.add(new MeowBottomNavigation.Model(1, R.drawable.home));
        nav_view1.add(new MeowBottomNavigation.Model(2, R.drawable.matches));
        nav_view1.add(new MeowBottomNavigation.Model(3, R.drawable.news));
        nav_view1.add(new MeowBottomNavigation.Model(4, R.drawable.setting));

        nav_view1.show(1,true);
        replace(new HomeFragment());
        nav_view1.setOnClickMenuListener(new Function1<MeowBottomNavigation.Model, Unit>() {
            @Override
            public Unit invoke(MeowBottomNavigation.Model model) {
                switch (model.getId()){
                    case 1:
                        replace(new HomeFragment());
                        break;
                    case 2:
                        replace(new MatcheFragment());
                        break;
                    case 3:
                        replace(new NewsFragment());
                        break;
                    case 4:
                        replace(new Profile_Fragment());
                        break;
                }
                return null;
            }
        });

        tv_header_notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,NotificationActivity.class);
                startActivity(intent);
            }
        });
    }

    private void replace(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.main_container, fragment)
                .commit();
    }
}