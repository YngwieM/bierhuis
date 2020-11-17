package be.vdab.bierhuis.controllers;

import be.vdab.bierhuis.services.BrouwerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("brouwer")
public class BrouwerController {
    private final BrouwerService brouwerService;

    public BrouwerController(BrouwerService brouwerService) {
        this.brouwerService = brouwerService;
    }
    @GetMapping
    public ModelAndView genres() {
        return new ModelAndView("brouwer", "brouwers", brouwerService.findAll());
    }

}
