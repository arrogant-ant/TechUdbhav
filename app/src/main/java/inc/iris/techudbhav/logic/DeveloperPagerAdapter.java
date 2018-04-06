package inc.iris.techudbhav.logic;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Sud on 4/7/18.
 */

public class DeveloperPagerAdapter extends FragmentPagerAdapter {

    private int noOfTabs;
    private Fragment tabs[];

    public DeveloperPagerAdapter(FragmentManager fm, int noOfTabs, Fragment tabs[]) {
        super(fm);
        this.noOfTabs=noOfTabs;
        this.tabs=tabs;
    }
    @Override
    public Fragment getItem(int position) {
        return tabs[position];
    }

    @Override
    public int getCount() {
        return noOfTabs;
    }
}
