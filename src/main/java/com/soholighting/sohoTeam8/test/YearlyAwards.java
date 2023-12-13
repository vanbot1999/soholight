package com.soholighting.sohoTeam8.test;

import com.soholighting.sohoTeam8.model.YearlyAwardCategory;
import com.soholighting.sohoTeam8.model.YearlyAwards;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class YearlyAwardsTest {

    @Test
    void testYearlyAwardsGettersAndSetters() {
        List<YearlyAwardCategory> categories = new ArrayList<>();
        categories.add(new YearlyAwardCategory("Best Design", new ArrayList<>()));

        YearlyAwards awards = new YearlyAwards("2023", categories);

        assertEquals("2023", awards.getYear());
        assertEquals(1, awards.getAwardCategories().size());
    }
}
