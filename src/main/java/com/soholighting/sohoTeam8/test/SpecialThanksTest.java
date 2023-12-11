package com.soholighting.sohoTeam8.test;

import com.soholighting.sohoTeam8.model.SpecialThanks;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SpecialThanksTest {

    @Test
    public void testGetSetName() {
        SpecialThanks specialThanks = new SpecialThanks(1, "John Doe", "https://example.com", "logo.png");
        assertEquals("John Doe", specialThanks.getName());
        assertEquals("https://example.com", specialThanks.getURL());
        assertEquals("logo.png", specialThanks.getThanks_logo());
        assertEquals(1, specialThanks.getThanks_id());

        specialThanks.setName("Jane Smith");
        specialThanks.setURL("https://example.org");
        specialThanks.setThanks_logo("new_logo.png");
        specialThanks.setThanks_id(2);

        assertEquals("Jane Smith", specialThanks.getName());
        assertEquals("https://example.org", specialThanks.getURL());
        assertEquals("new_logo.png", specialThanks.getThanks_logo());
        assertEquals(2, specialThanks.getThanks_id());
    }
}
