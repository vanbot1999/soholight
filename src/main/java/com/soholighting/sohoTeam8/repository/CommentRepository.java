package com.soholighting.sohoTeam8.repository;

import com.soholighting.sohoTeam8.model.Comments;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@Repository
public class CommentRepository {
    private Connection getConnection() throws SQLException {
        String url = "jdbc:mariadb://localhost:3306/Soholight";
        String username = "root";
        String password = "comsc";
        return DriverManager.getConnection(url, username, password);
    }
    public List<Comments> getCommentsByImageId(int imageId) throws SQLException {
        List<Comments> comments = new ArrayList<>();
        String sql = "SELECT * FROM Comment WHERE image_id = ?";

        try (Connection connection = getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, imageId);

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Comments comment = new Comments();
                    comment.setId(rs.getInt("id"));
                    comment.setImageId(rs.getInt("image_id"));
                    comment.setContent(rs.getString("content"));
                    comment.setCreate_time(rs.getTimestamp("create_time"));
                    comment.setUserId(rs.getInt("UserID"));
                    // ... set other fields of Comment object

                    comments.add(comment);
                }
            }
        }
        return comments;
    }

    public void deleteCommentByImageIdAndUserId(int id, int userId) throws SQLException {
        String sql = "DELETE FROM Comment WHERE id = ? AND UserID = ?";

        try (Connection connection = getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.setInt(2, userId);
            int affectedRows = pstmt.executeUpdate();
            System.out.println("Deleted " + affectedRows + " rows.");
        }
    }
    public void insertComment(Comments comment) throws SQLException {
        String sql = "INSERT INTO Comment (image_id, content, create_time, UserID) VALUES (?, ?, ?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, comment.getImageId());
            pstmt.setString(2, comment.getContent());
            pstmt.setTimestamp(3, new java.sql.Timestamp(comment.getCreate_time().getTime()));
            pstmt.setInt(4, comment.getUserId());
            pstmt.executeUpdate();
        }
    }

}
