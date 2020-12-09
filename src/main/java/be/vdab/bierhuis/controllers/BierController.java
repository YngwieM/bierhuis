package be.vdab.bierhuis.controllers;


import be.vdab.bierhuis.domain.Bier;
import be.vdab.bierhuis.forms.AantalBierenForm;
import be.vdab.bierhuis.services.BierService;
import be.vdab.bierhuis.sessions.Mandje;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("bier")
public class BierController {
    private final BierService bierService;
    private final Mandje mandje;

    public BierController(BierService bierService, Mandje mandje) {
        this.bierService = bierService;
        this.mandje = mandje;
    }

    @GetMapping("{id}")
    public ModelAndView bierId(@PathVariable long id) {
        var modelAndView = new ModelAndView("bier");
        Bier bier = bierService.findById(id).get();
        modelAndView.addObject("bier", bier);
        modelAndView.addObject(new AantalBierenForm(0L));

        return modelAndView;
    }



    @PostMapping("{id}/bestellen")
    public ModelAndView aantalBieren(@PathVariable Long id,@Valid AantalBierenForm form, Errors errors) {
        var modelAndView = new ModelAndView("bier");
        if (errors.hasErrors()) {
            Bier bier = bierService.findById(id).get();
            modelAndView.addObject("bier", bier);
            return modelAndView;
        }
        mandje.voegToe(id,form.getAantal());
        return new ModelAndView("redirect:/mandje");
    }
}