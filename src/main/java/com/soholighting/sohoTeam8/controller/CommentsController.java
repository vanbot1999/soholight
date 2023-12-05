package com.soholighting.sohoTeam8.controller;

import com.soholighting.sohoTeam8.model.Comments;
import com.soholighting.sohoTeam8.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public String addComment(@RequestParam("image_id") Integer image_id,
                             @RequestParam("content") String content,
                             RedirectAttributes redirectAttributes) {
        Comments comment = new Comments();
        comment.setImageId(image_id);
        comment.setContent(content);
        comment.setCreate_time(new Date());
        comment.setUserId(12138);
        commentService.addComment(comment);
        System.out.println("Image ID: " + image_id);
        System.out.println("Comment Text: " + content);


        return "workpage?imageId=" + image_id;
    }
}
