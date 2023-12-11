package com.soholighting.sohoTeam8.test;

import com.soholighting.sohoTeam8.model.Comments;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

public class CommentsTest {

    @Test
    public void testCommentSettersAndGetters() {
        // Setup
        Comments comment = new Comments();
        Date now = new Date();


        comment.setId(1);
        comment.setImageId(10);
        comment.setContent("This is a test comment");
        comment.setCreate_time(now);
        comment.setUserId(100);
        comment.setUsername("testUser");


        assertEquals(Integer.valueOf(1), comment.getId());
        assertEquals(Integer.valueOf(10), comment.getImageId());
        assertEquals("This is a test comment", comment.getContent());
        assertEquals(now, comment.getCreate_time());
        assertEquals(100, comment.getUserId());
        assertEquals("testUser", comment.getUsername());
    }

    @Test
    public void testCommentToString() {

        Comments comment = new Comments();
        comment.setId(1);
        comment.setImageId(10);
        comment.setContent("This is a test comment");
        comment.setCreate_time(new Date(0)); // Date at epoch for consistent testing
        comment.setUserId(100);
        comment.setUsername("testUser");


        String expected = "Comments{" +
                "id=1, imageId=10, commentText='This is a test comment', " +
                "createdAt=Thu Jan 01 00:00:00 GMT 1970, userId=100, " +
                "username=testUser}";


        assertEquals(expected, comment.toString());
    }
}
