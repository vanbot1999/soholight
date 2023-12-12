package com.soholighting.sohoTeam8.repository;

import com.soholighting.sohoTeam8.model.YearlyAwardCategory;
import org.springframework.beans.factory.annotation.Autowired;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AwardCategoryRepository {

    @Autowired
    private DataSource dataSource;

    public List<YearlyAwardCategory> findAll() {
        List<YearlyAwardCategory> categoryList = new ArrayList<>();
        String sql = "SELECT ac.category_title FROM award_category ac";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                String categoryTitle = rs.getString("category_title");
                YearlyAwardCategory category = new YearlyAwardCategory(categoryTitle, new ArrayList<>());
                categoryList.add(category);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categoryList;
    }

    public List<YearlyAwardCategory> findCategoriesByYear(String year) {
        List<YearlyAwardCategory> categories = new ArrayList<>();
        String sql = "SELECT ac.category_title FROM award_category ac " +
                "JOIN yearly_awards ya ON ac.year_id = ya.year_id " +
                "WHERE ya.year = ?";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, year);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    String categoryTitle = rs.getString("category_title");
                    YearlyAwardCategory category = new YearlyAwardCategory(categoryTitle, new ArrayList<>());
                    categories.add(category);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categories;
    }
}
