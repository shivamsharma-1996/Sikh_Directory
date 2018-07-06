package sharmashivam.com.sikh_directory_dashboard;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DialogTitle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener
{
    private DrawerLayout drawer;
    View headerview;
    private RecyclerView recyclerView;
    RecyclerAdapter recyclerAdapter;

    List<String> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        headerview = navigationView.getHeaderView(0);
        TextView profilename =  headerview.findViewById(R.id.tv_profileName);
        TextView profileemail = headerview.findViewById(R.id.tv_profileEmail);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();


        list.add("jaipur");
        list.add("jodhpur");
        list.add("kota");
        list.add("karoli");
        list.add("ajmer");
        list.add("aagara");
        list.add("agartala");
        list.add("dosa");
        list.add("bhatinda");
        list.add("hissar");
        list.add("ganganagar");
        list.add("patna");
        list.add("alwar");
        list.add("panjab");
        list.add("delhi");
        list.add("us");

        initViews();
    }

    private void initViews()
    {
        recyclerAdapter = new RecyclerAdapter(this, list);

        recyclerView = findViewById(R.id.rv_item);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(recyclerAdapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.refresh_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        if (item.getItemId() == R.id.nav_refresh)
        {
            //do refresh
        }
        return true;
    }

    @Override
    protected void onStart()
    {
        super.onStart();
        LinearLayout header = headerview.findViewById(R.id.ll_header);
        header.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "clicked", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this, ProfileActivity.class));
                drawer.closeDrawer(GravityCompat.START);
            }
        });
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.nav_addMember:
                //startActivity(new Intent(MainActivity.this, AddMember.class));
                break;
            case R.id.nav_home:
                Toast.makeText(this, "nav_home", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_notification:
                Toast.makeText(this, "nav_notification", Toast.LENGTH_SHORT).show();
             //   startActivity(new Intent(MainActivity.this, AddMember.class));
                break;
            case R.id.nav_markedContact:
                Toast.makeText(this, "nav_markedContact", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_help:
                Toast.makeText(this, "nav_help", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_settings:
                Toast.makeText(this, "nav_settings", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_logout:
                Toast.makeText(this, "nav_logout", Toast.LENGTH_SHORT).show();
                break;

            case R.id.nav_share:
                Toast.makeText(this, "nav_share", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_feedback:
                Toast.makeText(this, "nav_feedback", Toast.LENGTH_SHORT).show();
                break;

        }


        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

}






















/*
<?xml version="1.0" encoding="utf-8"?>
<android.support.design.widget.CoordinatorLayout
        xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:app="http://schemas.android.com/apk/res-auto"
        xmlns:tools="http://schemas.android.com/tools"
        android:id="@+id/cl"
        android:layout_width="match_parent"
        android:layout_height="match_parent">


<android.support.design.widget.AppBarLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content">

<android.support.v7.widget.Toolbar
        android:id="@+id/toolbar"
        android:layout_width="match_parent"
        android:layout_height="?attr/actionBarSize"
        android:background="?attr/colorPrimary"
        android:theme="@style/ThemeOverlay.AppCompat.Dark.ActionBar"
        app:popupTheme="@style/Widget.AppCompat.PopupMenu"
        />

</android.support.design.widget.AppBarLayout>





<!--<android.support.v4.widget.DrawerLayout-->
<!--android:id="@+id/drawer_layout"-->
<!--android:layout_width="match_parent"-->
<!--android:layout_height="match_parent"-->
<!--android:fitsSystemWindows="true">-->

<!--<android.support.design.widget.NavigationView-->
<!--android:id="@+id/nav_view"-->
<!--android:layout_width="wrap_content"-->
<!--android:layout_height="match_parent"-->
<!--android:layout_gravity="start"-->
<!--app:headerLayout="@layout/nav_header"-->
<!--app:menu="@menu/drawer_menu" />-->

<!--</android.support.v4.widget.DrawerLayout>-->

</android.support.design.widget.CoordinatorLayout>
*/
