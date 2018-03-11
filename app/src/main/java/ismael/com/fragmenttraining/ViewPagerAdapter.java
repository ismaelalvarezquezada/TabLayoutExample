package ismael.com.fragmenttraining;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by ismael on 04-03-18.
 */

public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    private int numberOfTabs;

    public ViewPagerAdapter(FragmentManager fm, int numberOfTabs ) {
        super(fm);
        this.numberOfTabs =numberOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position){
            case 0:
                return new FirstFragment();
            case 1:
                return new SecondFragment();
            case 2:
                return new ThirdFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numberOfTabs;
    }
}
