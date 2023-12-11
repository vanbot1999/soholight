package com.soholighting.sohoTeam8.test;

import com.soholighting.sohoTeam8.model.Sponsors;
import org.testng.annotations.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SponsorsTest {

    @Test
    public void testGetName() {
        // Create a new instance of Sponsors
        Sponsors sponsors = new Sponsors(1, "Sponsor 1", "https://example.com", "logo1");

        // Verify the name is retrieved correctly
        assertEquals("Sponsor 1", sponsors.getName());
    }

    @Test
    public void testSetName() {
        // Create a new instance of Sponsors
        Sponsors sponsors = new Sponsors(1, "Sponsor 1", "https://example.com", "logo1");

        // Set a new name and verify if it is updated correctly
        sponsors.setName("Sponsor 2");
        assertEquals("Sponsor 2", sponsors.getName());
    }

    @Test
    public void testGetURL() {
        // Create a new instance of Sponsors
        Sponsors sponsors = new Sponsors(1, "Sponsor 1", "https://example.com", "logo1");

        // Verify the URL is retrieved correctly
        assertEquals("https://example.com", sponsors.getURL());
    }

    @Test
    public void testSetURL() {
        // Create a new instance of Sponsors
        Sponsors sponsors = new Sponsors(1, "Sponsor 1", "https://example.com", "logo1");

        // Set a new URL and verify if it is updated correctly
        sponsors.setURL("https://example.org");
        assertEquals("https://example.org", sponsors.getURL());
    }

    @Test
    public void testGetSponsor_logo() {
        // Create a new instance of Sponsors
        Sponsors sponsors = new Sponsors(1, "Sponsor 1", "https://example.com", "logo1");

        // Verify the sponsor_logo is retrieved correctly
        assertEquals("logo1", sponsors.getSponsor_logo());
    }

    @Test
    public void testSetSponsor_logo() {
        // Create a new instance of Sponsors
        Sponsors sponsors = new Sponsors(1, "Sponsor 1", "https://example.com", "logo1");

        // Set a new sponsor_logo and verify if it is updated correctly
        sponsors.setSponsor_logo("logo2");
        assertEquals("logo2", sponsors.getSponsor_logo());
    }

    @Test
    public void testGetSponsor_id() {
        // Create a new instance of Sponsors
        Sponsors sponsors = new Sponsors(1, "Sponsor 1", "https://example.com", "logo1");

        // Verify the sponsor_id is retrieved correctly
        assertEquals(1, sponsors.getSponsor_id());
    }

    @Test
    public void testSetSponsor_id() {
        // Create a new instance of Sponsors
        Sponsors sponsors = new Sponsors(1, "Sponsor 1", "https://example.com", "logo1");

        // Set a new sponsor_id and verify if it is updated correctly
        sponsors.setSponsor_id(2);
        assertEquals(2, sponsors.getSponsor_id());
    }
}
