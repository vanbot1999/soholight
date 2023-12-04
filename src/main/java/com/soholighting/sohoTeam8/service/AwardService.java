package com.soholighting.sohoTeam8.service;

import com.soholighting.sohoTeam8.model.Award;
import com.soholighting.sohoTeam8.model.YearlyAwardCategory;
import com.soholighting.sohoTeam8.model.YearlyAwards;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AwardService {

    // Method to get all yearly awards data
    public List<YearlyAwards> getAllYearlyAwards() {
        // List to hold awards for the category "Best Celebration of Color and Light" for the year 2022
        List<Award> awardsColorAndLight2022 = new ArrayList<>();
        // Adding Award details to the list
        awardsColorAndLight2022.add(new Award("1", "Tom", "Year 3",
                "I saw some hanging baskets on our inspriation walk in the summer time. I wanted to adapt this to be more Christmassy so decided to make it a holly hanging basket! I'd feel very happy and relieved to be a winner!",
                "Tom_light.jpg"));
        awardsColorAndLight2022.add(new Award("2", "Ivo", "Reception",
                "I drew a bike because I like bicycles. I added a Christmas hat and snowflakes. I got a bike for my birthday, it would make a good gift at Christmas. I would love it to be a Christmas light!",
                "ivo_light.jpg"));
        // List to hold awards for the category "Best Representation of Soho" for the year 2022
        List<Award> awardsSohoRepresentation2022 = new ArrayList<>();
        // Adding Award details to the list
        awardsSohoRepresentation2022.add(new Award("3", "Hikali", "Year 5",
                "When we were taking pictures I saw a croissant shop and this inspired my design. I made it colourful like the rainbow on our school logo which also reminds me of Soho. I added the holly to give it a touch of Christmas!",
                "hikali_light.jpg"));
        awardsSohoRepresentation2022.add(new Award("4", "Coco", "Year 6",
                "",
                "coco_light.jpg"));
        // List to hold awards for the category "Best Response to the Design Brief" for the year 2022
        List<Award> awardsDesignBrief2022 = new ArrayList<>();
        // Adding Award details to the list
        awardsDesignBrief2022.add(new Award("5", "Daniel", "Year 4",
                "When we were going outside and taking pictures, ... I noticed that there were some local places with logos that I liked. I combined a Chinese lucky cat with a pub logo to create my unique design. | added a Santa hat to make it more Christmassy. I would be very surprised and excited to win and have my work displayed on the street.",
                "coco_light.jpg"));
        awardsDesignBrief2022.add(new Award("6", "Maria", "Year 5",
                "I wanted to pick something of inspiration from inside our school. Crawford is our school dog who was in our class last year and helps for children to feel calm. It would be great to embrace him and have him brighten up the streets of Soho. | would feel very excited to have one of my designs up in public for everyone to see.",
                "maria_light.jpg"));
        // Creating category objects for the year 2022 with the respective awards lists
        YearlyAwardCategory colorAndLightCategory2022 = new YearlyAwardCategory("Best Celebration of Color and Light", awardsColorAndLight2022);
        YearlyAwardCategory sohoRepresentationCategory2022 = new YearlyAwardCategory("Best Representation of Soho", awardsSohoRepresentation2022);
        YearlyAwardCategory designBriefCategory2022 = new YearlyAwardCategory("Best Response to the Design Brief", awardsDesignBrief2022);

        // List to hold all categories for the year 2022
        List<YearlyAwardCategory> categories2022 = new ArrayList<>();
        categories2022.add(colorAndLightCategory2022);
        categories2022.add(sohoRepresentationCategory2022);
        categories2022.add(designBriefCategory2022);

        // Creating the YearlyAwards object for the year 2022
        YearlyAwards yearlyAwards2022 = new YearlyAwards("2022", categories2022);

        // Final list to hold all the yearly awards
        List<YearlyAwards> allYearlyAwards = new ArrayList<>();
        allYearlyAwards.add(yearlyAwards2022);

        // Return the list of all yearly awards
        return allYearlyAwards;
    }
}
