package com.soholighting.sohoTeam8.repository;

import com.soholighting.sohoTeam8.model.Award;
import org.springframework.beans.factory.annotation.Autowired;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AwardRepository {

    @Autowired
    private DataSource dataSource;

    public List<Award> findAll() {
        List<Award> awardList = new ArrayList<>();
        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM award")) {
            while (rs.next()) {
                Award award = new Award(
                        rs.getString("id"),
                        rs.getString("winnerName"),
                        rs.getString("winnerBackground"),
                        rs.getString("winnerSpeech"),
                        rs.getString("winnerImage")
                );
                awardList.add(award);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return awardList;
    }

}
