package com.soholighting.sohoTeam8.mapper;
import com.soholighting.sohoTeam8.model.Sponsors;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface SponsorMapper {
    List<Sponsors> findAllSponsors();//get sponsors
    List<Sponsors> findAllBySponsorsName(@Param("name") String name);
    Sponsors selectSponsorById(int id);//select sponsor by id
    void insertSponsor(@Param("Sponsors") Sponsors sponsors);//insert sponsor
    Sponsors removeSponsorById(int id);//remove sponsor by id

}
