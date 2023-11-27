package com.soholighting.sohoTeam8.cxController;

import com.soholighting.sohoTeam8.cxEnity.Comments;
import com.soholighting.sohoTeam8.cxEnity.KidsImage;
import com.soholighting.sohoTeam8.cxMapper.KidsImageMapper;
import com.soholighting.sohoTeam8.cxService.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
public class CommentsController {
    @Autowired
    private CommentService commentService;


    @GetMapping("/getcomments")
    public ResponseEntity<List<Comments>> getComments(@RequestParam("imageId") Integer imageId) {
        System.out.println("Received imageId: " + imageId);
        List<Comments> comments = commentService.getCommentsByImageId(imageId);
        System.out.println(comments);
        return ResponseEntity.ok(comments);

    }


    @PostMapping("/addcomment")
    public String addComment(@RequestParam("imageId") Integer imageId,
                             @RequestParam("commentText") String commentText,
                             RedirectAttributes redirectAttributes) {
        Comments comment = new Comments();
        comment.setImageId(imageId);
        comment.setCommentText(commentText);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = LocalDateTime.now().format(formatter);
        comment.setCreatedAt(formattedDateTime);

        commentService.addComment(comment);
        System.out.println("Image ID: " + imageId);
        System.out.println("Comment Text: " + commentText);

        redirectAttributes.addFlashAttribute("message", "Comment added successfully");
        return "redirect:/workpage?imageId=" + imageId;
    }
}
