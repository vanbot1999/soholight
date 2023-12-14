package com.soholighting.sohoTeam8;
import com.soholighting.sohoTeam8.model.AdminAccount;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AdminLoginTest {

    @Test
    public void testAdminAccountSettersAndGetters() {
        // Setup - create an instance of AdminAccount and set some values
        AdminAccount admin = new AdminAccount();
        admin.setUserId(1);
        admin.setUsername("Doinb");
        admin.setPassword("3321");


        assertEquals(1, admin.getUserId());
        assertEquals("Doinb", admin.getUsername());
        assertEquals("3321", admin.getPassword());
    }


}

