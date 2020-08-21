package com.bvhloc.general.base.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import java.util.Arrays;
import java.util.List;

/**
 * Created by COVISOFT on 7/26/2017.
 */

public class BaseFragmentPagerAdapter extends FragmentPagerAdapter {

    private Fragment[] fragments;

    public BaseFragmentPagerAdapter(FragmentManager fragmentManager, Fragment... fragments) {
        super(fragmentManager);
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments[position];
    }

    @Override
    public int getCount() {
        return fragments.length;
    }

    public List<Fragment> getFragments() {
        return Arrays.asList(fragments);
    }

    public abstract static class OnPageSelectedListener implements ViewPager.OnPageChangeListener {

        @Override
        public void onPageScrolled(int i, float v, int i1) {

        }

        @Override
        public void onPageScrollStateChanged(int i) {

        }
    }
}
