package com.soholighting.sohoTeam8.repository;

import com.soholighting.sohoTeam8.exception.SohoLightingException;
import com.soholighting.sohoTeam8.model.User;

import java.util.List;

/**
 * @author Enoch Ribin 23089855
 */
public interface UserRegistrationRepository {
    //User DB
    List<User> findAllUser();
    User findUserById(Long id);
    int saveUser(User user);
    int updateUser(User user, Long id);
    int deleteUserById(Long id);
    long findLastInsertedUserID() throws SohoLightingException;
    long findUserID(User user);

    //PhoneNumber DB
    int savePhoneNumber(User user, Long id);
    int updatePhoneNumber(User user, Long id);
    int deletePhoneNumber(Long id);

    //UserLogin DB
    int saveUserLoginDetails(User user, Long id);
    int updateUserLoginDetails(User user, Long id);
    int deleteUserLoginDetails(Long id);

}
