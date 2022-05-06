package com.example.matching;

public class Field {
    private int id;
    private String name;
    private int image;

    private String sport;

    private String status;

    private int capacity;

    private int available_capacity;

    private boolean available;
    private static int i=0;



    public Field(String name, int image, String sport, String status, int capacity, int available_capacity, boolean available) {
        this.id = i;
        i++;
        this.name = name;
        this.image = image;
        this.sport = sport;
        this.status = status;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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


}
