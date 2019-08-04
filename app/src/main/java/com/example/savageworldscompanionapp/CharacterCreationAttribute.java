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

import java.io.Serializable;
import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link CharacterCreationAttribute.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link CharacterCreationAttribute#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CharacterCreationAttribute extends Fragment implements Serializable {
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
    private EditText editTextEdges;

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
        editTextMajHind = view.findViewById(R.id.CharacterInfoMajorHindrances);
        editTextMinHind = view.findViewById(R.id.CharacterInfoMinorHindrances);
        editTextEdges = view.findViewById(R.id.CharacterInfoEdges);
        createButton = view.findViewById(R.id.CreateCharacterButton);
        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Log.d("Activity: ",getActivity().toString());
                Intent intent = new Intent(getActivity(), CharacterView.class);
                Log.d("Debug: ","Started intent!");

                character.setCharacterName(editTextName.getText().toString());
                character.setCharacterRace(editTextRace.getText().toString());
                //For each numerical text field, fall back to 0 if it fails to get the value.
                try {
                    character.setMajorHindrances(Integer.parseInt(editTextMajHind.getText().toString()));
                }
                catch(Exception e) {
                    Log.e("Error! ","Failed to get major hindrances!");
                    Log.e("Message: ",e.toString());
                    character.setMajorHindrances(0);
                }

                try {
                    character.setMinorHindrances(Integer.parseInt(editTextMinHind.getText().toString()));
                }
                catch(Exception e) {
                    Log.e("Error! ","Failed to get minor hindrances!");
                    Log.e("Message: ",e.toString());
                    character.setMinorHindrances(0);
                }

                try {
                    character.setEdges(Integer.parseInt(editTextEdges.getText().toString()));
                }
                catch(Exception e) {
                    Log.e("Error! ","Failed to get edges!");
                    Log.e("Message: ",e.toString());
                    character.setEdges(0);
                }

                //Grab attributes and skills
                //Apparently it's already grabbing them...?

                // Pass character details through intents
                character.passThroughIntent(intent);
                Log.d("Intent information: ",intent.getExtras().toString());
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
