package com.kayzek.whatsapp;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class pageadapter extends FragmentPagerAdapter {

    private int numOfTabs;
    pageadapter(FragmentManager fm, int numOfTabs) {
        super(fm);
        this.numOfTabs = numOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new llamadas();
            case 1:
                return new chats();
            case 2:
                return new contactos();
            default:
                return null;
        }
    }


    @Override
    public int getCount() {
        return numOfTabs;
    }
}

