package com.soholighting.sohoTeam8.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.soholighting.sohoTeam8.model.AdminAccount;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
@Service
public class AdminAccountService {
    public List<AdminAccount> readUsersFromJson() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return Arrays.asList(objectMapper.readValue(new ClassPathResource("LoginJson.json").getFile(), AdminAccount[].class));

    }
}
