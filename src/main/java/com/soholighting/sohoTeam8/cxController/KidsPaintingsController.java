package com.soholighting.sohoTeam8.cxController;

import com.soholighting.sohoTeam8.cxEnity.KidsImage;
import com.soholighting.sohoTeam8.exception.SohoLightingException;
import com.soholighting.sohoTeam8.cxService.KidsPaintingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

/**
 * @author EnochRibin 23089855
 */
@RestController
public class KidsPaintingsController {
    @Autowired
    private KidsPaintingsService kidsPaintingsService;

    @GetMapping(path = {"/paintings", "/paintings/{index}"})
    public ModelAndView getKidsPaintingBasedOnYear(@PathVariable("index") Optional<String> index) {
        if (index.isEmpty()) {
            try {
                return getModelAndViewAllPaintings();
            } catch (SohoLightingException e) {
                return new ModelAndView("Mainpage");
            }
        } else {
            try {
                return getModelAndViewByYear(index);
            } catch (SohoLightingException e) {
                try {
                    return getModelAndViewAllPaintings();
                } catch (SohoLightingException ex) {
                    return new ModelAndView("Mainpage");
                }
            }
        }
    }

    private ModelAndView getModelAndViewByYear(Optional<String> index) throws SohoLightingException {
        List<KidsImage> kidsPaintingsList = kidsPaintingsService.getPaintingsBasedOnYear(index.get());
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
}
