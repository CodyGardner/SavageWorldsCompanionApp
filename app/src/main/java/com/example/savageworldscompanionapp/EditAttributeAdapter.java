package com.example.savageworldscompanionapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class EditAttributeAdapter extends RecyclerView.Adapter<EditAttributeAdapter.EditAttributeViewHolder> {
    private ArrayList<EditAttributeListItem> listItems;

    public static class EditAttributeViewHolder extends RecyclerView.ViewHolder{
        public Button raiseAttributeButton;
        public Button lowerAttributeButton;
        public TextView attributeName;
        public EditText modifier;
        public TextView attributeLevel;
        public Attribute attribute;

        public EditAttributeViewHolder(View itemView) {
            super(itemView);
            raiseAttributeButton = itemView.findViewById(R.id.raiseAttrButton);
            lowerAttributeButton = itemView.findViewById(R.id.lowerAttrButton);
            attributeName = itemView.findViewById(R.id.attrNameTextView);
            modifier = itemView.findViewById(R.id.modifierTextBox);
            attributeLevel = itemView.findViewById(R.id.dieTypeTextView);

            raiseAttributeButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(attribute.raiseLevel()){
                        switch(attribute.getLevel()){
                            case 1:
                                attributeLevel.setText("D4");
                                break;
                            case 2:
                                attributeLevel.setText("D6");
                                break;
                            case 3:
                                attributeLevel.setText("D8");
                                break;
                            case 4:
                                attributeLevel.setText("D10");
                                break;
                            case 5:
                                attributeLevel.setText("D12");
                                break;
                            default:
                                break;
                        }
                    }
                }
            });
            lowerAttributeButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(attribute.lowerLevel()){
                        switch(attribute.getLevel()){
                            case 1:
                                attributeLevel.setText("D4");
                                break;
                            case 2:
                                attributeLevel.setText("D6");
                                break;
                            case 3:
                                attributeLevel.setText("D8");
                                break;
                            case 4:
                                attributeLevel.setText("D10");
                                break;
                            default:
                                break;
                        }
                    }

                }
            });
        }
    }

    public EditAttributeAdapter(ArrayList<EditAttributeListItem> items){
        listItems = items;
    }

    @Override
    public EditAttributeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.edit_attribute_list_item, parent, false);
        return new EditAttributeViewHolder(v);
    }

    @Override
    public void onBindViewHolder(EditAttributeViewHolder holder, int position) {
        EditAttributeListItem item = listItems.get(position);

        holder.attributeName.setText(item.getAttribute().getName());
        holder.attributeLevel.setText("D4");
        holder.modifier.setText(Integer.toString(item.getAttribute().getModifier()));
        holder.attribute = item.getAttribute();
    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }


}
