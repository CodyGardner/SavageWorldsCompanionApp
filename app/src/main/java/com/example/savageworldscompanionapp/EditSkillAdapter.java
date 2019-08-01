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

            raiseSkillButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(skill.raiseLevel()){
                        switch(skill.getLevel()){
                            case 1:
                                skillLevel.setText("D4");
                                break;
                            case 2:
                                skillLevel.setText("D6");
                                break;
                            case 3:
                                skillLevel.setText("D8");
                                break;
                            case 4:
                                skillLevel.setText("D10");
                                break;
                            case 5:
                                skillLevel.setText("D12");
                                break;
                            default:
                                break;
                        }
                    }
                }
            });
            lowerSkillButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view){
                    if(skill.lowerLevel()){
                        switch(skill.getLevel()){
                            case 0:
                                skillLevel.setText("UT");
                                break;
                            case 1:
                                skillLevel.setText("D4");
                                break;
                            case 2:
                                skillLevel.setText("D6");
                                break;
                            case 3:
                                skillLevel.setText("D8");
                                break;
                            case 4:
                                skillLevel.setText("D10");
                                break;
                            default:
                                break;
                        }
                    }
                }
            });

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
        holder.modifier.setText(Integer.toString(item.getSkill().getModifier()));
        holder.skill = item.getSkill();
        switch (holder.skill.getLevel()){
            case 0:
                holder.skillLevel.setText("UT");
                break;
            case 1:
                holder.skillLevel.setText("D4");
                break;
            case 2:
                holder.skillLevel.setText("D6");
                break;
            case 3:
                holder.skillLevel.setText("D8");
                break;
            case 4:
                holder.skillLevel.setText("D10");
                break;
            default:
                break;
        }
    }

    @Override
    public int getItemCount() { return listItems.size(); }
}
