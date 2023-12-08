package com.soholighting.sohoTeam8.service;





import com.soholighting.sohoTeam8.model.Comments;
import com.soholighting.sohoTeam8.mapper.KidsImageMapper;
import com.soholighting.sohoTeam8.model.KidsImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class CommentService {
    @Autowired
    private KidsImageMapper kidsImageMapper;


    public List<Comments> findComment(){
        return kidsImageMapper.findComment();
    }
    public void addComment(Comments comment) {
        kidsImageMapper.insertComment(comment);
    }
    public List<Comments> getCommentsByImageId(int image_id) {
        System.out.println(kidsImageMapper);

        return kidsImageMapper.findCommentsByImageId(image_id);

    }
    public Integer getUserIdByUsername(String username) {

        return kidsImageMapper.getUserIdByUsername(username);
    }
}
