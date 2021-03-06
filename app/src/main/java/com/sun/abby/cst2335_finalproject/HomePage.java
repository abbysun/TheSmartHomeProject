package com.sun.abby.cst2335_finalproject;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import android.support.v7.app.AlertDialog;

/**
 * This is the main activity that connects all the mini apps together. It uses fragments to display each app.
 * This java class implements behaviours for the home_page.xml view
 * There are 3 apps in total, one made by each team member:
 * House setting app - Yun Luo
 * Living room app - Chase Thorne
 * Kitchen control app - Abby Sun
 * @author Abby
 */
public class HomePage extends AppCompatActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    /**
     * This method to initialize all the activities
     * @param savedInstanceState Bundle object
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
    }

    /**
     * This method to create a Menue toolbar
     * @param menu Menu object
     * @return true
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_home_page, menu);
        return true;
    }

    /**
     * This method to pass the menu item has been selected.
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.action_kitchen_help:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle(R.string.action_kitchen_help).setMessage(R.string.kitchen_help_msg)
                        .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener(){
                            public void onClick(DialogInterface dialog, int id){ }
                        });
                AlertDialog dialog = builder.create();
                dialog.show();
                break;
            case R.id.action_kitchen:
                Intent toKitchen = new Intent(this.getApplicationContext(), KitchenActivity.class);
                this.startActivity(toKitchen);
                break;
        }

        return true;
    }

    //placeHolderFragment is deleted from here

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        /**
         * To get fragment position
         * @param position
         * @return position of fragments
         */
        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return an object that extends from Fragment (in this case: KitchenFragment, LivingRoomFragment, HouseSettingFragment)
            switch (position) {
                case 0:
                    HouseSettingFragment houseSettingFragment = new HouseSettingFragment();
                    return houseSettingFragment;

                case 1:
                   LivingRoomFragment livingRoomFragment = new LivingRoomFragment();
                    return livingRoomFragment;

                case 2:
                    KitchenFragment kitchenFragment = new KitchenFragment();
                    return kitchenFragment;

                default:
                    return null;
            }
        }

        /**
         * To get the count of fragment
         * @return the number of fragment
         */
        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

        /**
         * This method to get the title of each fragment
         * @param position the position of each fragment
         * @return the 3 fragments' titles
         */
        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "House Setting";
                case 1:
                    return "Living Room";
                case 2:
                    return "Kitchen";
            }
            return null;
        }
    }
}
