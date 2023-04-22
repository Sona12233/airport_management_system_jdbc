package org.airport_management.model;

public class Trip {

    private int tripId;

    private Company company; // storing company id

    private String townFrom;

    private String townTo;

    private String timeOut;

    private String timeIn;

    public Trip() {
    }

    public Trip(int tripId, String townFrom, String townTo, String timeOut, String timeIn) {
        this.tripId = tripId;
        this.townFrom = townFrom;
        this.townTo = townTo;
        this.timeOut = timeOut;
        this.timeIn = timeIn;
    }

    public int getTripId() {
        return tripId;
    }

    public void setTripId(int tripId) {
        this.tripId = tripId;
    }

    public String getTownFrom() {
        return townFrom;
    }

    public void setTownFrom(String townFrom) {
        this.townFrom = townFrom;
    }

    public String getTownTo() {
        return townTo;
    }

    public void setTownTo(String townTo) {
        this.townTo = townTo;
    }

    public String getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(String timeOut) {
        this.timeOut = timeOut;
    }

    public String getTimeIn() {
        return timeIn;
    }

    public void setTimeIn(String timeIn) {
        this.timeIn = timeIn;
    }

    @Override
    public String toString() {
        return "Trip{" +
                "tripId=" + tripId +
                ", townFrom='" + townFrom + '\'' +
                ", townTo='" + townTo + '\'' +
                ", timeOut='" + timeOut + '\'' +
                ", timeIn='" + timeIn + '\'' +
                '}';
    }
}
