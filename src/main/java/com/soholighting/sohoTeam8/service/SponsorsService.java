package com.soholighting.sohoTeam8.service;

import com.soholighting.sohoTeam8.mapper.SponsorMapper;
import com.soholighting.sohoTeam8.model.KidsImage;
import com.soholighting.sohoTeam8.model.Sponsors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class SponsorsService {
    @Autowired
    private SponsorMapper SponsorMapper;
   public List<Sponsors> findALL(){
       return SponsorMapper.findAll();
   }
    public List<Sponsors> getAllSponsors() {
        List<Sponsors> sponsors = SponsorMapper.findAll();
        Collections.shuffle(sponsors);
        return sponsors;
    }
public List<Sponsors>getsponsorbyname(String name){
    List<Sponsors> allSponsorsByName = SponsorMapper.findAllByName(name);
    return allSponsorsByName;
}
public Sponsors getsponsorbyid(int id){
    Sponsors sponsorById = SponsorMapper.selectSponsorById(id);
    return sponsorById;
}

}
