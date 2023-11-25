package com.soholighting.sohoTeam8.cxMapper;

import com.soholighting.sohoTeam8.cxEnity.KidsImage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface KidsImageMapper {
    List<KidsImage> findAll();
    List<KidsImage> findAllByYear(@Param("year") String year);
}
