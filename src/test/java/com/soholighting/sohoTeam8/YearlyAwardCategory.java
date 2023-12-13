package com.soholighting.sohoTeam8;

import com.soholighting.sohoTeam8.model.Award;
import com.soholighting.sohoTeam8.model.YearlyAwardCategory;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class YearlyAwardCategoryTest {

    @Test
    void testYearlyAwardCategoryGettersAndSetters() {
        List<Award> awards = new ArrayList<>();
        awards.add(new Award("1", "Name", "Year 2023", "Thank you!", "image.jpg"));

        YearlyAwardCategory category = new YearlyAwardCategory("Best Design", awards);

        assertEquals("Best Design", category.getCategoryTitle());
        assertEquals(1, category.getAwards().size());
    }
}

