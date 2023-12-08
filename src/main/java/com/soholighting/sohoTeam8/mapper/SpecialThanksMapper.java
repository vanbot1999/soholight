package com.soholighting.sohoTeam8.mapper;

import com.soholighting.sohoTeam8.model.SpecialThanks;
import com.soholighting.sohoTeam8.model.Sponsors;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface SpecialThanksMapper {
    List<SpecialThanks> findAllSpecialThanks();
    List<SpecialThanks> findAllBySpecialThanksName(@Param("name") String name);
    SpecialThanks selectSpecialThanksById(int id);
    void insertSpecialThanks(@Param("SpecialThanks") SpecialThanks SpecialThanks);
    Sponsors removethanksById(int id);
}
