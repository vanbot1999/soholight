package com.soholighting.sohoTeam8.controller;

import com.soholighting.sohoTeam8.model.Comments;
import com.soholighting.sohoTeam8.service.CommentService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Map;
/**
 * REST controller for managing comments and likes related to images.
 */
@RestController
public class CommentsController {
    @Autowired
    private CommentService commentService;

    // Method to handle the 'comment' action on an image
    @GetMapping("/getcomments")
    public List<Comments> getComments(@RequestParam("imageId") Integer imageId) {
        System.out.println(commentService.getCommentsByImageId(imageId));
        return commentService.getCommentsByImageId(imageId);

    }
    // Method to handle the 'like' action on an image
    @PostMapping("/{imageId}/like")
    public ResponseEntity<?> likeImage(@PathVariable("imageId") int imageId, HttpServletRequest request) {
        Integer userId = getCurrentUserId(request);
        if (userId == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("User is not authenticated.");
        }

        if(commentService.hasLiked(userId, imageId)) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("User has already liked this image.");
        }

        commentService.likeImage(userId, imageId);
        return ResponseEntity.ok().build();
    }
    // Method to handle the 'unlike' action on an image
    @DeleteMapping("/{imageId}/unlike")
    public ResponseEntity<?> unlikeImage(@PathVariable("imageId") int imageId, HttpServletRequest request) {
        Integer userId = getCurrentUserId(request);
        if (userId == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("User is not authenticated.");
        }

        if(!commentService.hasLiked(userId, imageId)) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("User has not liked this image.");
        }

        commentService.unlikeImage(userId, imageId);
        return ResponseEntity.ok().build();
    }
    // Method to check if a user has liked a specific image
    @GetMapping("/{imageId}/check-like")
    public ResponseEntity<Boolean> checkLike(@PathVariable("imageId") int imageId, HttpServletRequest request) {

        Integer userId = getCurrentUserId(request);
        if (userId == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }


        boolean hasLiked = commentService.hasLiked(userId, imageId);
        return ResponseEntity.ok(hasLiked);
    }
    // Helper method to retrieve the current user's ID based on request cookies
    private Integer getCurrentUserId(HttpServletRequest request) {

        String username = null;
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("user".equals(cookie.getName())) {
                    username = cookie.getValue();
                    break;
                }
            }
        }


        if (username == null) {
            return null;
        }


        Integer userId = commentService.getUserIdByUsername(username);
        return userId;
    }

    // Method to add a comment to an image
    @PostMapping("/addcomment")
    public ResponseEntity<?> addComment(@RequestParam("image_id") Integer image_id,
                                        HttpServletRequest request,
                                        @RequestParam("content") String content) {
        String username = null;
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("user".equals(cookie.getName())) {
                    username = cookie.getValue();
                    break;
                }
            }
        }

        if (username == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("User is not logged in.");
        }

        Integer userId = commentService.getUserIdByUsername(username);
        if (userId == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found.");
        }
        System.out.println(userId);
        Comments comment = new Comments();
        comment.setImageId(image_id);
        comment.setContent(content);
        comment.setCreate_time(new Date());
        comment.setUserId(userId);


        commentService.addComment(comment);

        return ResponseEntity.ok("Comment added successfully.");
    }
    // Method to get the number of likes for a specific image
    @GetMapping("/{imageId}/like-count")
    public ResponseEntity<?> getLikesCount(@PathVariable("imageId") int imageId) {
        try {
            int likeCount = commentService.getLikeCountByImageId(imageId);
            System.out.println(likeCount);
            return new ResponseEntity<>(likeCount, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    // Alternative method to delete a comment with specified user ID
    @DeleteMapping("/delete/{commentId}")
    public ResponseEntity<?> deleteComment(@PathVariable("commentId") int commentId,
                                           HttpServletRequest request) {
        Integer userId = getCurrentUserId(request);
        if (userId == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("No this user。");
        }

        try {
            System.out.println("HH");
            commentService.deleteComment(commentId, userId);
            return ResponseEntity.ok("delete success。");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("error for delete " + e.getMessage());
        }
    }
    // Alternative method to delete a comment with specified user ID
    @DeleteMapping("/delete2/{commentId}/{userId}")
    public ResponseEntity<?> deleteComment2(@PathVariable("commentId") int commentId,@PathVariable("userId") int userId,
                                           HttpServletRequest request) {

        try {
            System.out.println("HH");
            commentService.deleteComment(commentId, userId);
            return ResponseEntity.ok("delete success。");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("error for delete " + e.getMessage());
        }
    }
    // Method to get all comments
    @GetMapping("/comments")
    public ResponseEntity<List<Comments>> getAllComments() {
        try {
            List<Comments> comments = commentService.getAllComments();
            return new ResponseEntity<>(comments, HttpStatus.OK);
        } catch (Exception e) {

            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }// Method to send an email to a user (for example, a notification)
    @PostMapping("/sendEmail/{userId}")
    public ResponseEntity<String> sendEmail(@PathVariable int userId) {
        System.out.println("Email sent successfully.");
        return new ResponseEntity<>("Email sent successfully.", HttpStatus.OK);
    }
}
