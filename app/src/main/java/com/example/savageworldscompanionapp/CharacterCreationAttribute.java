package com.example.savageworldscompanionapp;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.widget.Button;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link CharacterCreationAttribute.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link CharacterCreationAttribute#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CharacterCreationAttribute extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private Character character;
    private Button createButton;

    //Text views
    private EditText editTextName;
    private EditText editTextRace;
    private EditText editTextMajHind;
    private EditText editTextMinHind;

    private OnFragmentInteractionListener mListener;

    public CharacterCreationAttribute() {
        // Required empty public constructor
    }

    public CharacterCreationAttribute(Character character){
        this.character = character;
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CharacterCreationAttribute.
     */

    // TODO: Rename and change types and number of parameters
    public static CharacterCreationAttribute newInstance(String param1, String param2) {
        CharacterCreationAttribute fragment = new CharacterCreationAttribute();
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
        View view = inflater.inflate(R.layout.fragment_character_creation_attribute, container, false);
        editTextName = view.findViewById(R.id.CharacterInfoNameView);
        editTextRace = view.findViewById(R.id.CharacterInfoRaceInput);
        createButton = view.findViewById(R.id.CreateCharacterButton);
        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Log.d("Activity: ",getActivity().toString());
                Intent intent = new Intent(getActivity(), CharacterView.class);
                Log.d("Debug: ","Started intent!");
                intent.putExtra("Name",editTextName.getText().toString());
                Log.d("Debug: ","Added name!");
                intent.putExtra("Race",editTextRace.getText().toString());
                Log.d("Debug: ","Added race!");
                startActivity(intent);
            }
        });
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

    /**
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
