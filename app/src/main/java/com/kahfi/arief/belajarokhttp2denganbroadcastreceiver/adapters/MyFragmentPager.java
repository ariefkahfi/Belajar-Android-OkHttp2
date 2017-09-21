package com.kahfi.arief.belajarokhttp2denganbroadcastreceiver.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.kahfi.arief.belajarokhttp2denganbroadcastreceiver.fragments.FragmentDeleteDataUsers;
import com.kahfi.arief.belajarokhttp2denganbroadcastreceiver.fragments.FragmentFormDataUsers;
import com.kahfi.arief.belajarokhttp2denganbroadcastreceiver.fragments.FragmentListDataUsers;

/**
 * Created by arief on 21/09/17.
 */

public class MyFragmentPager extends FragmentPagerAdapter {

    public MyFragmentPager(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0 : return new FragmentFormDataUsers();
            case 1 : return new FragmentListDataUsers();
            case 2 : return new FragmentDeleteDataUsers();
            default: return  null;
        }
    }



    @Override
    public int getCount() {
        return 3;
    }
}
