package com.soholighting.sohoTeam8.service;



import com.soholighting.sohoTeam8.model.Comments;
import com.soholighting.sohoTeam8.mapper.KidsImageMapper;
import com.soholighting.sohoTeam8.repository.CommentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class CommentServiceTest {

    private CommentService commentService;

    @Mock
    private KidsImageMapper kidsImageMapper;

    @Mock
    private CommentRepository commentRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        commentService = new CommentService(commentRepository);
    }

    @Test
    void testGetAllComments() {

        List<Comments> mockComments = new ArrayList<>();
        when(kidsImageMapper.findComment()).thenReturn(mockComments);


        List<Comments> result = commentService.findComment();


        assertEquals(mockComments, result);
        verify(kidsImageMapper).findComment();
    }

    @Test
    void testAddComment() {

        Comments comment = new Comments();
        doNothing().when(kidsImageMapper).insertComment(comment);


        commentService.addComment(comment);


        verify(kidsImageMapper).insertComment(comment);
    }



    @Test
    void testDeleteComment() throws SQLException {
        // Arrange
        int commentId = 1;
        int userId = 1;
        doNothing().when(commentRepository).deleteCommentByImageIdAndUserId(commentId, userId);


        commentService.deleteComment(commentId, userId);


        verify(commentRepository).deleteCommentByImageIdAndUserId(commentId, userId);
    }


}
