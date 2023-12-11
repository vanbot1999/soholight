package com.soholighting.sohoTeam8.repository;

import com.soholighting.sohoTeam8.model.Feedback;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FeedbackRepository {

    private Connection getConnection() throws SQLException {
        String url = "jdbc:mariadb://localhost:3306/Soholight";
        String username = "root";
        String password = "comsc";
        return DriverManager.getConnection(url, username, password);
    }

    public List<Feedback> findAll() {
        List<Feedback> feedbackList = new ArrayList<>();
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM feedback")) {
            while (rs.next()) {
                Feedback feedback = new Feedback();
                feedback.setUsername(rs.getString("username"));
                feedback.setEmail(rs.getString("email"));
                feedback.setMessage(rs.getString("message"));
                feedbackList.add(feedback);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return feedbackList;
    }

    public void save(Feedback feedback) {
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(
                     "INSERT INTO feedback (username, email, message) VALUES (?, ?, ?)")) {
            stmt.setString(1, feedback.getUsername());
            stmt.setString(2, feedback.getEmail());
            stmt.setString(3, feedback.getMessage());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
