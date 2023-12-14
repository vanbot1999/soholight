package com.soholighting.sohoTeam8.controller;

/* Importing necessary classes and packages */
import com.soholighting.sohoTeam8.model.KidsImage;
import com.soholighting.sohoTeam8.service.KidsImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;
import java.util.List;

/*
 * Controller class for managing main page related actions
 */
@Controller
public class MainPageController {
    /* Autowiring KidsImageService to access its methods for image data manipulation */
    @Autowired
    private KidsImageService studentService;

    /*
     * Endpoint to get a random list of KidsImage objects
     */
    @GetMapping("/random-kids")
    public ResponseEntity<List<KidsImage>> getRandomKidsImages() {
        List<KidsImage> kids = studentService.getRandomKidsImages();
        return ResponseEntity.ok(kids);
    }

    /*
     * Endpoint to render the About Us page
     */
    @GetMapping("/aboutus")
    public String Aboutus(Model model) {
        return "Aboutus"; /* Returns the name of the view to be rendered */
    }

    /*
     * Endpoint to render the home page with two random kids' images
     */
    @GetMapping("/home")
    public String Basket(Model model) {
        List<KidsImage> kids = studentService.findAll();
        Collections.shuffle(kids);
        List<KidsImage> twoRandomkids = kids.subList(0, 2); /* Selecting two random images */

        model.addAttribute("kids", twoRandomkids); /* Adding images to the model */
        return "home"; /* Returns the home view */
    }

    /*
     * Endpoint to get random KidsImage objects for a specific year
     */
    @GetMapping("/random-kids/{year}")
    public ResponseEntity<List<KidsImage>> getRandomKidsImagesByYear(@PathVariable String year) {
        List<KidsImage> kids = studentService.getRandomKidsImagesByYear(year);
        return ResponseEntity.ok(kids);
    }

    /*
     * Endpoint to show details of a specific image on the work page
     */
    @GetMapping("/workpage")
    public String showImageDetails(@RequestParam("imageId") int imageId, Model model) {
        KidsImage kidsImage = studentService.getImageById(imageId);
        model.addAttribute("kidsImage", kidsImage); /* Adding the selected image to the model */
        return "workpage"; /* Returns the work page view */
    }

    /*
     * Endpoint to show the painting page
     */
    @GetMapping("/painting")
    public String showPaintingPage() {
        return "paintingShow"; /* Returns the painting show view */
    }
}
