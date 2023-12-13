package com.soholighting.sohoTeam8.controller;

import com.soholighting.sohoTeam8.controller.SponsorController;
import com.soholighting.sohoTeam8.model.SpecialThanks;
import com.soholighting.sohoTeam8.model.Sponsors;
import com.soholighting.sohoTeam8.service.SpecialThanksService;
import com.soholighting.sohoTeam8.service.SponsorsService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

@SpringBootTest
@AutoConfigureMockMvc
class SponsorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private SponsorsService sponsorsService;

    @Mock
    private SpecialThanksService specialThanksService;

    @InjectMocks
    private SponsorController sponsorController;

    @Test
    void testShowSponsors() throws Exception {
        // Mock sponsors data
        List<Sponsors> sponsors = new ArrayList<>();
        sponsors.add(new Sponsors(1, "Sponsor1", "http://sponsor1.com", "logo1.png"));
        sponsors.add(new Sponsors(2, "Sponsor2", "http://sponsor2.com", "logo2.png"));

        // Mock specialThanks data
        List<SpecialThanks> specialThanks = new ArrayList<>();
        specialThanks.add(new SpecialThanks(1, "Sponsor1", "http://sponsor1.com", "logo1.png"));
        specialThanks.add(new SpecialThanks(1, "Sponsor1", "http://sponsor1.com", "logo1.png"));

        // Mock the service methods
        when(sponsorsService.getAllSponsors()).thenReturn(sponsors);
        when(specialThanksService.getAllSpecialThanks()).thenReturn(specialThanks);

        // Perform the request and assert the expected results
        mockMvc.perform(MockMvcRequestBuilders.get("/sponsors"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("sponsors"))
                .andExpect(model().attributeExists("sponsors", "specialThanks"));
    }


}
