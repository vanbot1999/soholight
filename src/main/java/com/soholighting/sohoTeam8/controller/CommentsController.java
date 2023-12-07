package com.soholighting.sohoTeam8.controller;

import com.soholighting.sohoTeam8.model.Comments;
import com.soholighting.sohoTeam8.service.CommentService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
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
        return commentService.getCommentsByImageId(imageId);
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
