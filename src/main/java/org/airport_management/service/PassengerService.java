package org.airport_management.service;

import org.airport_management.connection.Connections;
import org.airport_management.model.Passenger;

import java.sql.*;
import java.util.LinkedHashSet;
import java.util.Set;

public class PassengerService {

    /**
     * This method gets a passenger(row) by its id
     *
     * @param id
     * @return
     */
    public Passenger getByID(int id) {
        Passenger passenger = null;

        try {
            Connection con = Connections.getConnection();
            Statement st = con.createStatement();
            String sql = "select * from passenger where passenger_id = " + id;
            ResultSet rs = st.executeQuery(sql);

            passenger = new Passenger();

            while (rs.next()) {
                passenger.setPassengerId(rs.getInt("passenger_id"));
                passenger.setName(rs.getString("passenger_name"));
                passenger.setPhone(rs.getString("phone"));
                passenger.setCountry(rs.getString("country"));
                passenger.setCity(rs.getString("city"));
            }
        } catch (SQLException e) {
            throw new RuntimeException();
        }
        return passenger;
    }

    /**
     * This method gets all passengers from table
     *
     * @return
     */
    public Set<Passenger> getAll() {
        Set<Passenger> allPassengers = new LinkedHashSet<>();

        try {
            Connection con = Connections.getConnection();
            Statement st = con.createStatement();
            String sql = "select * from passenger";
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                Passenger passenger = new Passenger();
                passenger.setPassengerId(rs.getInt("passenger_id"));
                passenger.setName(rs.getString("passenger_name"));
                passenger.setPhone(rs.getString("phone"));
                passenger.setCountry(rs.getString("country"));
                passenger.setCity(rs.getString("city"));

                allPassengers.add(passenger);
            }
        } catch (SQLException e) {
            throw new RuntimeException();
        }
        return allPassengers;
    }

    /**
     * This method returns a set starting from certain id
     *
     * @param offset
     * @param perPage
     * @param sort
     * @return
     */
    public Set<Passenger> get(int offset, int perPage, String sort) {
        Set<Passenger> passengers = new LinkedHashSet<>();

        try {
            Connection con = Connections.getConnection();
            String sql = "select * from passenger where passenger_id >= ? order by " + sort + " limit ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, offset);
            pst.setInt(2, perPage);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Passenger passenger = new Passenger();
                passenger.setPassengerId(rs.getInt("passenger_id"));
                passenger.setName(rs.getString("passenger_name"));
                passenger.setPhone(rs.getString("phone"));
                passenger.setCountry(rs.getString("country"));
                passenger.setCity(rs.getString("city"));

                passengers.add(passenger);
            }
        } catch (SQLException e) {
            throw new RuntimeException();
        } finally {
            Connections.closeConnection();
        }
        return passengers;
    }

    /**
     * This method deletes a passenger(row) by its id
     * @param id
     */
    public void delete(int id) {
        try {
            Connection con = Connections.getConnection();
            Statement st = con.createStatement();
            String sql = "delete from passenger where passenger_id = " + id;
            st.executeUpdate(sql);
        }
        catch (SQLException e){
            throw new RuntimeException();
        }
    }

    public Passenger save(Passenger passenger){
        try{
            Connection con = Connections.getConnection();
            String sql = "insert into passenger(passenger_name,phone,country,city) VALUES(?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, passenger.getName());
            pst.setString(2, passenger.getPhone());
            pst.setString(3, passenger.getCountry());
            pst.setString(4, passenger.getCity());
            pst.executeUpdate();
        }
        catch (SQLException e){
            throw new RuntimeException();
        }
        return passenger;
    }

    public Passenger update(int id, Passenger passenger){
        try {
            Connection con = Connections.getConnection();
            String sql = "update passenger set passenger_name = ?, phone = ?, country = ?, city = ?, where passenger_id = " + id;
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, passenger.getName());
            pst.setString(2, passenger.getPhone());
            pst.setString(3, passenger.getCountry());
            pst.setString(4, passenger.getCity());
            pst.executeUpdate();
        }
        catch (SQLException e){
            throw new RuntimeException();
        }
        return passenger;
    }

}
