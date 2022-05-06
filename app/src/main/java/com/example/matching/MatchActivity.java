package com.example.matching;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.google.android.material.tabs.TabItem;

import java.util.ArrayList;

public class MatchActivity extends AppCompatActivity {

    public static ArrayList<Field> FieldList = new ArrayList<Field>();
    public static ArrayList<Field> rentFieldList = new ArrayList<Field>();
    public static ArrayList<Field> findFieldList = new ArrayList<Field>();
    public static ArrayList<Field> tournamentFieldList = new ArrayList<Field>();

    private ListView fieldsListView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match);
        setupData();
        setUpListRent();
        setUpOnclickListener();


    }
    private void setupData() {
        Field field1 = new Field("Field A", R.drawable.logo,"Football", "Rent", 22, 22, true);
        addToLists(field1);
    }

    private void addToLists(Field field) {
        FieldList.add(field);

    }

    private void setUpListRent() {
        fieldsListView = (ListView) findViewById(R.id.fieldsListView);
        FieldAdapter adapter = new FieldAdapter(getApplicationContext(), 0, rentFieldList);
        fieldsListView.setAdapter(adapter);
    }

    private void setUpListFind() {
        fieldsListView = (ListView) findViewById(R.id.fieldsListView);
        FieldAdapter adapter = new FieldAdapter(getApplicationContext(), 0, findFieldList);
        fieldsListView.setAdapter(adapter);
    }

    private void setUpListTournament() {
        fieldsListView = (ListView) findViewById(R.id.fieldsListView);
        FieldAdapter adapter = new FieldAdapter(getApplicationContext(), 0, tournamentFieldList);
        fieldsListView.setAdapter(adapter);
    }

    private void setUpOnclickListener() {
        fieldsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Field selectField = (Field) (fieldsListView.getItemAtPosition(position));
                Intent showDetail = new Intent(getApplicationContext(), DetailActivity.class);
                showDetail.putExtra("id",selectField.getId());
                startActivity(showDetail);
            }
        });

    }


}