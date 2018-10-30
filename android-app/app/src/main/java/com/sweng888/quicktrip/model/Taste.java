package com.sweng888.quicktrip.model;

public class Taste {
    private int id;
    private String name;
    private String description;
    private boolean selected;

    public Taste(int id, String name, String description, boolean selected) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.selected = selected;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}
