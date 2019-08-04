package com.example.savageworldscompanionapp;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


/*
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link CharacterCreationSkill.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link CharacterCreationSkill#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CharacterCreationSkill extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    ArrayList<Attribute> attrs;
    ArrayList<EditAttributeListItem> attrListItems;
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private Character character;

    private OnFragmentInteractionListener mListener;

    public CharacterCreationSkill() {
        // Required empty public constructor
    }

    public CharacterCreationSkill(Character character){
        this.character = character;
    }

    /*
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CharacterCreationSkill.
     */
    // TODO: Rename and change types and number of parameters
    public static CharacterCreationSkill newInstance(String param1, String param2) {
        CharacterCreationSkill fragment = new CharacterCreationSkill();
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_character_creation_skill, container, false);



        // attrs = new ArrayList<>();
        attrListItems = new ArrayList<>();


        /*attrs.add(new Attribute(getString(R.string.attrAg), getString(R.string.attrAgShort)));
        attrs.add(new Attribute(getString(R.string.attrSm), getString(R.string.attrSmShort)));
        attrs.add(new Attribute(getString(R.string.attrSp), getString(R.string.attrSpShort)));
        attrs.add(new Attribute(getString(R.string.attrSt), getString(R.string.attrStShort)));
        attrs.add(new Attribute(getString(R.string.attrVi), getString(R.string.attrViShort)));*/


        for (int i = 0; i < character.getAttributes().size(); ++i)
            attrListItems.add(new EditAttributeListItem(character.getAttributes().get(i)));

        recyclerView = view.findViewById(R.id.AttributeRecyclerView);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getContext());
        adapter = new EditAttributeAdapter(attrListItems);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

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
