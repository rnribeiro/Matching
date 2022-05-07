package com.example.matching;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MatchActivity extends AppCompatActivity {

    public static ArrayList<Field> FieldList = new ArrayList<Field>();
    public static ArrayList<Field> rentFieldList = new ArrayList<Field>();
    public static ArrayList<Field> findFieldList = new ArrayList<Field>();
    public static ArrayList<Field> tournamentFieldList = new ArrayList<Field>();
    private ListView fieldsListView;
    private CardView cardView;
    boolean filterHidden = true;
    private Button filterButton, allButtonFilter, footballButtonFilter, basketballButtonFilter, tennisButtonFilter;
    private ArrayList<String> selectedFilters = new ArrayList<String>();
    private TabLayout tabs;

    private String current_matching_type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match);

        inititateWidgets();

        setUpOnclickListener();

        createFields();

        setUpListRent();
        current_matching_type = "Rent";

    }

    private void inititateWidgets() {
        filterButton = findViewById(R.id.filterButton);
        allButtonFilter = findViewById(R.id.allButtonFilter);
        footballButtonFilter = findViewById(R.id.footballFilter);
        basketballButtonFilter = findViewById(R.id.basketballFilter);
        tennisButtonFilter = findViewById(R.id.tennisFilter);
        tabs = findViewById(R.id.tabLayout);
        cardView = findViewById(R.id.cardView);
        fieldsListView = (ListView) findViewById(R.id.fieldsListView);
    }

    private void createFields() {
        Field field1 = new Field("Field A", R.drawable.logo, "Lisbon", "Football", "Rent", 22, 22, true);
        addToLists(field1);
        Field field2 = new Field("Field B", R.drawable.logo, "Porto", "Basketball", "Find", 22, 22, true);
        addToLists(field2);
        Field field3 = new Field("Field C", R.drawable.logo, "Faro", "Tennis", "Rent", 2, 2, true);
        addToLists(field3);
        Field field4 = new Field("Field D", R.drawable.logo, "Lisbon","Football", "Tournament", 22, 22, true);
        addToLists(field4);
        Field field5 = new Field("Field E", R.drawable.logo, "Beja","Tennis", "Rent", 4, 4, true);
        addToLists(field5);
        Field field6 = new Field("Field F", R.drawable.logo, "Coimbra","Basketball", "Tournament", 22, 22, true);
        addToLists(field6);
        Field field7 = new Field("Field G", R.drawable.logo, "Coimbra","Basketball", "Rent", 22, 22, true);
        addToLists(field7);

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
        tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                filterHidden=false;
                hideFilter();
                switch (tab.getPosition()) {
                    case 0:
                        setUpListRent();
                        current_matching_type = "Rent";
                        break;
                    case 1:
                        setUpListFind();
                        current_matching_type = "Find";
                        break;
                    case 2:
                        setUpListTournament();
                        current_matching_type = "Tournament";
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

        fieldsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                filterHidden = false;
                hideFilter();
                Field selectField = (Field) (fieldsListView.getItemAtPosition(position));
                if (selectField.getMatching_type().equals("Rent")){
                    Intent showDetail = new Intent(getApplicationContext(), RentDetailActivity.class);
                    showDetail.putExtra("id", selectField.getId());
                    startActivity(showDetail);
                }
                else if (selectField.getMatching_type().equals("Find")){
                    Intent showDetail = new Intent(getApplicationContext(), FindDetailActivity.class);
                    showDetail.putExtra("id", selectField.getId());
                    startActivity(showDetail);
                }
            }
        });
        filterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (filterHidden == true) {
                    filterHidden = false;
                    showFilter();
                } else {
                    filterHidden = true;
                    hideFilter();
                }
            }
        });
        allButtonFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedFilters.clear();
                selectedFilters.add("all");

                unSelectAllFilterButtons();
                lookSelected(allButtonFilter);

                switch (current_matching_type) {
                    case "Rent":
                        setUpListRent();
                        break;
                    case "Find":
                        setUpListFind();
                        break;
                    case "Tournament":
                        setUpListTournament();
                        break;
                }
            }
        });
        footballButtonFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                filterList("football");
                lookSelected(footballButtonFilter);
                lookUnSelected(allButtonFilter);
            }
        });
        basketballButtonFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                filterList("basketball");
                lookSelected(basketballButtonFilter);
                lookUnSelected(allButtonFilter);
            }
        });
        tennisButtonFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                filterList("tennis");
                lookSelected(tennisButtonFilter);
                lookUnSelected(allButtonFilter);
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
//        parsedButton.setTextColor(white);
//        parsedButton.setBackgroundColor(red);
    }

    private void lookUnSelected(Button parsedButton) {
//        parsedButton.setTextColor(red);
//        parsedButton.setBackgroundColor(darkGray);
    }

    private void filterList(String sport) {
        if (sport != null && !selectedFilters.contains(sport))
            selectedFilters.add(sport);
        else selectedFilters.remove(sport);

        ArrayList<Field> filteredFields = new ArrayList<Field>();

        for (Field field : FieldList) {
            for (String filter : selectedFilters) {
                if (field.getSport().toLowerCase().equals(filter) && current_matching_type.equals(field.getMatching_type())) {
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
    private void hideFilter() {
        cardView.setVisibility(View.GONE);
        filterButton.setText("FILTER");
    }
    private void showFilter() {
        cardView.setVisibility(View.VISIBLE);
        filterButton.setText("HIDE");
    }

}