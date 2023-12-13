package com.soholighting.sohoTeam8.repository.impl;

import com.soholighting.sohoTeam8.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

/**
 * @author Enoch Ribin 23089855
 */
@ExtendWith(MockitoExtension.class)
class UserRegistrationRepositoryImplTest {
    @Mock
    private JdbcTemplate jdbcTemplate;

    private User user;
    @InjectMocks
    private UserRegistrationRepositoryImpl userRegistrationRepository;

    @BeforeEach
    void setUp() {
        user = new User("Enoch", "Ribin", "enoch.ribin@gmail.com", "enochribin", "password1", "9999999999", "1998-05-15");
        userRegistrationRepository = new UserRegistrationRepositoryImpl(jdbcTemplate);
    }

    @Test
    void saveUser() {
        User user = new User();
        when(jdbcTemplate.update(anyString(), eq(user.getFirstName()),
                eq(user.getLastName()),
                eq(user.getEmail()),
                eq(user.getBirthday()))).thenReturn(1);
        int result = userRegistrationRepository.saveUser(user);
        assertEquals(1, result);
    }

    @Test
    void updateUser() {
        Mockito.lenient().when(jdbcTemplate.update(eq("UPDATE User SET first_name = ?, last_name = ?,birthday_date = ? WHERE User_id = ?"), eq(user.getFirstName()),
                eq(user.getLastName()),
                eq(user.getBirthday()), eq(1L))).thenReturn(1);
        int result = userRegistrationRepository.updateUser(user, 1L);
        assertEquals(1, result);
    }

    @Test
    void deleteUser() {
        long userId = 1;
        when(jdbcTemplate.update(anyString(), eq(1L))).thenReturn(1);
        int result = userRegistrationRepository.deleteUserById(userId);
        assertEquals(1, result);
    }

    @Test
    void findUserById() {
        when(jdbcTemplate.queryForObject(eq("SELECT * FROM User WHERE User_id = ?"), any(RowMapper.class), eq(1L))).thenReturn(user);
        User result = userRegistrationRepository.findUserById(1L);
        assertEquals(user, result);
    }

    @Test
    void saveUserWithException() throws Exception {
        Mockito.lenient().when(jdbcTemplate.update(eq("INSERT INTO User (first_name, last_name, email, birthday_date) VALUES (?,?,?,?)"), eq(user.getFirstName()),
                eq(user.getLastName()),
                eq(user.getEmail()),
                eq(user.getBirthday()))).thenThrow(new DataAccessException("Database Error") {
        });
        assertThrows(DataAccessException.class, () -> userRegistrationRepository.saveUser(user));
    }

    @Test
    void updateUserNotFound() {
        Mockito.lenient().when(jdbcTemplate.update(eq("UPDATE User SET first_name = ?, last_name = ?,birthday_date = ? WHERE User_id = ?"), eq(user.getFirstName()),
                eq(user.getLastName()),
                eq(user.getEmail()),
                eq(user.getBirthday()), eq(1L))).thenReturn(0);
        int result = userRegistrationRepository.updateUser(user, 1L);
        assertEquals(0, result);
    }

    @Test
    void deleteUserNotExisting() {
        when(jdbcTemplate.update(anyString(), eq(1L))).thenReturn(0);
        int result = userRegistrationRepository.deleteUserById(1L);
        assertEquals(0, result);
    }

    @Test
    void findUserByIdReturnsNull() {
        long userId = 1;
        when(jdbcTemplate.queryForObject(eq("SELECT * FROM User WHERE User_id = ?"), any(RowMapper.class), eq(1L))).thenReturn(null);
        User result = userRegistrationRepository.findUserById(userId);
        assertNull(result);
    }


    @Test
    void findAllUsers() {
        List<User> expectedUsers = Arrays.asList(new User(), new User());
        when(jdbcTemplate.query(anyString(), any(RowMapper.class))).thenReturn(expectedUsers);
        List<User> result = userRegistrationRepository.findAllUser();
        assertEquals(expectedUsers, result);
    }


}