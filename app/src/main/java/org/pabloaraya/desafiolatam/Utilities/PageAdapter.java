package org.pabloaraya.desafiolatam.Utilities;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import org.pabloaraya.desafiolatam.BlankFragment;
import org.pabloaraya.desafiolatam.CallbackPet;
import org.pabloaraya.desafiolatam.CallbackUser;
import org.pabloaraya.desafiolatam.Fragments.FirstFragment;
import org.pabloaraya.desafiolatam.Fragments.SecondFragment;
import org.pabloaraya.desafiolatam.Fragments.ThirdFragment;
import org.pabloaraya.desafiolatam.MainActivity;
import org.pabloaraya.desafiolatam.OnResult;
import org.pabloaraya.desafiolatam.Tab1Fragment;

public class PageAdapter extends FragmentStatePagerAdapter {
  private int tabNumber;
  private CallbackPet callbackPet;
  private CallbackUser callbackUser;
  private OnResult onResult;

  public PageAdapter(FragmentManager fm, int tabs, CallbackPet callbackPet,
      CallbackUser callbackUser, OnResult onResult) {
    super(fm);
    this.tabNumber = tabs;
    this.callbackPet = callbackPet;
    this.callbackUser = callbackUser;
    this.onResult = onResult;
  }

  @Override
  public Fragment getItem(int position) {
    switch (position) {
      case 0:
        Tab1Fragment tab1Fragment = new Tab1Fragment();
        tab1Fragment.setCallbackPet(callbackPet);
        return tab1Fragment;
      case 1:
        BlankFragment blankFragment = new BlankFragment();
        blankFragment.setCallbackUser(callbackUser);
        return blankFragment;
      case 2:
        ThirdFragment thirdFragment = new ThirdFragment();
        thirdFragment.setCallbackOnResult(onResult);
        return thirdFragment;
      default:
        return null;
    }
  }

  @Override
  public int getCount() {
    return tabNumber;
  }
}
