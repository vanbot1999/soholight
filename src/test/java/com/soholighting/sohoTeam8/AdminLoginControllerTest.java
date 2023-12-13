package com.soholighting.sohoTeam8;



import com.soholighting.sohoTeam8.controller.AdminLoginController;
import com.soholighting.sohoTeam8.model.AdminAccount;
import com.soholighting.sohoTeam8.service.AdminAccountService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(AdminLoginController.class)
public class AdminLoginControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AdminAccountService adminAccountService;

    @Test
    public void testLoginSuccess() throws Exception {

        String username = "Antonio";
        String password = "zcx233666";
        AdminAccount mockAdminAccount = new AdminAccount(); // Replace with actual AdminAccount class
        given(adminAccountService.login(username, password)).willReturn(mockAdminAccount);


        mockMvc.perform(post("/home")
                        .param("username", username)
                        .param("password", password))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/Admin"))
                .andExpect(cookie().exists("user"));
    }

    @Test
    public void testLoginFailure() throws Exception {
        // Arrange
        String username = "wrongUser";
        String password = "wrongPass";
        given(adminAccountService.login(username, password)).willReturn(null);

        // Act and Assert
        mockMvc.perform(post("/home")
                        .param("username", username)
                        .param("password", password))
                .andExpect(status().isOk())
                .andExpect(view().name("AdminLogin"))
                .andExpect(model().attribute("error", "Invalid username or password"));
    }

    @Test
    public void testLogout() throws Exception {
        // Act and Assert
        mockMvc.perform(post("/logout"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/Adminlogin"))
                .andExpect(cookie().doesNotExist("user"));
    }
}
