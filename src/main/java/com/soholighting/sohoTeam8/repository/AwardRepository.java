package com.soholighting.sohoTeam8.repository;

import com.soholighting.sohoTeam8.model.Award;
import org.springframework.stereotype.Repository;
import java.sql.*;
import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Repository
// Repository class for handling Award entity-related database operations.
public class AwardRepository {

    private final DataSource dataSource;
    // Constructor to inject the DataSource dependency for database connectivity.
    public AwardRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    // Method to find all awards belonging to a specific category.
    public List<Award> findByCategoryId(int categoryId) {
        List<Award> awards = new ArrayList<>();
        // SQL query to select awards based on category ID.
        String sql = "SELECT * FROM award WHERE category_id = ?";
        try (Connection conn = dataSource.getConnection();
             // Iterating through the result set to create Award objects.
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, categoryId);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Award award = new Award(
                            rs.getString("id"),
                            rs.getString("winnerName"),
                            rs.getString("winnerBackground"),
                            rs.getString("winnerSpeech"),
                            rs.getString("winnerImage")
                    );
                    awards.add(award);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return awards;
    }
}
