package com.soholighting.sohoTeam8.service;

import com.soholighting.sohoTeam8.exception.SohoLightingException;
import com.soholighting.sohoTeam8.model.User;
import com.soholighting.sohoTeam8.repository.UserRegistrationRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * @author Enoch Ribin 23089855
 */
@ExtendWith(MockitoExtension.class)
class UserRegistrationServiceTest {

    @Mock
    private UserRegistrationRepository userRegistrationRepository;

    @InjectMocks
    private UserRegistrationService userRegistrationService;

    private User user;

    @BeforeEach
    public void setUp() {
        user = new User("Enoch", "Ribin", "enoch.ribin@gmail.com", "enochribin", "password1", "9999999999", "1998-05-15");
    }

    @Test
    public void testInsertUser() throws SohoLightingException {
        // Arrange: Define the behavior of the mock before the action
        when(userRegistrationRepository.saveUser(user)).thenReturn(1);
        when(userRegistrationRepository.findLastInsertedUserID()).thenReturn(1L);
        when(userRegistrationRepository.savePhoneNumber(user, 1L)).thenReturn(1);
        when(userRegistrationRepository.saveUserLoginDetails(user, 1L)).thenReturn(1);

        // Act: Perform the action under test
        userRegistrationService.insertUser(user);

        // Assert: Verify that the expected interactions with the mock occurred
        verify(userRegistrationRepository).saveUser(user);
        verify(userRegistrationRepository).savePhoneNumber(user, 1L);
        verify(userRegistrationRepository).saveUserLoginDetails(user, 1L);
    }


    @Test
    public void testUpdateUser() throws SohoLightingException {
        when(userRegistrationRepository.findUserID(user)).thenReturn(1L);
        when((userRegistrationRepository).updateUser(user, 1L)).thenReturn(1);
        when((userRegistrationRepository).updatePhoneNumber(user, 1L)).thenReturn(1);
        when((userRegistrationRepository).updateUserLoginDetails(user, 1L)).thenReturn(1);
        userRegistrationService.updateUser(user);
        verify(userRegistrationRepository).updateUser(user, 1L);
        verify(userRegistrationRepository).updatePhoneNumber(user, 1L);
        verify(userRegistrationRepository).updateUserLoginDetails(user, 1L);

    }

    @Test
    public void testDeleteUser() throws SohoLightingException {
        when(userRegistrationRepository.findUserID(user)).thenReturn(1L);
        userRegistrationService.deleteUser(user);
        verify(userRegistrationRepository).deletePhoneNumber(1L);
        verify(userRegistrationRepository).deleteUserLoginDetails(1L);
        verify(userRegistrationRepository).deleteUserById(1L);
    }

    @Test
    public void testFindAll() {
        userRegistrationService.findAll();
        verify(userRegistrationRepository).findAllUser();
    }
}