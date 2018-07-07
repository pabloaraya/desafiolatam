package org.pabloaraya.desafiolatam.Utilities;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import org.pabloaraya.desafiolatam.BlankFragment;
import org.pabloaraya.desafiolatam.CallbackPet;
import org.pabloaraya.desafiolatam.Fragments.FirstFragment;
import org.pabloaraya.desafiolatam.Fragments.SecondFragment;
import org.pabloaraya.desafiolatam.Fragments.ThirdFragment;
import org.pabloaraya.desafiolatam.MainActivity;
import org.pabloaraya.desafiolatam.Tab1Fragment;

public class PageAdapter extends FragmentStatePagerAdapter {
    private int tabNumber;
    private CallbackPet callbackPet;

    public PageAdapter(FragmentManager fm, int tabs, CallbackPet callbackPet) {
        super(fm);
        this.tabNumber = tabs;
        this.callbackPet = callbackPet;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                Tab1Fragment fragment = new Tab1Fragment();
                fragment.setCallbackPet(callbackPet);
                return fragment;
            case 1:
                return new BlankFragment();
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
