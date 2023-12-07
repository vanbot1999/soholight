package com.soholighting.sohoTeam8.test;



import com.soholighting.sohoTeam8.model.AdminAccount;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;



class AdminAccountTest {

    @Test
    void testUserId() {
        AdminAccount admin = new AdminAccount();
        String expectedUserId = "1";
        admin.setUserId(expectedUserId);
        String actualUserId = admin.getUserId();
        Assertions.assertEquals(expectedUserId, actualUserId, "The userId is not set correctly.");
    }

    @Test
    void testPassword() {
        AdminAccount admin = new AdminAccount();
        String expectedPassword = "123";
        admin.setPassword(expectedPassword);
        String actualPassword = admin.getPassword();
        Assertions.assertEquals(expectedPassword, actualPassword, "The password is not set correctly.");
    }
}
