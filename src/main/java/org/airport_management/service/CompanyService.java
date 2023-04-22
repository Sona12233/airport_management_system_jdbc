package org.airport_management.service;

import org.airport_management.connection.Connections;
import org.airport_management.model.Company;

import java.sql.*;
import java.util.LinkedHashSet;
import java.util.Set;

public class CompanyService {

    /**
     * This method gets company by its Id
     * @param id
     * @return
     */
    public Company getById(int id) {
        Company company = null;

        try {
            Connection con = Connections.getConnection();
            Statement st = con.createStatement();
            String sql = "select * from company where company_id = " + id;
            ResultSet rs = st.executeQuery(sql);
            company = new Company();

            while (rs.next()){
                company.setCompanyId(rs.getInt("company_id"));
                company.setFoundingDate(rs.getString("founding_date"));
                company.setCompanyName(rs.getString("company_name"));
            }
        } catch (SQLException e) {
            throw new RuntimeException();
        } finally {
            Connections.closeConnection();
        }
        return company;
    }

    /**
     * This method gets all companies from Table
     * @return
     */
    public Set<Company> getAll(){
        Set<Company> allCompanies = new LinkedHashSet<>();

        try {
            Connection con = Connections.getConnection();
            Statement st = con.createStatement();
            String sql = "select * from company";
            ResultSet rs = st.executeQuery(sql);

            while(rs.next()){
                Company company = new Company();
                company.setCompanyId(rs.getInt("company_id"));
                company.setFoundingDate(rs.getString("founding_date"));
                company.setCompanyName(rs.getString("company_name"));
                allCompanies.add(company);
            }
        } catch (SQLException e){
            throw new RuntimeException();
        } finally {
            Connections.closeConnection();
        }
        return allCompanies;
    }

    /**
     * This method returns a set starting from a certain Id
     * @param offset
     * @param perPage
     * @param sort
     * @return
     */
    public Set<Company> get(int offset, int perPage, String sort){
        Set<Company> companyList = new LinkedHashSet<>();

        try {
            Connection con = Connections.getConnection();
            String sql = "select * from company where company_id >= ? order by " + sort + " limit ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, offset);
            pst.setInt(2, perPage);
            ResultSet rs = pst.executeQuery();

            while(rs.next()){
                Company company = new Company();
                company.setCompanyId(rs.getInt("company_id"));
                company.setFoundingDate(rs.getString("founding_date"));
                company.setCompanyName(rs.getString("company_name"));
                companyList.add(company);
            }
        } catch (SQLException e) {
            throw new RuntimeException();
        } finally {
            Connections.closeConnection();
        }
        return companyList;
    }

    /**
     * This method updates company(row) by its id
     * @param id
     * @param company
     * @return
     */
    public Company update(int id, Company company){
        try {
            Connection con = Connections.getConnection();
            String sql = "update company set company_name = ?, founding_date = ? where company_id = " + id;
            PreparedStatement  pst = con.prepareStatement(sql);
            pst.setString(1, company.getCompanyName());
            pst.setString(2, company.getFoundingDate());
            pst.executeUpdate();
        } catch (SQLException e){
            throw new RuntimeException();
        } finally {
            Connections.closeConnection();
        }
        return company;
    }

    /**
     * This method deletes a company(row) by its id
     * @param id
     */
    public void delete(int id){
        try {
            Connection con = Connections.getConnection();
            Statement st = con.createStatement();
            String sql = "delete from company where company_id = " + id;
            st.executeUpdate(sql);
        }
        catch (SQLException e) {
            throw new RuntimeException();
        }
        finally {
            Connections.closeConnection();
        }
    }

}
