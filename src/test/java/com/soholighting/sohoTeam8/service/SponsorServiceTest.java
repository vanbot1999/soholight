package com.soholighting.sohoTeam8.service;

import com.soholighting.sohoTeam8.mapper.SponsorMapper;
import com.soholighting.sohoTeam8.model.Sponsors;
import com.soholighting.sohoTeam8.service.SponsorsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

class SponsorsServiceTest {

    @Mock
    private SponsorMapper sponsorMapper;

    @InjectMocks
    private SponsorsService sponsorsService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllSponsors() {
        // Arrange
        List<Sponsors> mockSponsors = Arrays.asList(
                new Sponsors(1, "Sponsor1", "https://sponsor1.com", "logo1.jpg"),
                new Sponsors(2, "Sponsor2", "https://sponsor2.com", "logo2.jpg"),
                new Sponsors(3, "Sponsor3", "https://sponsor3.com", "logo3.jpg")
        );

        when(sponsorMapper.findAllSponsors()).thenReturn(mockSponsors);

        // Act
        List<Sponsors> result = sponsorsService.getAllSponsors();

        // Assert
        assertEquals(mockSponsors.size(), result.size());
        // Add more assertions based on your actual implementation and requirements
    }

    @Test
    void testGetSponsorByName() {
        // Arrange
        String sponsorName = "TestSponsor";
        List<Sponsors> mockSponsors = Arrays.asList(
                new Sponsors(1, sponsorName, "https://testsponsor.com", "testsponsor.jpg"),
                new Sponsors(2, sponsorName, "https://testsponsor2.com", "testsponsor2.jpg"),
                new Sponsors(3, sponsorName, "https://testsponsor3.com", "testsponsor3.jpg")
        );

        when(sponsorMapper.findAllBySponsorsName(sponsorName)).thenReturn(mockSponsors);

        // Act
        List<Sponsors> result = sponsorsService.getsponsorbyname(sponsorName);

        // Assert
        assertEquals(mockSponsors.size(), result.size());
        // Add more assertions based on your actual implementation and requirements
    }

    @Test
    void testGetSponsorById() {
        // Arrange
        int sponsorId = 1;
        Sponsors mockSponsor = new Sponsors(sponsorId, "TestSponsor", "https://testsponsor.com", "testsponsor.jpg");

        when(sponsorMapper.selectSponsorById(sponsorId)).thenReturn(mockSponsor);

        // Act
        Sponsors result = sponsorsService.getsponsorbyid(sponsorId);

        // Assert
        assertNotNull(result);
        assertEquals(mockSponsor.getSponsor_id(), result.getSponsor_id());
        assertEquals(mockSponsor.getName(), result.getName());
        assertEquals(mockSponsor.getURL(), result.getURL());
        assertEquals(mockSponsor.getSponsor_logo(), result.getSponsor_logo());
        // Add more assertions based on your actual implementation and requirements
    }

    @Test
    void testInsertSponsor() {
        // Arrange
        Sponsors newSponsor = new Sponsors(1, "NewSponsor", "https://newsponsor.com", "newsponsor.jpg");

        // Act
        sponsorsService.insertSponsor(newSponsor);

        // Assert
        verify(sponsorMapper, times(1)).insertSponsor(newSponsor);
        // Add more assertions based on your actual implementation and requirements
    }

    @Test
    void testRemoveSponsorById() {
        // Arrange
        int sponsorId = 1;
        Sponsors removedSponsor = new Sponsors(sponsorId, "RemovedSponsor", "https://removedsponsor.com", "removedsponsor.jpg");

        when(sponsorMapper.removeSponsorById(sponsorId)).thenReturn(removedSponsor);

        // Act
        Sponsors result = sponsorsService.removeSponsorById(sponsorId);

        // Assert
        assertNotNull(result);
        assertEquals(removedSponsor.getSponsor_id(), result.getSponsor_id());
        assertEquals(removedSponsor.getName(), result.getName());
        assertEquals(removedSponsor.getURL(), result.getURL());
        assertEquals(removedSponsor.getSponsor_logo(), result.getSponsor_logo());
    }


}
