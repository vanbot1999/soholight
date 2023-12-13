package com.soholighting.sohoTeam8.repository.impl;

import com.soholighting.sohoTeam8.model.Comments;
import com.soholighting.sohoTeam8.repository.CommentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class CommentRepositoryTests {

    @Autowired
    private CommentRepository commentRepository;



    @Test
    public void testGetCommentsByImageId() throws SQLException {

        int imageId = 1;


        List<Comments> comments = commentRepository.getCommentsByImageId(imageId);


        assertTrue(comments.size() > 0, "Comments should be found for image id");
    }

    @Test
    public void testInsertComment() throws SQLException {

        Comments newComment = new Comments();
        newComment.setImageId(1);
        newComment.setContent("Test comment");
        newComment.setCreate_time(new java.util.Date());
        newComment.setUserId(1);


        commentRepository.insertComment(newComment);
        List<Comments> comments = commentRepository.getCommentsByImageId(newComment.getImageId());


        assertEquals(1, comments.size(), "One comment should be inserted");
    }

    @Test
    public void testDeleteCommentByImageIdAndUserId() throws SQLException {

        int imageId = 1213;
        int userId = 13;


        commentRepository.deleteCommentByImageIdAndUserId(imageId, userId);
        List<Comments> comments = commentRepository.getCommentsByImageId(imageId);


        assertTrue(comments.isEmpty(), "Comment should be deleted");
    }
}