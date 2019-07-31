package com.example.savageworldscompanionapp;


import android.app.Activity;
import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class CharacterCreationPagerAdpater extends FragmentStatePagerAdapter{
    Character character;

    private Context mContext;
    public CharacterCreationPagerAdpater(FragmentManager fm, Context nContext, Character character) {
        super(fm);
        mContext = nContext;
        this.character = character;
    }



    @Override
    public Fragment getItem(int position) {
        switch(position) {
            case 0:
                return new CharacterCreationAttribute(character);
            case 1:
                return new CharacterCreationSkill(character);
            case 2:
                return new CharacterCreationHindrance(character);
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
