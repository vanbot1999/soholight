package com.soholighting.sohoTeam8.cxService;


import com.soholighting.sohoTeam8.cxEnity.KidsImage;
import com.soholighting.sohoTeam8.exception.SohoLightingException;
import com.soholighting.sohoTeam8.cxMapper.KidsImageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author EnochRibin 23089855
 */
@Service
public class KidsPaintingsService {

    @Autowired
    private KidsImageMapper kidsImageMapper;

    public List<KidsImage> getAllPaintings() throws SohoLightingException {
        if (kidsImageMapper.findAll().isEmpty())
            throw new SohoLightingException("No Paintings Found");
        else
            return kidsImageMapper.findAll();

    }

    public List<KidsImage> getPaintingsBasedOnYear(String year) throws SohoLightingException {
        if (kidsImageMapper.findAllByYear(year).isEmpty())
            throw new SohoLightingException("No Paintings Found for this year");
        else
            return kidsImageMapper.findAllByYear(year);
    }
}

