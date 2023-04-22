package org.airport_management.service;

import org.airport_management.connection.Connections;
import org.airport_management.model.Trip;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class TripService {

    /**
     * This method gets a trip(row) by its Id
     *
     * @param id
     * @return
     */
    public Trip getById(int id) {
        Trip trip = null;

        try {
            Connection con = Connections.getConnection();
            Statement st = con.createStatement();
            String sql = "select * from trip where trip_id = " + id;
            ResultSet rs = st.executeQuery(sql);
            trip = new Trip();

            while (rs.next()) {
                trip.setTripId(rs.getInt("trip_id"));
                trip.setTownFrom(rs.getString("town_from"));
                trip.setTownTo(rs.getString("town_to"));
                trip.setTimeOut(rs.getString("time_out"));
                trip.setTimeIn(rs.getString("time_in"));
            }

        } catch (SQLException e) {
            throw new RuntimeException()
        } finally {
            Connections.closeConnection();
        }
        return trip;
    }

    /**
     * This method gets all Trips(rows) from Trip Table
     *
     * @return
     */
    public Set<Trip> getAll() {
        Set<Trip> allTrips = new LinkedHashSet<>();

        try {
            Connection con = Connections.getConnection();
            Statement st = con.createStatement();
            String sql = "select * from trip";
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                Trip trip = new Trip();
                trip.setTripId(rs.getInt("trip_id"));
                trip.setTownFrom(rs.getString("town_from"));
                trip.setTownTo(rs.getString("town_to"));
                trip.setTimeOut(rs.getString("time_out"));
                trip.setTimeIn(rs.getString("time_in"));
                allTrips.add(trip);
            }
        } catch (SQLException e) {
            throw new RuntimeException();
        } finally {
            Connections.closeConnection();
        }
        return allTrips;
    }

    /**
     * This method returns a set starting from certain id
     *
     * @param offset
     * @param perPage
     * @param sort
     * @return
     */
    public Set<Trip> get(int offset, int perPage, String sort) {
        Set<Trip> allTrips = new LinkedHashSet<>();

        try {
            Connection con = Connections.getConnection();
            String sql = "select * from trip where trip_id >= ? order by " + sort + " limit ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, offset);
            pst.setInt(2, perPage);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Trip trip = new Trip();
                trip.setTripId(rs.getInt("trip_id"));
                trip.setTownFrom(rs.getString("town_from"));
                trip.setTownTo(rs.getString("town_to"));
                trip.setTimeOut(rs.getString("time_out"));
                trip.setTimeIn(rs.getString("time_in"));
                allTrips.add(trip);
            }
        } catch (SQLException e) {
            throw new RuntimeException();
        } finally {
            Connections.closeConnection();
        }
        return allTrips;
    }

    /**
     * This method saves new Trip(row)
     *
     * @param trip
     * @return
     */
    public Trip save(Trip trip) {
        try {
            Connection con = Connections.getConnection();
            String sql = "insert into trip(company_id, town_from, town_to, time_out, time_in) VALUES(?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, trip.getTownFrom());
            pst.setString(2, trip.getTownTo());
            pst.setString(3, trip.getTimeOut());
            pst.setString(4, trip.getTimeIn());
            pst.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException();
        } finally {
            Connections.closeConnection();
        }
        return trip;
    }

    /**
     * This method updates a trip(row) by its id
     *
     * @param id
     * @param trip
     * @return
     */
    public Trip update(int id, Trip trip) {
        try {
            Connection con = Connections.getConnection();
            String sql = "update trip set company_id = ?, town_from = ?,town_to = ?, time_out = ?, time_in = ? WHERE trip_id = " + id;
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setString(1, trip.getTownFrom());
            pst.setString(2, trip.getTownTo());
            pst.setString(3, trip.getTimeOut());
            pst.setString(4, trip.getTimeIn());
            pst.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException();
        } finally {
            Connections.closeConnection();
        }
        return trip;
    }

    /**
     * This method deletes a trip(row) from table by its id
     *
     * @param tripId
     */
    public void delete(int tripId) {
        try {
            Connection con = Connections.getConnection();
            Statement st = con.createStatement();
            String sql = "delete from trip where trip_id = " + tripId;
            st.executeUpdate(sql);
        } catch (SQLException e) {
            throw new RuntimeException();
        } finally {
            Connections.closeConnection();

        }
    }

    /**
     * This method gets all trips from certain city
     * @param city
     * @return
     */
    public List<Trip> getTripsFromCity(String city) {
        List<Trip> tripsFromList = new ArrayList<>();

        Trip trip = null;
        try {
            Connection con = Connections.getConnection();
            Statement st = con.createStatement();
            String sql = "select * from trip where town_from = " + city;
            ResultSet rs = st.executeQuery(sql);
            trip = new Trip();
            while (rs.next()) {
                trip.setTripId(rs.getInt("id"));
                trip.setTownFrom(rs.getString("town_from"));
                trip.setTownTo(rs.getString("town_to"));
                trip.setTimeOut(rs.getString("time_out"));
                trip.setTimeIn(rs.getString("time_in"));
                tripsFromList.add(trip);
            }
        } catch (SQLException e) {
            throw new RuntimeException();
        } finally {
            Connections.closeConnection();
        }
        return tripsFromList;
    }

    /**
     * This method gets all trips to  certain city
     * @param city
     * @return
     */
    public List<Trip> getTripsToCity(String city) {
        List<Trip> tripsToList = new ArrayList<>();

        Trip trip = null;
        try {
            Connection con = Connections.getConnection();
            Statement st = con.createStatement();
            String sql = "select * from trip where town_to " + city;
            ResultSet rs = st.executeQuery(sql);
            trip = new Trip();
            while (rs.next()) {
                trip.setTripId(rs.getInt("id"));
                trip.setTownFrom(rs.getString("town_from"));
                trip.setTownTo(rs.getString("town_to"));
                trip.setTimeOut(rs.getString("time_out"));
                trip.setTimeIn(rs.getString("time_in"));
                tripsToList.add(trip);
            }
        } catch (SQLException e) {
            throw new RuntimeException();
        } finally {
            Connections.closeConnection();
        }
        return tripsToList;
    }



}
