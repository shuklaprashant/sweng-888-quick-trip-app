package com.sweng888.quicktrip.model;

public class UserPreference {
    private String id;
    private String category;
    private String characteristic;
    private boolean preferred;

    public UserPreference(String id, String category, String characteristic, boolean preferred) {
        this.id = id;
        this.category = category;
        this.characteristic = characteristic;
        this.preferred = preferred;
    }

    public void setPreferred(boolean preferred) {
        this.preferred = preferred;
    }

    public String getId() {

        return id;
    }

    public String getCategory() {
        return category;
    }

    public String getCharacteristic() {
        return characteristic;
    }

    public boolean isPreferred() {
        return preferred;
    }

    public void changeSelection() {
        this.preferred = this.preferred == true ? false : true;
    }

    @Override
    public String toString() {
        return "UserPreference{" +
                "id='" + id + '\'' +
                ", category='" + category + '\'' +
                ", characteristic='" + characteristic + '\'' +
                ", preferred=" + preferred +
                '}';
    }
}
