package com.soholighting.sohoTeam8.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.soholighting.sohoTeam8.mapper.KidsImageMapper;
import com.soholighting.sohoTeam8.model.AdminAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
@Service
public class AdminAccountService {
    @Autowired
    private KidsImageMapper kidsImageMapper;
    public AdminAccount login(String username, String password) {

        return kidsImageMapper.getUserLogin(username, password);
    }
}
