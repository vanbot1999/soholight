package com.soholighting.sohoTeam8.mapper;
import com.soholighting.sohoTeam8.model.Sponsors;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface SponsorMapper {
    List<Sponsors> findAllSponsors();
    List<Sponsors> findAllBySponsorsName(@Param("name") String name);
    Sponsors selectSponsorById(int id);
    void insertSponsor(@Param("Sponsors") Sponsors sponsors);
    Sponsors removeSponsorById(int id);

}
