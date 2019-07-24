package com.example.savageworldscompanionapp;


import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class CharacterCreationPagerAdpater extends FragmentStatePagerAdapter {

    public CharacterCreationPagerAdpater(FragmentManager fm) {
        super(fm);
    }

    Context mContext;


    @Override
    public Fragment getItem(int position) {
        switch(position) {
            case 0:
                return new CharacterCreationAttribute();
            case 1:
                return new CharacterCreationSkill();
            case 2:
                return new CharacterCreationHindrance();
        }
        return new CharacterCreationAttribute();
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch(position) {
            case 0:
                return "Attributes";
            case 1:
                return "Skills";
            case 2:
                return "Hindrances";
            default:
                return "Invalid tab";
        }
    }



}
