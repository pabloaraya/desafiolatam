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

public class MainActivity extends AppCompatActivity implements CallbackPet, CallbackUser {

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

    final ViewPager viewPager = findViewById(R.id.viewPager);
    PageAdapter adapter =
        new PageAdapter(getSupportFragmentManager(), tabLayout.getTabCount(), this);
    viewPager.setAdapter(adapter);
    viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

    tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
      @Override
      public void onTabSelected(TabLayout.Tab tab) {
        int position = tab.getPosition();
        viewPager.setCurrentItem(position);
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

  private void showDialog(String answer){

    final AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
    alertDialog.setTitle("Hola AnimalLover");
    alertDialog.setMessage("Te gustan los " + answer);
    alertDialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
      @Override
      public void onClick(DialogInterface dialog, int which) {
        dialog.dismiss();
      }
    });
    alertDialog.show();

  }

  @Override public void savePet(String pet) {
    userModel.pet = pet;
    showDialog(pet);
  }

  @Override public void saveName(String name) {
    userModel.name = name;
  }

  @Override public void saveAge(int age) {
    userModel.age = age;
  }
}
