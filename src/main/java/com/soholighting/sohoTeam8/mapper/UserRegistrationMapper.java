package com.soholighting.sohoTeam8.mapper;

import com.soholighting.sohoTeam8.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Enoch Ribin 23089855
 */
@Mapper
public interface UserRegistrationMapper {
    List<User> findAll();

    Integer findLastInsertedID();

    void insertUser(@Param("user") User user);

    void insertPhoneNumber(@Param("userId") int userId, @Param("phoneNumber") String phoneNumber);

    void insertUserLoginDetails(@Param("userId") int userId, @Param("user") User user);

}
