package org.airport_management.model;

public class PassInTrip {

    private Trip trip;

    private Company company;

    private String date;

    private String place;

    public PassInTrip() {
    }

    public String getDate() {
        return date;
    }



    public void setDate(String date) {
        this.date = date;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }
}
