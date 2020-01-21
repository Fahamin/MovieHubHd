package movie.hd.moviehubhd.ui.main;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import movie.hd.moviehubhd.R;
import movie.hd.moviehubhd.fragment.ActionMovie;
import movie.hd.moviehubhd.fragment.AdventureMovie;
import movie.hd.moviehubhd.fragment.AnimationMovie;
import movie.hd.moviehubhd.fragment.ComedyMovie;
import movie.hd.moviehubhd.fragment.CrimeMovie;
import movie.hd.moviehubhd.fragment.HorrorMovie;
import movie.hd.moviehubhd.fragment.RomanceMovie;
import movie.hd.moviehubhd.fragment.SportMovie;
import movie.hd.moviehubhd.fragment.ThrillerMovie;
import movie.hd.moviehubhd.fragment.WarMovie;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.tab_text_1, R.string.tab_text_2,
            R.string.tab_text_3, R.string.tab_text_4,R.string.tab_text_5, R.string.tab_text_6
            ,R.string.tab_text_7, R.string.tab_text_8,R.string.tab_text_9,R.string.tab_text_10};
    private final Context mContext;

    public SectionsPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        if(position == 0)
        {
            return  new ActionMovie();
        }
        if(position == 1)
        {
            return  new AnimationMovie();
        }
        if(position == 2)
        {
            return  new HorrorMovie();
        }
        if(position == 3)
        {
            return  new RomanceMovie();
        }
        if(position == 4)
        {
            return  new AdventureMovie();
        }
        if(position == 5)
        {
            return  new WarMovie();
        }
        if(position == 6)
        {
            return  new ComedyMovie();
        }
        if(position == 7)
        {
            return  new ThrillerMovie();
        }
        if(position == 8)
        {
            return  new CrimeMovie();
        }
        if(position == 9)
        {
            return  new SportMovie();
        }
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
        return PlaceholderFragment.newInstance(position + 1);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TAB_TITLES[position]);
    }

    @Override
    public int getCount() {
        // Show 2 total pages.
        return 10;
    }
}