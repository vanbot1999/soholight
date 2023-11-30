package com.soholighting.sohoTeam8.service;

import com.soholighting.sohoTeam8.mapper.KidsImageMapper;
import com.soholighting.sohoTeam8.model.KidsImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Enoch Ribin 23089855
 */
@Service
public class AdminAddImageService {

    @Autowired
    private KidsImageMapper kidsImageMapper;

    public boolean addImageDetails(KidsImage kidsImage) {
        kidsImageMapper.insertKidsImage(kidsImage);
        return true;
    }
}
