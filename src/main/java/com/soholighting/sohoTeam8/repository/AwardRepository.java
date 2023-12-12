package com.soholighting.sohoTeam8.repository;

import com.soholighting.sohoTeam8.model.Award;
import org.springframework.stereotype.Repository;
import java.sql.*;
import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Repository
public class AwardRepository {

    private final DataSource dataSource;

    public AwardRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<Award> findByCategoryId(int categoryId) {
        List<Award> awards = new ArrayList<>();
        String sql = "SELECT * FROM award WHERE category_id = ?";
        try (Connection conn = dataSource.getConnection();
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
