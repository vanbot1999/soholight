package com.soholighting.sohoTeam8.repository;

import com.soholighting.sohoTeam8.model.YearlyAwardCategory;
import com.soholighting.sohoTeam8.model.YearlyAwards;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.sql.*;
import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Repository
// Repository class for handling YearlyAwards entity-related database operations.
public class YearlyAwardsRepository {

    private final DataSource dataSource;
    private final YearlyAwardCategoryRepository yearlyAwardCategoryRepository;

    // Constructor to inject dependencies for DataSource and YearlyAwardCategoryRepository.
    @Autowired
    public YearlyAwardsRepository(DataSource dataSource, YearlyAwardCategoryRepository yearlyAwardCategoryRepository) {
        this.dataSource = dataSource;
        this.yearlyAwardCategoryRepository = yearlyAwardCategoryRepository;
    }
    // Method to find all yearly awards.
    public List<YearlyAwards> findAll() {
        List<YearlyAwards> yearlyAwardsList = new ArrayList<>();
        // SQL query to select all yearly awards.
        String sql = "SELECT * FROM yearly_awards";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int yearId = rs.getInt("year_id");
                String year = rs.getString("year");
                List<YearlyAwardCategory> categories = yearlyAwardCategoryRepository.findByYearId(yearId);
                YearlyAwards yearlyAwards = new YearlyAwards(year, categories);
                yearlyAwardsList.add(yearlyAwards);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return yearlyAwardsList;
    }
}
