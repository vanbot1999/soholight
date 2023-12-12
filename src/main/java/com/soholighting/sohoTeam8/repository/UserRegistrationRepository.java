package com.soholighting.sohoTeam8.repository;

import com.soholighting.sohoTeam8.model.User;

import java.util.List;

/**
 * @author Enoch Ribin 23089855
 */
public interface UserRegistrationRepository {
    List<User> findAllUser();

    User findUserById(Long id);

    int saveUser(User user);

    int updateUser(User user, Long id);

    int deleteUserById(Long id);

    long findLastInsertedUserID();

    long findUserID(User user);

    int savePhoneNumber(User user,Long id);

    int updatePhoneNumber(User user,Long id);

    int deletePhoneNumber(Long id);

    int saveUserLoginDetails(User user, Long id);

    int updateUserLoginDetails(User user, Long id);

    int deleteUserLoginDetails(Long id);

}
