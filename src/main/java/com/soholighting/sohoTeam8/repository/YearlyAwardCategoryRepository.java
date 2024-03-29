package com.soholighting.sohoTeam8.repository;

import com.soholighting.sohoTeam8.model.Award;
import com.soholighting.sohoTeam8.model.YearlyAwardCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.sql.*;
import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Repository
// Repository class for handling YearlyAwardCategory entity-related database operations.
public class YearlyAwardCategoryRepository {

    private final DataSource dataSource;
    private final AwardRepository awardRepository;
    // Constructor to inject dependencies for DataSource and AwardRepository.
    @Autowired
    public YearlyAwardCategoryRepository(DataSource dataSource, AwardRepository awardRepository) {
        this.dataSource = dataSource;
        this.awardRepository = awardRepository;
    }
    // Method to find all award categories for a specific year.
    public List<YearlyAwardCategory> findByYearId(int yearId) {
        List<YearlyAwardCategory> categories = new ArrayList<>();
        // SQL query to select award categories based on year ID.
        String sql = "SELECT * FROM award_category WHERE year_id = ?";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, yearId);
            try (ResultSet rs = stmt.executeQuery()) {
                // Iterating through the result set to create YearlyAwardCategory objects.
                while (rs.next()) {
                    int categoryId = rs.getInt("category_id");
                    String categoryTitle = rs.getString("category_title");
                    List<Award> awards = awardRepository.findByCategoryId(categoryId);
                    YearlyAwardCategory category = new YearlyAwardCategory(categoryTitle, awards);
                    categories.add(category);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categories;
    }
}
