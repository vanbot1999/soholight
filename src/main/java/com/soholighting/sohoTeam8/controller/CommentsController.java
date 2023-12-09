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

@RestController
public class CommentsController {
    @Autowired
    private CommentService commentService;


    @GetMapping("/getcomments")
    public List<Comments> getComments(@RequestParam("imageId") Integer imageId) {
        System.out.println(commentService.getCommentsByImageId(imageId));
        return commentService.getCommentsByImageId(imageId);

    }
    @PostMapping("/{imageId}/like")
    public ResponseEntity<?> likeImage(@PathVariable("imageId") int imageId, HttpServletRequest request) {
        int userId = getCurrentUserId(request);


        if(commentService.hasLiked(userId, imageId)) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("User has already liked this image.");
        }


        commentService.setHasLiked(userId, imageId, true);
        return ResponseEntity.ok().build();
    }


    @DeleteMapping("/{imageId}/like")
    public ResponseEntity<?> unlikeImage(@PathVariable("imageId") int imageId, HttpServletRequest request) {
        int userId = getCurrentUserId(request);


        if(!commentService.hasLiked(userId, imageId)) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("User has not liked this image.");
        }


        commentService.setHasLiked(userId, imageId, false);
        return ResponseEntity.ok().build();
    }

    private Integer getCurrentUserId(HttpServletRequest request) {
        // 从cookie中获取username
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

        System.out.println(comment);
        commentService.addComment(comment);

        return ResponseEntity.ok("Comment added successfully.");
    }
}
