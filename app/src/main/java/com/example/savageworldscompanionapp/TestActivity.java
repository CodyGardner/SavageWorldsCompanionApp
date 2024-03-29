package com.example.savageworldscompanionapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class TestActivity extends AppCompatActivity {
    ArrayList<Attribute> attrs;
    ArrayList<EditAttributeListItem> attrListItems;
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        attrs = new ArrayList<>();
        attrListItems = new ArrayList<>();

        attrs.add(new Attribute(getString(R.string.attrAg), getString(R.string.attrAgShort)));
        attrs.add(new Attribute(getString(R.string.attrSm), getString(R.string.attrSmShort)));
        attrs.add(new Attribute(getString(R.string.attrSp), getString(R.string.attrSpShort)));
        attrs.add(new Attribute(getString(R.string.attrSt), getString(R.string.attrStShort)));
        attrs.add(new Attribute(getString(R.string.attrVi), getString(R.string.attrViShort)));

        for (int i = 0; i < attrs.size(); ++i)
            attrListItems.add(new EditAttributeListItem(attrs.get(i)));

        recyclerView = findViewById(R.id.AttributeRecyclerView);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        adapter = new EditAttributeAdapter(attrListItems);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
}
