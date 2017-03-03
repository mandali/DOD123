package com.omniwyse.dod.ui;

import android.support.design.widget.TabLayout;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;

import com.omniwyse.dod.R;
import com.omniwyse.dod.fragement.BeaconsFragment;
import com.omniwyse.dod.fragement.BrandFragment;
import com.omniwyse.dod.fragement.DiscountFragment;
import com.omniwyse.dod.fragement.LiveFragment;
import com.omniwyse.dod.fragement.StoresFragment;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
//
//        toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//        toolbar.setContentInsetStartWithNavigation(R.drawable.app_logo);

//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

//        toolbar = (Toolbar) findViewById(R.id.my_toolbar);
//        setSupportActionBar(toolbar);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new LiveFragment(), "Live");
        adapter.addFragment(new DiscountFragment(), "Brands");
        adapter.addFragment(new StoresFragment(), "Stores");
        adapter.addFragment(new BeaconsFragment(), "Beacons");
        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            if(title.equals("Live")){
                mFragmentList.add(new LiveFragment());
            }else if(title.equals("Brands")){
                mFragmentList.add(new BrandFragment());
            }else if(title.equals("Stores")){
                mFragmentList.add(new StoresFragment());
            }else if(title.equals("Beacons")){
                mFragmentList.add(new BeaconsFragment());
            }
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.home_menu, menu);

        return true;
    }

}