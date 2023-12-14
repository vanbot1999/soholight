package com.soholighting.sohoTeam8.service;


import com.soholighting.sohoTeam8.exception.SohoLightingException;
import com.soholighting.sohoTeam8.model.User;
import com.soholighting.sohoTeam8.repository.UserRegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.BiFunction;

/**
 * @author Enoch Ribin 23089855
 */
@Service
public class UserRegistrationService {

    private final UserRegistrationRepository userRegistrationRepository;

    @Autowired
    public UserRegistrationService(UserRegistrationRepository userRegistrationRepository) {
        this.userRegistrationRepository = userRegistrationRepository;
    }

    public List<User> findAll() {
        return userRegistrationRepository.findAllUser();
    }

    public void insertUser(User user) throws SohoLightingException {
        validateOperation(userRegistrationRepository.saveUser(user), "User not saved in DB");

        Long userId = getValidUserId(userRegistrationRepository.findLastInsertedUserID(), "Failed to retrieve user ID after saving");

        validateOperation(userRegistrationRepository.savePhoneNumber(user, userId), "Phone number not stored in DB");
        validateOperation(userRegistrationRepository.saveUserLoginDetails(user, userId), "User Login not stored in DB");
    }

    public void updateUser(User user) throws SohoLightingException {
        Long userId = userRegistrationRepository.findUserID(user);

        if (userId == null || userId == 0) {
            insertUser(user);
            return;
        }

        updateDetail(user, userId, userRegistrationRepository::updateUser, "User not updated");
        updateDetail(user, userId, userRegistrationRepository::updatePhoneNumber, "Phone number not updated");
        updateDetail(user, userId, userRegistrationRepository::updateUserLoginDetails, "User Login not updated");
    }

    public void deleteUser(User user) throws SohoLightingException {
        Long userId = getValidUserId(userRegistrationRepository.findUserID(user), "User not found");

        userRegistrationRepository.deletePhoneNumber(userId);
        userRegistrationRepository.deleteUserLoginDetails(userId);
        userRegistrationRepository.deleteUserById(userId);
    }

    private void validateOperation(int result, String errorMessage) throws SohoLightingException {
        if (result != 1) {
            throw new SohoLightingException(errorMessage);
        }
    }

    private Long getValidUserId(Long userId, String errorMessage) throws SohoLightingException {
        if (userId == null || userId == 0) {
            throw new SohoLightingException(errorMessage);
        }
        return userId;
    }

    private void updateDetail(User user, Long userId, BiFunction<User, Long, Integer> updateFunction, String errorMessage) throws SohoLightingException {
        validateOperation(updateFunction.apply(user, userId), errorMessage);
    }

    public List<User> usersList() {
        return findAll();
    }
}
