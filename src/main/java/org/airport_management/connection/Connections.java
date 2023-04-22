package org.airport_management.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.io.*;

public class Connections {

    private static final String url = "jdbc:postgresql://localhost:5432/airport_management";
    private static final String user = "postgres";
    private static final String password = "sql2023";

    private static Connection con;

    /**
     * Opening a connection
     * @return
     */
    public static Connection getConnection() {
        try {
            con = DriverManager.getConnection(url, user, password);
            return con;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Closing the connection
     */
    public static void closeConnection() {
        if (con == null) {
            throw new NullPointerException("Connection is null");
        }
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method reads company.txt file and inserts its values in company table in order
     */
    public void readFromCompanyTxt() {
        try {
            getConnection();
            File file = new File("C:/Users/HP/Desktop/homework_JDBC/companies.txt");
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr); // for reading file row by row
            String line = reader.readLine(); // this is a single line from file
            while (line != null) {
                String[] dateList = line.split(",");
                String a1 = dateList[0];
                String a2 = dateList[1];
                PreparedStatement pst = con.prepareStatement("insert into company (company_name, founding_date) values(?,?)");
                pst.setString(1, a1);
                pst.setString(2, a2);
                line = reader.readLine();
                pst.executeUpdate();
            }
            closeConnection();
        } catch (Exception e) {
            e.getMessage();
        }
    }

    /**
     * This method reads passengers.txt file and inserts its values in passenger table in order
     */
    public void readFromPassengersTxt() {
        try {
            getConnection();
            File file = new File("C:/Users/HP/Desktop/homework_JDBC/passengers.txt");
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();

            while (line != null) {
                String[] dateList = line.split(",");
                String a1 = dateList[0];
                String a2 = dateList[1];
                String a3 = dateList[2];
                String a4 = dateList[3];

                PreparedStatement pst = con.prepareStatement("insert into passenger (passeger_name, passenger_phone, country, city) values(?,?,?,?)");

                pst.setString(1, a1);
                pst.setString(2, a2);
                pst.setString(3, a3);
                pst.setString(4, a4);

                line = reader.readLine();
                pst.executeUpdate();
            }
            closeConnection();
        } catch (Exception e) {
            e.getMessage();
        }
    }

    /**
     * This method reads trip.txt file and inserts its values in trip table in order
     */
    public void readFromTripTxt() {
        try{
            getConnection();
            File file = new File("C:/Users/HP/Desktop/homework_JDBC/trip.txt");
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();

            while (line != null){
                String[] dateList = line.split(",");
                String a1 = dateList[0];
                String a2 = dateList[1];
                String a3 = dateList[2];
                String a4 = dateList[3];
                String a5 = dateList[4];
                String a6 = dateList[5];
                String a7 = dateList[6];

                PreparedStatement pst = con.prepareStatement("insert into trip (trip_id, airplane_name, town_from, town_to, time_out, time_in) values(?,?,?,?,?,?,?)");

                pst.setInt(1, Integer.parseInt(a1));
                pst.setInt(2, Integer.parseInt(a2));
                pst.setString(3,a3);
                pst.setString(4,a4);
                pst.setString(5,a5);
                pst.setString(6,a6);
                pst.setString(7,a7);

                line = reader.readLine();
                pst.executeUpdate();
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }

}
