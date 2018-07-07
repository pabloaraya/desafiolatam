package org.pabloaraya.desafiolatam.Utilities;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import org.pabloaraya.desafiolatam.Fragments.FirstFragment;
import org.pabloaraya.desafiolatam.Fragments.SecondFragment;
import org.pabloaraya.desafiolatam.Fragments.ThirdFragment;
import org.pabloaraya.desafiolatam.MainActivity;

public class PageAdapter extends FragmentStatePagerAdapter {
    int tabNumber;

    public PageAdapter(FragmentManager fm, int tabs) {
        super(fm);
        this.tabNumber = tabs;
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
        return tabNumber;
    }
}
