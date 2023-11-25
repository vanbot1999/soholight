package com.soholighting.sohoTeam8.cxController;

import com.soholighting.sohoTeam8.cxEnity.KidsImage;
import com.soholighting.sohoTeam8.cxService.KidsImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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

    @GetMapping("/home")
    public String Basket(Model model) {
        List<com.soholighting.sohoTeam8.cxEnity.KidsImage> kids = studentService.findAll();
        Collections.shuffle(kids );
        List<com.soholighting.sohoTeam8.cxEnity.KidsImage> twoRandomkids = kids.subList(0, 2);

        model.addAttribute("kids", twoRandomkids);
        return "Mainpage";
    }
    @GetMapping("/random-kids/{year}")
    public ResponseEntity<List<KidsImage>> getRandomKidsImagesByYear(@PathVariable String year) {
        List<KidsImage> kids = studentService.getRandomKidsImagesByYear(year);
        return ResponseEntity.ok(kids);
    }

}
