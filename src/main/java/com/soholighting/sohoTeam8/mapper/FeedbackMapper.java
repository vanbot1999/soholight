package com.soholighting.sohoTeam8.mapper;

import com.soholighting.sohoTeam8.model.Feedback;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Enoch Ribin 23089855
 */
@Mapper
public interface FeedbackMapper {
    List<Feedback> findAllFeedbacks();

    void insertFeedback(@Param("feedback") Feedback feedback);
}
