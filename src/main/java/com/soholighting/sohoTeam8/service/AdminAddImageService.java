package com.soholighting.sohoTeam8.service;

import com.soholighting.sohoTeam8.exception.SohoLightingException;
import com.soholighting.sohoTeam8.mapper.KidsImageMapper;
import com.soholighting.sohoTeam8.model.KidsImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

/**
 * @author Enoch Ribin 23089855
 */
@Service
public class AdminAddImageService {

    @Autowired
    private KidsImageMapper kidsImageMapper;

    public void addImageDetails(KidsImage kidsImage) throws SohoLightingException {
        try {
            kidsImageMapper.insertKidsImage(kidsImage);
        } catch (Exception e) {
            throw new SohoLightingException("Database error");
        }

    }
}
