package com.soholighting.sohoTeam8.repository.impl;

import com.soholighting.sohoTeam8.exception.SohoLightingException;
import com.soholighting.sohoTeam8.model.User;
import com.soholighting.sohoTeam8.repository.UserRegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Enoch Ribin 23089855
 */

@Repository
public class UserRegistrationRepositoryImpl implements UserRegistrationRepository {
    private JdbcTemplate jdbcTemplate;
    private RowMapper<User> userRowMapper;

    @Autowired
    public UserRegistrationRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        setUserRowMapper();
    }


    private void setUserRowMapper() {
        userRowMapper = (rs, i) -> new User(
                rs.getString("first_name"),
                rs.getString("last_name"),
                rs.getString("email"),
                rs.getString("birthday_date")
        );
    }

    @Override
    public List<User> findAllUser() {
        String sqlQuery = "SELECT * FROM User";
        return jdbcTemplate.query(sqlQuery, userRowMapper);
    }

    @Override
    public User findUserById(Long id) {
        String sqlQuery = "SELECT * FROM User WHERE User_id = ?";
        return jdbcTemplate.queryForObject(sqlQuery, userRowMapper, id);
    }

    @Override
    public int saveUser(User user) {
        String sqlQuery = "INSERT INTO User (first_name, last_name, email, birthday_date) VALUES (?,?,?,?)";
        return jdbcTemplate.update(sqlQuery,
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getBirthday());
    }

    @Override
    public int updateUser(User user, Long id) {
        String sqlQuery = "UPDATE User SET first_name = ?, last_name = ?,birthday_date = ? WHERE User_id = ?";
        return jdbcTemplate.update(sqlQuery,
                user.getFirstName(),
                user.getLastName(),
                user.getBirthday(), id);
    }

    @Override
    public int deleteUserById(Long id) {
        String sqlQuery = "DELETE FROM users WHERE User_id = ?";
        return jdbcTemplate.update(sqlQuery, id);
    }

    @Override
    public long findLastInsertedUserID() throws SohoLightingException {
        try{
            String sqlQuery = "SELECT LAST_INSERT_ID()";
            return jdbcTemplate.queryForObject(sqlQuery, Long.class);
        }catch(NullPointerException e){
            throw new SohoLightingException("Data Not Found ");
        }
    }

    @Override
    public int savePhoneNumber(User user, Long id) {
        String sqlQuery = "INSERT INTO PhoneNumber (User_id, CountryCode, PhoneNumber) VALUES (?, '+44', ?)";
        return jdbcTemplate.update(sqlQuery, id, user.getPhoneNumber());
    }

    @Override
    public int updatePhoneNumber(User user, Long id) {
        String sqlQuery = "UPDATE PhoneNumber SET PhoneNumber = ? WHERE User_id = ?";
        return jdbcTemplate.update(sqlQuery, user.getPhoneNumber(), id);
    }

    @Override
    public int deletePhoneNumber(Long id) {
        String sqlQuery = "DELETE FROM PhoneNumber WHERE User_id = ?";
        return jdbcTemplate.update(sqlQuery, id);
    }

    @Override
    public int saveUserLoginDetails(User user, Long id) {
        String sqlQuery = "INSERT INTO userlogin (user_id, username, password) VALUES (?,?,?)";
        return jdbcTemplate.update(sqlQuery, id, user.getUserName(), user.getPassword());
    }

    @Override
    public int updateUserLoginDetails(User user, Long id) {
        String sqlQuery = "UPDATE userlogin SET username = ?, password = ? WHERE user_id = ?";
        return jdbcTemplate.update(sqlQuery, user.getUserName(), user.getPassword(), id);
    }

    @Override
    public int deleteUserLoginDetails(Long id) {
        String sqlQuery = "DELETE FROM userlogin WHERE user_id = ?";
        return jdbcTemplate.update(sqlQuery, id);
    }

    @Override
    public long findUserID(User user) {
        String sqlQuery = "SELECT User_id FROM User WHERE first_name = ? AND last_name = ? AND email = ? AND birthday_date = ?";
        return jdbcTemplate.queryForObject(sqlQuery,
                new Object[]{user.getFirstName(),
                        user.getLastName(),
                        user.getEmail(),
                        user.getBirthday()},
                Long.class);
    }

}
