package com.soholighting.sohoTeam8.repository;

import com.soholighting.sohoTeam8.model.YearlyAwards;
import org.springframework.beans.factory.annotation.Autowired;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class YearlyAwardsRepository {

    @Autowired
    private DataSource dataSource;

    public List<YearlyAwards> findAll() {
        List<YearlyAwards> yearlyAwardsList = new ArrayList<>();
        String sql = "SELECT year FROM yearly_awards";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                YearlyAwards yearlyAwards = new YearlyAwards(rs.getString("year"));
                yearlyAwards.setYear(rs.getString("year"));
                yearlyAwards.setAwardCategories(new ArrayList<>());
                yearlyAwardsList.add(yearlyAwards);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return yearlyAwardsList;
    }

    public List<YearlyAwards> findByYear(String year) {
        List<YearlyAwards> yearlyAwardsList = new ArrayList<>();
        String sql = "SELECT year FROM yearly_awards WHERE year = ?";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, year);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    YearlyAwards yearlyAwards = new YearlyAwards(rs.getString("year"));
                    yearlyAwards.setYear(rs.getString("year"));
                    yearlyAwards.setAwardCategories(new ArrayList<>());
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return yearlyAwardsList;
    }

}
