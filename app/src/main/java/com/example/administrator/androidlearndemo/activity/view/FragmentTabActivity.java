package com.example.administrator.androidlearndemo.activity.view;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import com.example.administrator.androidlearndemo.R;
import com.example.administrator.androidlearndemo.fragment.OneFragment;

import java.util.ArrayList;

public class FragmentTabActivity extends FragmentActivity {

    private ViewPager viewPager;
    private String TAG = "===========";

    private ArrayList<Fragment> fragments = new ArrayList<>();

    private FragmentPagerAdapter adapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
        @Override
        public Fragment getItem(int position) {
            Log.e(TAG, "position: " + position);
            Fragment fragment = null;
            if (position >= fragments.size()) {
                fragment = OneFragment.getInterface(String.valueOf(position));
                fragments.add(fragment);
                Log.e(TAG, "getItem: " + OneFragment.getInterface(String.valueOf(position)));
            } else {
                fragment = fragments.get(position);
            }
            return fragment;
        }

        @Override
        public int getCount() {
            return 10;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return String.valueOf(position);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_tab);



        viewPager = findViewById(R.id.viewPage);

        viewPager.setAdapter(adapter);

    }

}
