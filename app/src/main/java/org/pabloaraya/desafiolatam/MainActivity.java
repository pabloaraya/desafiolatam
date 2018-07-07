package org.pabloaraya.desafiolatam;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

import org.pabloaraya.desafiolatam.Utilities.PageAdapter;

public class MainActivity extends AppCompatActivity implements CallbackPet, CallbackUser, OnResult {

  private ViewPager mViewPager;
  private UserModel userModel;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    userModel = new UserModel();

    TabLayout tabLayout = findViewById(R.id.tabsLayout);

    tabLayout.addTab(tabLayout.newTab().setText("Primero"));
    tabLayout.addTab(tabLayout.newTab().setText("Segundo"));
    tabLayout.addTab(tabLayout.newTab().setText("Tercero"));
    tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

    mViewPager = findViewById(R.id.viewPager);
    PageAdapter adapter =
        new PageAdapter(getSupportFragmentManager(), tabLayout.getTabCount(), this, this, this);
    mViewPager.setAdapter(adapter);
    mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

    tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
      @Override
      public void onTabSelected(TabLayout.Tab tab) {
        int position = tab.getPosition();
        mViewPager.setCurrentItem(position);
      }

      @Override
      public void onTabUnselected(TabLayout.Tab tab) {
        //Something
      }

      @Override
      public void onTabReselected(TabLayout.Tab tab) {
        //Something
      }
    });
  }

  @Override public void savePet(String pet) {
    userModel.pet = pet;
    mViewPager.setCurrentItem(1, true);
  }

  @Override public void saveName(String name) {
    userModel.name = name;
  }

  @Override public void saveAge(String age) {
    userModel.age = age;
    mViewPager.setCurrentItem(2, true);
  }

  @Override public void showResult() {

    if (userModel.pet != null && userModel.name != null && userModel.age != null) {
      final AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
      alertDialog.setTitle("Hola " + userModel.name);
      alertDialog.setMessage(
          "Tienes entre " + userModel.age + " años y te gustan los " + userModel.pet);
      alertDialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
          dialog.dismiss();
        }
      });
      alertDialog.show();
    }
  }
}
