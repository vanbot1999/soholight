package com.soholighting.sohoTeam8.test;

import com.soholighting.sohoTeam8.model.Award;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AwardTest {

    @Test
    void testAwardGettersAndSetters() {
        Award award = new Award();
        award.setId("1");
        award.setWinnerName("Name");
        award.setWinnerBackground("Year 2023");
        award.setWinnerSpeech("Thank you!");
        award.setWinnerImage("image.jpg");

        assertEquals("1", award.getId());
        assertEquals("Name", award.getWinnerName());
        assertEquals("Year 2023", award.getWinnerBackground());
        assertEquals("Thank you!", award.getWinnerSpeech());
        assertEquals("image.jpg", award.getWinnerImage());
    }
}
