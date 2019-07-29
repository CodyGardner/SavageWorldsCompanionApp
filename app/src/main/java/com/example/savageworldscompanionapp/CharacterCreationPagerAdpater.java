package com.example.savageworldscompanionapp;


import android.app.Activity;
import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class CharacterCreationPagerAdpater extends FragmentStatePagerAdapter{

    private Context mContext;
    public CharacterCreationPagerAdpater(FragmentManager fm, Context nContext) {
        super(fm);
        mContext = nContext;
    }





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
                return mContext.getResources().getString(R.string.character_info);
            case 1:
                return mContext.getResources().getString(R.string.attributes);
            case 2:
                return mContext.getResources().getString(R.string.skills);
            default:
                return "Invalid tab";
        }
    }



}
