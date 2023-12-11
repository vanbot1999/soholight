package com.soholighting.sohoTeam8.service;





import com.soholighting.sohoTeam8.model.Comments;
import com.soholighting.sohoTeam8.mapper.KidsImageMapper;
import com.soholighting.sohoTeam8.model.KidsImage;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

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


        return kidsImageMapper.findCommentsByImageId(image_id);

    }
    public Integer getUserIdByUsername(String username) {

        return kidsImageMapper.getUserIdByUsername(username);
    }
    public void incrementLikes(int imageId) {
        kidsImageMapper.incrementLikes(imageId);
    }
    public boolean hasLiked(int userId, int imageId) {
        // 调用KidsImageMapper的方法来查询数据库
        Boolean hasLiked = kidsImageMapper.checkUserLiked(userId, imageId);
        // 如果数据库中没有记录，默认用户没有点赞
        return hasLiked != null && hasLiked;
    }

    // 更新点赞的状态
    public void setHasLiked(int userId, int imageId, boolean hasLiked) {
        // 调用KidsImageMapper的方法来更新数据库中的点赞状态
        kidsImageMapper.setHasLiked(userId, imageId, hasLiked);
    }
}
