package movie.hd.moviehubhd.activity;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.view.View;

import androidx.appcompat.widget.SearchView;
import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;

import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

import androidx.core.view.MenuItemCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.room.Room;

import android.view.Menu;

import movie.hd.moviehubhd.R;
import movie.hd.moviehubhd.database.FavDatabase;
import movie.hd.moviehubhd.fragment.ActionMovie;
import movie.hd.moviehubhd.fragment.AdventureMovie;
import movie.hd.moviehubhd.fragment.AnimationMovie;
import movie.hd.moviehubhd.fragment.ComedyMovie;
import movie.hd.moviehubhd.fragment.CrimeMovie;
import movie.hd.moviehubhd.fragment.HomeFragment;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    FragmentManager  fragmentManager = getSupportFragmentManager();
    public static FavDatabase favDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        favDatabase = Room.databaseBuilder(getApplicationContext(), FavDatabase.class, "myfavdb").allowMainThreadQueries().build();
        fragmentManager.beginTransaction().replace(R.id.mainContainerID,new HomeFragment()).commit();


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
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

        if(id == R.id.actionMID)
        {
            fragmentManager.beginTransaction().replace(R.id.mainContainerID,new ActionMovie()).commit();
        }
        else if(id == R.id.catagorisMID)
        {
            startActivity(new Intent(this,TabAct.class));
        }
        else if (id == R.id.advencherMID) {
            fragmentManager.beginTransaction().replace(R.id.mainContainerID,new AdventureMovie()).commit();

            // Handle the camera action
        } else if (id == R.id.animationMID) {
            fragmentManager.beginTransaction().replace(R.id.mainContainerID,new AnimationMovie()).commit();

        } else if (id == R.id.comedyMID) {
            fragmentManager.beginTransaction().replace(R.id.mainContainerID,new ComedyMovie()).commit();

        } else if (id == R.id.crimeMID) {
            fragmentManager.beginTransaction().replace(R.id.mainContainerID,new CrimeMovie()).commit();

        } else if (id == R.id.nav_share) {
            startActivity(new Intent(this,PlayerAct.class));

        } else if (id == R.id.nav_send) {
            startActivity(new Intent(this,FirebaseSetup.class));
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
