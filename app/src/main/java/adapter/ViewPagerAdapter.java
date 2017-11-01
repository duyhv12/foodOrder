package adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by duy dev on 10/16/2017.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private Fragment []fragments;
    private Context context;
    public ViewPagerAdapter(FragmentManager fm, Context context, Fragment []fragments) {
        super(fm);
        this.fragments = fragments;
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments[position];
    }

    @Override
    public int getCount() {
        return fragments.length;
    }
}
