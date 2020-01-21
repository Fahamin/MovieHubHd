package movie.hd.moviehubhd.activity;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.MenuItemCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import movie.hd.moviehubhd.R;
import movie.hd.moviehubhd.fragment.ThrillerMovie;
import movie.hd.moviehubhd.fragment.WarMovie;
import movie.hd.moviehubhd.searchfile.FilterManager;
import movie.hd.moviehubhd.ui.main.SectionsPagerAdapter;


public class TabAct extends AppCompatActivity {


    public SearchView searchView;
    ViewPager viewPager;
    TabLayout tabs;
    SectionsPagerAdapter sectionsPagerAdapter;


    private static TabAct instance;
    private FilterManager filterManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);

        sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);
        tabs.setTabMode(tabs.MODE_SCROLLABLE);

        instance = this;
        filterManager = new FilterManager();

        FloatingActionButton fab = findViewById(R.id.fab);

        ActionBar actionBar = getSupportActionBar();

        if(actionBar != null)
        {
            actionBar.setDisplayShowHomeEnabled(true);
            actionBar.setHomeButtonEnabled(true);
        }

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public static FilterManager getFilterManager() {
        return instance.filterManager; // return the observable class
    }

   /* @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);

        MenuItem item = menu.findItem(R.id.serchID);
        SearchView searchview = new SearchView(this);
        SearchManager searchManager = (SearchManager) getSystemService(SEARCH_SERVICE);
        searchview.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));


        MenuItemCompat.setShowAsAction(item,
                MenuItemCompat.SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW |
                        MenuItemCompat.SHOW_AS_ACTION_IF_ROOM);
        MenuItemCompat.setActionView(item, searchview);
        searchview.setOnQueryTextListener(this);
        searchview.setIconifiedByDefault(false);

        return super.onCreateOptionsMenu(menu);
    }



    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {

        filterManager.setQuery(newText); // update the observable value
        return true;
    }*/
}