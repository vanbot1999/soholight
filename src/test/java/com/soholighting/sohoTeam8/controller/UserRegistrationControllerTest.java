package com.soholighting.sohoTeam8.controller;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.soholighting.sohoTeam8.exception.SohoLightingException;
import com.soholighting.sohoTeam8.model.User;
import com.soholighting.sohoTeam8.service.UserRegistrationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/**
 * @author Enoch Ribin 23089855
 */
@ExtendWith(MockitoExtension.class)
public class UserRegistrationControllerTest {
    private MockMvc mockMvc;

    @Mock
    private UserRegistrationService userRegistrationService;

    @InjectMocks
    private UserRegistrationController userRegistrationController;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(userRegistrationController).build();
    }

    @Test
    public void testRegisterUserForm() throws Exception {
        mockMvc.perform(get("/register"))
                .andExpect(status().isOk())
                .andExpect(view().name("registerUser"));
    }

    @Test
    public void testRegisterUserSuccess() throws Exception {
        User user = new User("Enoch", "Ribin", "enoch.ribin@gmail.com", "1998-05-15");
        mockMvc.perform(post("/register")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .flashAttr("user", user))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/Adminlogin"));

        verify(userRegistrationService).insertUser(any(User.class));
    }

    @Test
    public void testRegisterUserFailure() throws Exception {
        User user = new User("Enoch", "Ribin", "enoch.ribin@gmail.com", "1998-05-15");
        doThrow(new SohoLightingException("Registration failed")).when(userRegistrationService).insertUser(any(User.class));

        mockMvc.perform(post("/register")
                        .flashAttr("user", user))
                .andExpect(status().isFound())
                .andExpect(view().name("redirect:/register"));
    }

    @Test
    public void testDeleteUser() throws Exception {
        User user = new User("Enoch", "Ribin", "enoch.ribin@gmail.com", "1998-05-15");
        mockMvc.perform(delete("/deleteUser")
                        .flashAttr("user", user))
                .andExpect(status().isFound())
                .andExpect(view().name("redirect:/admin_userList"));
    }

    @Test
    public void testUpdateUser() throws Exception {
        User user = new User("Enoch", "Ribin", "enoch.ribin@gmail.com", "1998-05-16");
        mockMvc.perform(put("/updateUser")
                .flashAttr("user", user)).andExpect(status().isFound());
    }

    @Test
    public void testGetUserList() throws Exception {
        mockMvc.perform(get("/admin_userList"))
                .andExpect(status().isOk())
                .andExpect(view().name("userList"));

        verify(userRegistrationService).findAll();
    }

}
