package com.soholighting.sohoTeam8.service;

import com.soholighting.sohoTeam8.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Enoch Ribin 23089855
 */
@Service
public class UserRegistrationService {
    public List<User> initUsers = new ArrayList<>();

    UserRegistrationService() {
        initUsers.add(new User("Ron", "Derik", "ronderik@gmail.com", "ronderik", "password", "1234567867"));
        initUsers.add(new User("John", "Jacob", "johnjacob@gmail.com", "johnjacob", "password", "999999999"));
        initUsers.add(new User("Jr", "Jones", "jrjones@gmail.com", "jrjones", "password", "888888888"));
        initUsers.add(new User("Lee", "Priest", "leepriest@gmail.com", "leepriest", "password", "4545666666"));
    }

    public void registerUser(User user) {
        initUsers.add(user);
        System.out.println("Success :" + user);
    }

}
