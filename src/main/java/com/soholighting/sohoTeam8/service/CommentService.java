package com.soholighting.sohoTeam8.service;





import com.soholighting.sohoTeam8.model.Comments;
import com.soholighting.sohoTeam8.mapper.KidsImageMapper;
import com.soholighting.sohoTeam8.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.sql.SQLException;
import java.util.List;

@Service
public class CommentService {
    @Autowired
    private KidsImageMapper kidsImageMapper;

    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

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

        return kidsImageMapper.checkLike(userId, imgId) > 0;
    }


    @Transactional
    public void likeImage(int userId, int imgId) {
        if (kidsImageMapper.checkLike(userId, imgId) == 0) {
            kidsImageMapper.insertLike(userId, imgId);
            kidsImageMapper.incrementImageLikes(imgId);
        }

    }

    @Transactional
    public void unlikeImage(int userId, int imgId) {
        if (kidsImageMapper.checkLike(userId, imgId) > 0) {
            kidsImageMapper.deleteLike(userId, imgId);
            kidsImageMapper.decrementImageLikes(imgId);
        }

    }
    public int getLikeCountByImageId(int imageId) {

        return kidsImageMapper.countLikes(imageId);
    }

    public void deleteComment(int commentId, int userId) {
        try {
            commentRepository.deleteCommentByImageIdAndUserId(commentId, userId);
        } catch (SQLException e) {

            e.printStackTrace();
        }
    }
    public List<Comments> getAllComments() {
        try {
            System.out.println(commentRepository.getAllComments());
            return commentRepository.getAllComments();
        } catch (SQLException e) {

            throw new RuntimeException("error", e);
        }
    }
}
