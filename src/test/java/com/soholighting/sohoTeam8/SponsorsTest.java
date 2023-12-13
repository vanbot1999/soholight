package com.soholighting.sohoTeam8;

import com.soholighting.sohoTeam8.model.Sponsors;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SponsorsTest {

    @Test
    public void testGetName() {
        Sponsors sponsors = new Sponsors(1, "Sponsor 1", "https://www.sponsor1.com", "logo1.png");
        String expected = "Sponsor 1";
        String actual = sponsors.getName();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testSetName() {
        Sponsors sponsors = new Sponsors(1, "Sponsor 1", "https://www.sponsor1.com", "logo1.png");
        String name = "Sponsor 2";
        sponsors.setName(name);
        String actual = sponsors.getName();
        Assertions.assertEquals(name, actual);
    }

    @Test
    public void testGetURL() {
        Sponsors sponsors = new Sponsors(1, "Sponsor 1", "https://www.sponsor1.com", "logo1.png");
        String expected = "https://www.sponsor1.com";
        String actual = sponsors.getURL();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testSetURL() {
        Sponsors sponsors = new Sponsors(1, "Sponsor 1", "https://www.sponsor1.com", "logo1.png");
        String url = "https://www.sponsor2.com";
        sponsors.setURL(url);
        String actual = sponsors.getURL();
        Assertions.assertEquals(url, actual);
    }

    @Test
    public void testGetSponsor_logo() {
        Sponsors sponsors = new Sponsors(1, "Sponsor 1", "https://www.sponsor1.com", "logo1.png");
        String expected = "logo1.png";
        String actual = sponsors.getSponsor_logo();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testSetSponsor_logo() {
        Sponsors sponsors = new Sponsors(1, "Sponsor 1", "https://www.sponsor1.com", "logo1.png");
        String logo = "logo2.png";
        sponsors.setSponsor_logo(logo);
        String actual = sponsors.getSponsor_logo();
        Assertions.assertEquals(logo, actual);
    }

    @Test
    public void testGetSponsor_id() {
        Sponsors sponsors = new Sponsors(1, "Sponsor 1", "https://www.sponsor1.com", "logo1.png");
        int expected = 1;
        int actual = sponsors.getSponsor_id();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testSetSponsor_id() {
        Sponsors sponsors = new Sponsors();
        int sponsorId = 2;
        sponsors.setSponsor_id(sponsorId);
        int actual = sponsors.getSponsor_id();
        Assertions.assertEquals(sponsorId, actual);
    }
}
