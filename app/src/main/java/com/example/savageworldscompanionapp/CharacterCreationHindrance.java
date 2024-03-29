package com.example.savageworldscompanionapp;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import java.util.ArrayList;


/*
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link CharacterCreationHindrance.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link CharacterCreationHindrance#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CharacterCreationHindrance extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private Character character;

    static ArrayList<Skill> skills;
    ArrayList<EditSkillListItem> skillListItems;
    private RecyclerView skillRecyclerView;
    private RecyclerView.Adapter skillAdapter;
    private RecyclerView.LayoutManager layoutManager;

    private OnFragmentInteractionListener mListener;

    public CharacterCreationHindrance() {
        // Required empty public constructor
    }

    public CharacterCreationHindrance(Character character){
        this.character = character;
    }


    /*
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CharacterCreationHindrance.
     */
    // TODO: Rename and change types and number of parameters
    public static CharacterCreationHindrance newInstance(String param1, String param2) {
        CharacterCreationHindrance fragment = new CharacterCreationHindrance();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_character_creation_hindrance, container, false);

        //Attach views


        skills =  new ArrayList<>();
        skillListItems = new ArrayList<>();


        Attribute agility = new Attribute("Agility", "Ag");
        Attribute smarts = new Attribute("Smarts", "Sm");
        Attribute spirit = new Attribute("Spirit", "Sp");
        Attribute strength = new Attribute("Strength", "St");
        Attribute vigor = new Attribute("Vigor","Vi");

        skills.add(new Skill(strength, "Climbing"));
        skills.add(new Skill(agility, "Fighting"));
        skills.add(new Skill(smarts, "Healing"));
        skills.add(new Skill(smarts, "Investigation"));
        skills.add(new Skill(agility, "Lockpicking"));
        skills.add(new Skill(smarts, "Notice"));
        skills.add(new Skill(spirit, "Persuasion"));
        skills.add(new Skill(agility, "Shooting"));
        skills.add(new Skill(agility, "Stealth"));
        skills.add(new Skill(smarts, "Streetwise"));


        for (int i = 0; i < character.getSkills().size(); ++i)
            skillListItems.add(new EditSkillListItem(character.getSkills().get(i)));

        skillRecyclerView = view.findViewById(R.id.SkillsRecyclerView);
        skillRecyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getContext());
        skillAdapter = new EditSkillAdapter(skillListItems);

        skillRecyclerView.setLayoutManager(layoutManager);
        skillRecyclerView.setAdapter(skillAdapter);

        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /*
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }


}
