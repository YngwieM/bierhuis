package be.vdab.bierhuis.controllers;

import be.vdab.bierhuis.domain.Bier;
import be.vdab.bierhuis.services.BierService;
import be.vdab.bierhuis.services.BrouwerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("brouwer")
public class BrouwerController {
    private final BrouwerService brouwerService;
    private final BierService bierService;

    public BrouwerController(BrouwerService brouwerService, BierService bierService) {
        this.brouwerService = brouwerService;
        this.bierService = bierService;
    }


    @GetMapping
    public ModelAndView genres() {
        return new ModelAndView("brouwers", "brouwers", brouwerService.findAll());
    }


    @GetMapping("{id}")
    public ModelAndView genre(@PathVariable long id) {
        var modelAndView = new ModelAndView("brouwer");

        List<Bier> bieren = bierService.findByBrouwerId(id);


        modelAndView.addObject("brouwerbier", bieren);

        return modelAndView;
    }
}
