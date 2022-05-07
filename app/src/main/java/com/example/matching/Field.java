package com.example.matching;

import android.view.View;

import java.util.ArrayList;

public class Field {
    private int id;
    private String name;
    private int image;
    private String sport;
    private String matching_type;
    private int capacity;
    private int available_capacity;
    private boolean available;
    private static int i=0;
    private String location;

    private ArrayList<User> users = new ArrayList<User>();



    public Field(String name, int image, String location, String sport, String matching_type, int capacity, int available_capacity, boolean available) {
        setId(i);
        i++;
        this.location = location;
        this.name = name;
        this.image = image;
        this.sport = sport;
        this.matching_type = matching_type;
        this.capacity = capacity;
        this.available_capacity = available_capacity;
        this.available = available;
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

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    public String getMatching_type() {
        return matching_type;
    }

    public void setMatching_type(String matching_type) {
        this.matching_type = matching_type;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getAvailable_capacity() {
        return available_capacity;
    }

    public void setAvailable_capacity(int available_capacity) {
        this.available_capacity = available_capacity;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getLocation() {

        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

}