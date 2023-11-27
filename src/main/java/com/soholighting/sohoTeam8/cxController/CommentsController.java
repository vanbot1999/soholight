package com.soholighting.sohoTeam8.cxController;

import com.soholighting.sohoTeam8.cxEnity.Comments;
import com.soholighting.sohoTeam8.cxMapper.KidsImageMapper;
import com.soholighting.sohoTeam8.cxService.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
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



    @PostMapping("/addcomment")
    public String addComment(@RequestParam("imageId") Integer imageId,
                             @RequestParam("commentText") String commentText,
                             RedirectAttributes redirectAttributes) {
        Comments comment = new Comments();
        comment.setImageId(imageId);
        comment.setCommentText(commentText);
        comment.setCreatedAt(LocalDateTime.now());
        commentService.addComment(comment);
        redirectAttributes.addFlashAttribute("message", "Comment added successfully");
        return "redirect:/workpage?imageId=" + imageId;
    }
}
