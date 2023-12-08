package com.soholighting.sohoTeam8.mapper;

import com.soholighting.sohoTeam8.model.AdminAccount;
import com.soholighting.sohoTeam8.model.Comments;
import com.soholighting.sohoTeam8.model.KidsImage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface KidsImageMapper {
    List<KidsImage> findAll();
    List<KidsImage> findAllByYear(@Param("year") String year);
    KidsImage selectImageById(int id);
    void insertComment(@Param("comment") Comments comment);
    List<Comments> findCommentsByImageId(@Param("image_id") int image_id);
    List<Comments> findComment();
    void insertKidsImage(@Param("kidsImage") KidsImage kidsImage);
    AdminAccount getUserLogin(@Param("username") String username, @Param("password") String password);
    Integer getUserIdByUsername(@Param("username") String username);
    void incrementLikes(@Param("imageId") int imageId);


    // 更新点赞状态
    void setHasLiked(@Param("userId") int userId, @Param("imageId") int imageId, @Param("hasLiked") boolean hasLiked);

    Boolean checkUserLiked(@Param("userId") int userId, @Param("imageId") int imageId);
}
