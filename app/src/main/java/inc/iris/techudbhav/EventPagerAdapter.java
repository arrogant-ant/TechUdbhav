package inc.iris.techudbhav;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Sud on 4/5/18.
 */

public class EventPagerAdapter extends FragmentPagerAdapter {

    private int noOfTabs;
    private Fragment tabs[];

    public EventPagerAdapter(FragmentManager fm, int noOfTabs, Fragment tabs[]) {
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
