package com.soholighting.sohoTeam8.service;


import com.soholighting.sohoTeam8.exception.SohoLightingException;
import com.soholighting.sohoTeam8.model.User;
import com.soholighting.sohoTeam8.repository.UserRegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Enoch Ribin 23089855
 */
@Service
public class UserRegistrationService {


    private UserRegistrationRepository userRegistrationRepository;

    @Autowired
    public UserRegistrationService(UserRegistrationRepository userRegistrationRepository) {
        this.userRegistrationRepository = userRegistrationRepository;
    }

    public List<User> findAll() {
        return userRegistrationRepository.findAllUser();
    }

    public void insertUser(User user) throws SohoLightingException {
        if (userRegistrationRepository.saveUser(user) != 1) {
            throw new SohoLightingException("User not saved in DB");
        }

        Long userId = userRegistrationRepository.findLastInsertedUserID();

        if (userRegistrationRepository.savePhoneNumber(user, userId) != 1 ||
                userRegistrationRepository.saveUserLoginDetails(user, userId) != 1) {
            throw new SohoLightingException("Data not stored in DB");
        }
    }

    public void updateUser(User user){
        Long user_id = userRegistrationRepository.findUserID(user);
        userRegistrationRepository.updateUser(user,user_id);
        userRegistrationRepository.updatePhoneNumber(user,user_id);
        userRegistrationRepository.updateUserLoginDetails(user,user_id);

    }

    public void deleteUser(User user){
        Long user_id = userRegistrationRepository.findUserID(user);
        userRegistrationRepository.deletePhoneNumber(user_id);
        userRegistrationRepository.deleteUserLoginDetails(user_id);
        userRegistrationRepository.deleteUserById(user_id);
    }

    public List<User> usersList(){
        return userRegistrationRepository.findAllUser();
    }
}
