package com.soholighting.sohoTeam8.controller;

import com.soholighting.sohoTeam8.model.KidsImage;
import com.soholighting.sohoTeam8.exception.SohoLightingException;
import com.soholighting.sohoTeam8.service.KidsPaintingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author EnochRibin 23089855
 */
@RestController
public class KidsPaintingsController {
    @Autowired
    private KidsPaintingsService kidsPaintingsService;

    @GetMapping("/motif")
    public ModelAndView getKidsPaintingBasedOnYear(@RequestParam(value = "year", required = false) Integer year) {
        if (year != null) {
                System.out.println(year);
            try {
                return getModelAndViewByYear(Integer.toString(year));
            } catch (SohoLightingException e) {
                try {
                    return getModelAndViewAllPaintings();
                } catch (SohoLightingException ex) {
                    return new ModelAndView("Mainpage");
                }
            }
        } else {
            try {
                return getModelAndViewAllPaintings();
            } catch (SohoLightingException e) {
                return new ModelAndView("Mainpage");
            }
        }
    }

    private ModelAndView getModelAndViewByYear(String year) throws SohoLightingException {
        List<KidsImage> kidsPaintingsList = kidsPaintingsService.getPaintingsBasedOnYear(year);
        ModelAndView kidsPaintingsMV = new ModelAndView("kidsPaintings");
        kidsPaintingsMV.addObject("kidsPaintings", kidsPaintingsList);
        return kidsPaintingsMV;
    }

    private ModelAndView getModelAndViewAllPaintings() throws SohoLightingException {
        List<KidsImage> kidsPaintingsList = kidsPaintingsService.getAllPaintings();
        ModelAndView kidsPaintingsMV = new ModelAndView("kidsPaintings");
        kidsPaintingsMV.addObject("kidsPaintings", kidsPaintingsList);
        return kidsPaintingsMV;
    }

    @GetMapping("/admin_motif_list")
    public ModelAndView getModelAndViewAllPaintingsAdmin() throws SohoLightingException {
        List<KidsImage> kidsPaintingsList = kidsPaintingsService.getAllPaintings();
        ModelAndView kidsPaintingsMV = new ModelAndView("motifList");
        kidsPaintingsMV.addObject("kidsPaintings", kidsPaintingsList);
        return kidsPaintingsMV;
    }
}
