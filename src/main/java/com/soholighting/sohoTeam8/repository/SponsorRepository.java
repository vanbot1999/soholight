package com.soholighting.sohoTeam8.repository;

import com.soholighting.sohoTeam8.model.Sponsors;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@Repository
public class SponsorRepository {

    private Connection getConnection() throws SQLException {
        //get connection
        String url = "jdbc:mariadb://localhost:3306/Soholight";//jdbc url
        String username = "root";
        String password = "comsc";
        return DriverManager.getConnection(url, username, password);
    }
    public List<Sponsors> findAllSponsors() {//find all sponsors
        List<Sponsors> sponsorList = new ArrayList<>();
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM Sponsors")) {//sql query
            while (rs.next()) {
                Sponsors sponsor = new Sponsors();
                sponsor.setSponsor_id(rs.getInt("Sponsor_id"));//set sponsor id
                sponsor.setName(rs.getString("name"));//set sponsor name
                sponsor.setURL(rs.getString("Url"));//set sponsor url
                sponsor.setSponsor_logo(rs.getString("Sponsor_logo")); //set sponsor logo
                sponsorList.add(sponsor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sponsorList;
    }

   //find all sponsors by name
    public List<Sponsors> findAllBySponsorName(String name) {
        List<Sponsors> sponsorList = new ArrayList<>();
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Sponsors WHERE name = ?")) {
            stmt.setString(1, name);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Sponsors sponsor = new Sponsors();
                sponsor.setSponsor_id(rs.getInt("Sponsor_id"));
                sponsor.setName(rs.getString("name"));
                sponsor.setURL(rs.getString("Url"));
                sponsor.setSponsor_logo(rs.getString("Sponsor_logo"));
                sponsorList.add(sponsor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sponsorList;
    }

    public Sponsors findSponsorById(int id) {
        Sponsors sponsor = null;
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Sponsors WHERE Sponsor_id = ?")) {//sql
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                sponsor = new Sponsors();
                sponsor.setSponsor_id(rs.getInt("Sponsor_id"));
                sponsor.setName(rs.getString("name"));
                sponsor.setURL(rs.getString("Url"));
                sponsor.setSponsor_logo(rs.getString("Sponsor_logo"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sponsor;
    }
//insert sponsor
    public void insertSponsor(Sponsors sponsor) {
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(
                     "INSERT INTO Sponsors (Sponsor_id, name, Url, Sponsor_logo) VALUES (?, ?, ?, ?)")) {//sql
            stmt.setInt(1, sponsor.getSponsor_id());
            stmt.setString(2, sponsor.getName());
            stmt.setString(3, sponsor.getURL());
            stmt.setString(4, sponsor.getSponsor_logo());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
//remove sponsor by id
    public void removeSponsorById(int id) {
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement("DELETE FROM Sponsors WHERE Sponsor_id = ?")) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //remove sponsor by name
    public void removeSponsorByName(String name) {
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement("DELETE FROM Sponsors WHERE name = ?")) {
            stmt.setString(1, name);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
