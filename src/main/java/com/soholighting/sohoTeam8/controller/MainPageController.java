package com.soholighting.sohoTeam8.controller;

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

@Controller
public class MainPageController {
    @Autowired
    private KidsImageService studentService;
    @GetMapping("/random-kids")
    public ResponseEntity<List<KidsImage>> getRandomKidsImages() {
        List<KidsImage> kids = studentService.getRandomKidsImages();
        return ResponseEntity.ok(kids);
    }
    @GetMapping("/aboutus")
    public String Aboutus(Model model) {

        return "Aboutus";
    }
    @GetMapping("/home")
    public String Basket(Model model) {
        List<KidsImage> kids = studentService.findAll();
        Collections.shuffle(kids );
        List<KidsImage> twoRandomkids = kids.subList(0, 2);

        model.addAttribute("kids", twoRandomkids);
        return "home";
    }
    @GetMapping("/random-kids/{year}")
    public ResponseEntity<List<KidsImage>> getRandomKidsImagesByYear(@PathVariable String year) {
        List<KidsImage> kids = studentService.getRandomKidsImagesByYear(year);
        return ResponseEntity.ok(kids);
    }
    @GetMapping("/workpage")
    public String showImageDetails(@RequestParam("imageId") int imageId, Model model) {
        KidsImage kidsImage = studentService.getImageById(imageId);
        model.addAttribute("kidsImage", kidsImage);
        return "workpage";
    }
    @GetMapping("/painting")
    public String showPaintingPage() {
        return "painting_show";
    }
}
