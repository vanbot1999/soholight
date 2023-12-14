package com.soholighting.sohoTeam8.service;
import com.soholighting.sohoTeam8.mapper.SponsorMapper;
import com.soholighting.sohoTeam8.model.Sponsors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Collections;
import java.util.List;
@Service
public class SponsorsService {
    @Autowired
    private SponsorMapper SponsorMapper;
   public List<Sponsors> findALLSponsors(){
       return SponsorMapper.findAllSponsors();
   }
    public List<Sponsors> getAllSponsors() {
        List<Sponsors> sponsors = SponsorMapper.findAllSponsors();
        Collections.shuffle(sponsors);
        return sponsors;
    }
public List<Sponsors>getsponsorbyname(String name){
    List<Sponsors> allSponsorsByName = SponsorMapper.findAllBySponsorsName(name);
    return allSponsorsByName;
}
public Sponsors getsponsorbyid(int id){
    Sponsors sponsorById = SponsorMapper.selectSponsorById(id);
    return sponsorById;
}
    public void insertSponsor(Sponsors sponsors) {
        SponsorMapper.insertSponsor(sponsors);
    }
    public Sponsors removeSponsorById(int id) {
        Sponsors removeById = SponsorMapper.removeSponsorById(id);
        return removeById;
    }
}
