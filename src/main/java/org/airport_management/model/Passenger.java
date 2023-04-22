package org.airport_management.model;

public class Passenger {

    private int passengerId;

    private String name;

    private String phone;

    private String country;

    private String city;

    public Passenger() {
    }

    public Passenger(int passengerId, String name, String phone, String country, String city) {
        this.passengerId = passengerId;
        this.name = name;
        this.phone = phone;
        this.country = country;
        this.city = city;
    }

    public int getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(int passengerId) {
        this.passengerId = passengerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "passengerId=" + passengerId +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                '}';
    }

    public int compareTo(Passenger o) {
        if (this.passengerId > o.getPassengerId()){
            return 1;
        } else if (this.passengerId < o.getPassengerId()) {
            return -1;
        }
        return 0;
    }

}
