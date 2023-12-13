package com.soholighting.sohoTeam8;

import com.soholighting.sohoTeam8.model.KidsImage;
import com.soholighting.sohoTeam8.service.KidsImageService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MainPageControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private KidsImageService kidsImageService;


    private KidsImage image1, image2;

    @BeforeEach
    public void setup() {

        image1 = new KidsImage();
        image2 = new KidsImage();

        given(kidsImageService.getRandomKidsImages()).willReturn(Arrays.asList(image1, image2));
        given(kidsImageService.findAll()).willReturn(Arrays.asList(image1, image2));
        given(kidsImageService.getRandomKidsImagesByYear(anyString())).willReturn(Arrays.asList(image1));
        given(kidsImageService.getImageById(anyInt())).willReturn(image1);
    }

    @Test
    public void testGetRandomKidsImages() throws Exception {
        mockMvc.perform(get("/random-kids"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(2)));
    }


    @Test
    public void testHome() throws Exception {
        mockMvc.perform(get("/home"))
                .andExpect(status().isOk())
                .andExpect(view().name("home"))
                .andExpect(model().attributeExists("kids"))
                .andExpect(model().attribute("kids", hasSize(2)));
    }

    @Test
    public void testGetRandomKidsImagesByYear() throws Exception {
        mockMvc.perform(get("/random-kids/{year}", "2021"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(1)));
    }

    @Test
    public void testShowImageDetails() throws Exception {
        mockMvc.perform(get("/workpage").param("imageId", "1"))
                .andExpect(status().isOk())
                .andExpect(view().name("workpage"))
                .andExpect(model().attributeExists("kidsImage"));
    }


}