package com.soholighting.sohoTeam8.service;

import com.soholighting.sohoTeam8.mapper.UserRegistrationMapper;
import com.soholighting.sohoTeam8.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Enoch Ribin 23089855
 */
@Service
public class UserRegistrationService {
    @Autowired
    private UserRegistrationMapper userRegistrationMapper;

    public List<User> findAll() {
        return userRegistrationMapper.findAll();
    }

    public void insertUser(User user) {
        userRegistrationMapper.insertUser(user);
        int userId = userRegistrationMapper.findLastInsertedID().intValue();;
        userRegistrationMapper.insertPhoneNumber(userId,user.getPhoneNumber());
        userRegistrationMapper.insertUserLoginDetails(userId, user);
    }

}
