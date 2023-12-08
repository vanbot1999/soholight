package com.soholighting.sohoTeam8.mapper;

import com.soholighting.sohoTeam8.model.AdminAccount;
import com.soholighting.sohoTeam8.model.Comments;
import com.soholighting.sohoTeam8.model.KidsImage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
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
}
