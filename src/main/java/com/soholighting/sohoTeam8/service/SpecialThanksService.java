package com.soholighting.sohoTeam8.service;

import com.soholighting.sohoTeam8.mapper.SpecialThanksMapper;
import com.soholighting.sohoTeam8.model.SpecialThanks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class SpecialThanksService {
    @Autowired
    private SpecialThanksMapper specialThanksMapper;
    public List<SpecialThanks> findAllSpecialThanks() {
        return specialThanksMapper.findAllSpecialThanks();
    }

    public List<SpecialThanks> getAllSpecialThanks() {
        List<SpecialThanks> specialThanksList = specialThanksMapper.findAllSpecialThanks();
        Collections.shuffle(specialThanksList);
        return specialThanksList;
    }

    public List<SpecialThanks> getSpecialThanksByName(String name) {
        return specialThanksMapper.findAllBySpecialThanksName(name);
    }
    public SpecialThanks getSpecialThanksById(int id) {
        return specialThanksMapper.selectSpecialThanksById(id);
    }

    public void insertSpecialThanks(SpecialThanks specialThanks) {
        specialThanksMapper.insertSpecialThanks(specialThanks);
    }

}
