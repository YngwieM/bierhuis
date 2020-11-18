package be.vdab.bierhuis.controllers;


import be.vdab.bierhuis.domain.Bier;
import be.vdab.bierhuis.services.BierService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("bier")
public class BierController {
    private final BierService bierService;

    public BierController(BierService bierService) {
        this.bierService = bierService;
    }

    @GetMapping("/{id}")
    public ModelAndView bierId(@PathVariable long id) {
        var modelAndView = new ModelAndView("bier");
        Bier bier = bierService.findById(id).get();
        modelAndView.addObject("bier", bier);

        return modelAndView;
    }
}
