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

public class EditSkillAdapter extends RecyclerView.Adapter<EditSkillAdapter.EditSkillViewHolder> {
    private ArrayList<EditSkillListItem> listItems;
    public static class EditSkillViewHolder extends RecyclerView.ViewHolder{
        public Button raiseSkillButton;
        public Button lowerSkillButton;
        public TextView skillName;
        public EditText modifier;
        public TextView skillLevel;
        public Skill skill;

        public EditSkillViewHolder(@NonNull View itemView) {
            super(itemView);
            raiseSkillButton = itemView.findViewById(R.id.raiseAttrButton);
            lowerSkillButton = itemView.findViewById(R.id.lowerAttrButton);
            skillName = itemView.findViewById(R.id.attrNameTextView);
            modifier = itemView.findViewById(R.id.modifierTextBox);
            skillLevel = itemView.findViewById(R.id.dieTypeTextView);

            // TODO: add listeners
        }
    }

    public EditSkillAdapter(ArrayList<EditSkillListItem> items){
        listItems = items;
    }

    @Override
    public EditSkillViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.edit_attribute_list_item, parent, false);
        return new EditSkillViewHolder(v);
    }

    @Override
    public void onBindViewHolder(EditSkillViewHolder holder, int position) {
        EditSkillListItem item = listItems.get(position);

        holder.skillName.setText(item.getSkill().getName() + " (" + item.getSkill().getAssociatedAttribute().getShortName() + ")");
        holder.skillLevel.setText("D4");
        holder.modifier.setText(Integer.toString(item.getSkill().getModifier()));
        holder.skill = item.getSkill();
    }

    @Override
    public int getItemCount() { return listItems.size(); }
}
