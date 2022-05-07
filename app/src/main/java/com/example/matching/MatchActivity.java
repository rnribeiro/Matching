package com.example.matching;

import android.content.Intent;
import android.text.Layout;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.core.content.ContextCompat;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MatchActivity extends AppCompatActivity {

    public static ArrayList<Field> FieldList = new ArrayList<Field>();
    public static ArrayList<Field> rentFieldList = new ArrayList<Field>();
    public static ArrayList<Field> findFieldList = new ArrayList<Field>();
    public static ArrayList<Field> tournamentFieldList = new ArrayList<Field>();

    private ListView fieldsListView;

    private Layout filterLayout;
    boolean filterHidden = true;

    private Button allButtonFilter, footballButtonFilter, basketballButtonFilter, tennisButtonFilter;
    private ArrayList<String> selectedFilters = new ArrayList<String>();

    private TabLayout tabs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match);
        allButtonFilter = findViewById(R.id.allButtonFilter);
        footballButtonFilter = findViewById(R.id.footballFilter);
        basketballButtonFilter = findViewById(R.id.basketballFilter);
        tennisButtonFilter = findViewById(R.id.tennisFilter);
        tabs = findViewById(R.id.tabLayout);

        setupData();
        setUpListRent();
        setUpOnclickListener();

        tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    case 0:
                        setUpListRent();
                        break;
                    case 1:
                        setUpListFind();
                        break;
                    case 2:
                        setUpListTournament();
                        break;

                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void setupData() {
        Field field1 = new Field("Field A", R.drawable.logo,"Football", "Rent", 22, 22, true);
        addToLists(field1);
        Field field2 = new Field("Field B", R.drawable.logo,"Football", "Find", 22, 22, true);
        addToLists(field2);
        Field field3 = new Field("Field C", R.drawable.logo,"Football", "Tournament", 22, 22, true);
        addToLists(field3);

    }

    private void addToLists(Field field) {
        FieldList.add(field);
        switch (field.getMatching_type()) {
            case "Rent":
                rentFieldList.add(field);
                break;
            case "Find":
                findFieldList.add(field);
                break;
            case "Tournament":
                tournamentFieldList.add(field);
                break;
        }
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
        fieldsListView = (ListView) findViewById(R.id.fieldsListView);
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

    private void unSelectAllFilterButtons() {
        lookUnSelected(footballButtonFilter);
        lookUnSelected(basketballButtonFilter);
        lookUnSelected(tennisButtonFilter);
    }

    private int white, darkGray, red;
    private void initColors() {
        white = ContextCompat.getColor(getApplicationContext(), R.color.colorPrimary);
        red = ContextCompat.getColor(getApplicationContext(), R.color.red);
        darkGray = ContextCompat.getColor(getApplicationContext(), R.color.darkerGray);
    }
    private void lookSelected(Button parsedButton) {
        parsedButton.setTextColor(white);
        parsedButton.setBackgroundColor(red);
    }

    private void lookUnSelected(Button parsedButton) {
        parsedButton.setTextColor(red);
        parsedButton.setBackgroundColor(darkGray);
    }

    private void filterList(String sport) {
        if(sport != null && !selectedFilters.contains(sport))
            selectedFilters.add(sport);

        ArrayList<Field> filteredFields = new ArrayList<Field>();

        for(Field field: FieldList) {
            for(String filter: selectedFilters) {
                if(field.getName().toLowerCase().contains(filter)) {
                    filteredFields.add(field);
                }
            }
        }

        setAdapter(filteredFields);
    }

    private void setAdapter(ArrayList<Field> fieldList) {
        fieldsListView = (ListView) findViewById(R.id.fieldsListView);
        FieldAdapter adapter = new FieldAdapter(getApplicationContext(), 0, fieldList);
        fieldsListView.setAdapter(adapter);
    }

    public void allFilterTapped(View view) {
        selectedFilters.clear();
        selectedFilters.add("all");

        unSelectAllFilterButtons();
        lookSelected(allButtonFilter);

        setAdapter(FieldList);
    }

    public void footballButtonClicked(View view) {
        filterList("football");
        lookSelected(footballButtonFilter);
        lookUnSelected(allButtonFilter);
    }

    public void basketballButtonFilter(View view) {
        filterList("basketball");
        lookSelected(footballButtonFilter);
        lookUnSelected(allButtonFilter);
    }

    public void tennisButtonClicked(View view) {
        filterList("tennis");
        lookSelected(footballButtonFilter);
        lookUnSelected(allButtonFilter);
    }


}