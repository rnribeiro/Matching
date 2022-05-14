package com.example.matching;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MatchActivity extends AppCompatActivity {

    public static ArrayList<Field> FieldList = new ArrayList<Field>();

    public static ArrayList<Field> rentFieldList = new ArrayList<Field>();
    public static ArrayList<Field> findFieldList = new ArrayList<Field>();
    public static ArrayList<Field> tournamentFieldList = new ArrayList<Field>();
    private ListView fieldsListView;
    private CardView filterCardView;
    boolean filterHidden = true;
    private Button filterButton, allButtonFilter, footballButtonFilter, basketballButtonFilter, tennisButtonFilter, locationFilterButton;

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


            Intent last_act = getIntent();
            String type = last_act.getStringExtra("Type");

            switch (type) {
                case "Rent":
                    setUpListRent();
                    tabs.selectTab(tabs.getTabAt(0));
                    current_matching_type = "Rent";
                    break;
                case "Find":
                    setUpListFind();
                    tabs.selectTab(tabs.getTabAt(1));
                    current_matching_type = "Find";
                    break;
                case "Tournament":
                    setUpListTournament();
                    tabs.selectTab(tabs.getTabAt(2));
                    current_matching_type = "Tournament";
                    break;

            }







        unSelectAllFilterButtons();
        lookSelected(allButtonFilter);

        setUpMenu();

    }

    private void setUpMenu() {
        ImageButton menu_icon_btn = findViewById(R.id.menu_icon_btn);

        CardView menuCardView = findViewById(R.id.menuCardView);
        menu_icon_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menuCardView.setVisibility(v.VISIBLE);
            }
        });

        ImageButton hide_menu_icon_btn = findViewById(R.id.hide_menu_icon_btn);

        hide_menu_icon_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menuCardView.setVisibility(v.GONE);
            }
        });

        Button button_rent = findViewById(R.id.button_rent);
        button_rent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menuCardView.setVisibility(v.GONE);
                Intent go_to_login = new Intent(getApplicationContext(), MatchActivity.class);
                go_to_login.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                go_to_login.putExtra("Type", "Rent");
                startActivity(go_to_login);
                overridePendingTransition(0,0);
            }
        });

        Button button_join = findViewById(R.id.button_join);
        button_join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menuCardView.setVisibility(v.GONE);
                Intent go_to_login = new Intent(getApplicationContext(), MatchActivity.class);
                go_to_login.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                go_to_login.putExtra("Type", "Find");
                startActivity(go_to_login);
                overridePendingTransition(0,0);
            }
        });

        Button button_tournaments = findViewById(R.id.button_tournaments);
        button_tournaments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menuCardView.setVisibility(v.GONE);
                Intent go_to_login = new Intent(getApplicationContext(), MatchActivity.class);
                go_to_login.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                go_to_login.putExtra("Type", "Tournament");
                startActivity(go_to_login);
                overridePendingTransition(0,0);
            }
        });


        Button button_Friends = findViewById(R.id.button_Friends);
        button_Friends.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menuCardView.setVisibility(v.GONE);
                Intent go_to_login = new Intent(getApplicationContext(), FriendsActivity.class);
                go_to_login.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(go_to_login);
                overridePendingTransition(0,0);
            }
        });

        Button button_account = findViewById(R.id.button_account);
        button_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menuCardView.setVisibility(v.GONE);
                Intent go_to_login = new Intent(getApplicationContext(), FunctionalityNotImplemented.class);
                go_to_login.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(go_to_login);
                overridePendingTransition(0,0);
            }
        });

        Button button_logout = findViewById(R.id.button_logout);
        button_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menuCardView.setVisibility(v.GONE);
                Intent go_to_login = new Intent(getApplicationContext(), MainActivity.class);
                go_to_login.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(go_to_login);
                overridePendingTransition(0,0);
            }
        });

        FloatingActionButton button_configuration = findViewById(R.id.button_configuration);
        button_configuration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menuCardView.setVisibility(v.GONE);
                Intent go_to_login = new Intent(getApplicationContext(), FunctionalityNotImplemented.class);
                go_to_login.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(go_to_login);
                overridePendingTransition(0,0);
            }
        });




    }


    private void inititateWidgets() {
        filterButton = findViewById(R.id.filterButton);
        allButtonFilter = findViewById(R.id.allButtonFilter);
        footballButtonFilter = findViewById(R.id.footballFilter);
        basketballButtonFilter = findViewById(R.id.basketballFilter);
        tennisButtonFilter = findViewById(R.id.tennisFilter);
        tabs = findViewById(R.id.tabLayout);
        filterCardView = findViewById(R.id.filterCardView);
        fieldsListView = (ListView) findViewById(R.id.fieldsListView);
        locationFilterButton = findViewById(R.id.locationFilterButton);

    }

    private void createFields() {
        Field field1 = new Field("Football field", R.drawable.campo_futebol_campo_pequeno, "Lisbon", "Football", "Rent", 22, 22, true);
        addToLists(field1);
        Field field2 = new Field("Basketball Porto", R.drawable.campo_basket_porto, "Porto", "Basketball", "Find", 10, 22, true);
        addToLists(field2);
        Field field3 = new Field("Tennis/Padel Faro", R.drawable.campo_tenis_faro, "Faro", "Tennis", "Rent", 2, 2, true);
        addToLists(field3);
        Field field4 = new Field("433 Footbar", R.drawable.campo_futebil_lisboa, "Lisbon","Football", "Tournament", 22, 22, true);
        addToLists(field4);
        Field field5 = new Field("Tennis Vila Galé", R.drawable.campo_tenis_beja, "Beja","Tennis", "Rent", 4, 4, true);
        addToLists(field5);
        Field field6 = new Field("Basket Choupal", R.drawable.campo_basket_coimbra1, "Coimbra","Basketball", "Tournament", 10, 22, true);
        addToLists(field6);
        Field field7 = new Field("Street Basket 1", R.drawable.campo_basket_coimbra2, "Coimbra","Basketball", "Rent", 10, 22, true);
        addToLists(field7);

    }



    private void addToLists(Field field) {
        if (!FieldList.contains(field))
            FieldList.add(field);
        switch (field.getMatching_type()) {
            case "Rent":
                if (!rentFieldList.contains(field))
                    rentFieldList.add(field);
                break;
            case "Find":
                if (!findFieldList.contains(field))
                    findFieldList.add(field);
                break;
            case "Tournament":
                if (!tournamentFieldList.contains(field))
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

        locationFilterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent do_login = new Intent(getApplicationContext(), FunctionalityNotImplemented.class);
                do_login.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(do_login);
                overridePendingTransition(0,0);
            }
        });
        tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                filterHidden=true;
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
                filterHidden = true;
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
                } else {
                    Intent showDetail = new Intent(getApplicationContext(), FunctionalityNotImplemented.class);
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

                    lookSelected(footballButtonFilter);
                    lookUnSelected(allButtonFilter);
                    filterList("football",footballButtonFilter);

            }
        });
        basketballButtonFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    lookSelected(basketballButtonFilter);
                    lookUnSelected(allButtonFilter);
                    filterList("basketball",basketballButtonFilter);


            }
        });
        tennisButtonFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    lookSelected(tennisButtonFilter);
                    lookUnSelected(allButtonFilter);
                    filterList("tennis",tennisButtonFilter);

            }
        });


    }

    private void unSelectAllFilterButtons() {
        lookUnSelected(footballButtonFilter);
        lookUnSelected(basketballButtonFilter);
        lookUnSelected(tennisButtonFilter);
    }

    private void lookSelected(Button parsedButton) {
       parsedButton.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.white));
       parsedButton.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.green));
    }

    private void lookUnSelected(Button parsedButton) {
        parsedButton.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.green));
        parsedButton.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.white));
    }

    private void filterList(String sport, Button bt) {
        if (sport != null && !selectedFilters.contains(sport)) {
            selectedFilters.add(sport);

            filter();
        }
        else {
            selectedFilters.remove(sport);
            lookUnSelected(bt);
            filter();

            if (selectedFilters.size()==0) {
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
        }
    }

    public void filter(){
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
        filterCardView.setVisibility(View.GONE);
        filterButton.setText("FILTER");
    }
    private void showFilter() {
        filterCardView.setVisibility(View.VISIBLE);
        filterButton.setText("HIDE");
    }

}