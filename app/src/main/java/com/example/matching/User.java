package com.example.matching;

import java.util.ArrayList;

public class User {
    private int id;
    private String name;
    private ArrayList<Field> fields = new ArrayList<Field>();
    private static int i = 0;
    private int photo;

    public User(String name, int photo) {
        setId(i);
        i++;
        this.name = name;
        this.photo = photo;
        FriendsActivity.friendsList.add(this);
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Field> getFields() {
        return fields;
    }

    public void setFields(ArrayList<Field> fields) {
        this.fields = fields;
    }


}
