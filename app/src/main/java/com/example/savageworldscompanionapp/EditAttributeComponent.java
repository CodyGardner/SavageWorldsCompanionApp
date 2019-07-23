package com.example.savageworldscompanionapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class EditAttributeComponent extends LinearLayout {
    private Attribute attribute;
    private Button raiseAttributeButton;
    private Button lowerAttributeButton;
    private TextView attributeName;
    private EditText modifier;
    private TextView attributeLevel;

    public EditAttributeComponent(Context context, Attribute attr){
        super(context);
        attribute = attr;
        initializeViews(context);
    }

    private void initializeViews(Context context){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.edit_attribute_component, this);
    }

    @Override
    protected void onFinishInflate(){
        super.onFinishInflate();

        /*
        // Set button pictures
        raiseAttributeButton = this.findViewById(R.id.edit_attribute_component_up_button);
        raiseAttributeButton.setBackgroundResource(android.R.drawable.ic_media_next);
        lowerAttributeButton = this.findViewById(R.id.edit_attribute_component_down_button);
        lowerAttributeButton.setBackgroundResource(android.R.drawable.ic_media_previous);

        */

        // Set item values
        attributeName.setText(attribute.getName());
        modifier.setText("+1");
    }
}
