package com.example.death.walkrenger;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

public class mywalk extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mywalk);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            Intent gotogroup = new Intent(mywalk.this,Mainpage.class);
            startActivity(gotogroup);
            finish();
        } else if (id == R.id.nav_profile) {
            Intent gotogroup = new Intent(mywalk.this,profile.class);
            startActivity(gotogroup);
            finish();
        } else if (id == R.id.nav_group) {
            Intent gotogroup = new Intent(mywalk.this,group.class);
            startActivity(gotogroup);
            finish();
        } else if (id == R.id.nav_leaderboard) {
            Intent gotogroup = new Intent(mywalk.this,leaderboard.class);
            startActivity(gotogroup);
            finish();
        } else if (id == R.id.nav_mywalk) {
            startActivity(getIntent());
            finish();
        } else if (id == R.id.nav_goodplace) {
            Intent gotogroup = new Intent(mywalk.this,goodplace.class);
            startActivity(gotogroup);
            finish();
        } else if (id == R.id.nav_Challenge) {
            Intent gotogroup = new Intent(mywalk.this,challenge.class);
            startActivity(gotogroup);
            finish();
        } else if (id == R.id.nav_setting) {
            Intent gotogroup = new Intent(mywalk.this,setting.class);
            startActivity(gotogroup);
            finish();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
