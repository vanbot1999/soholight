package com.soholighting.sohoTeam8.service;





import com.soholighting.sohoTeam8.model.Comments;
import com.soholighting.sohoTeam8.mapper.KidsImageMapper;
import com.soholighting.sohoTeam8.model.KidsImage;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


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
    public boolean hasLiked(int userId, int imgId) {
        // 直接传递参数给映射器方法
        return kidsImageMapper.checkLike(userId, imgId) > 0;
    }


    @Transactional
    public void likeImage(int userId, int imgId) {
        if (kidsImageMapper.checkLike(userId, imgId) == 0) {
            kidsImageMapper.insertLike(userId, imgId);
            kidsImageMapper.incrementImageLikes(imgId);
        }
        // Else, user already liked the image, handle according to your logic
    }

    @Transactional
    public void unlikeImage(int userId, int imgId) {
        if (kidsImageMapper.checkLike(userId, imgId) > 0) {
            kidsImageMapper.deleteLike(userId, imgId);
            kidsImageMapper.decrementImageLikes(imgId);
        }
        // Else, user hasn't liked the image, handle according to your logic
    }

}
