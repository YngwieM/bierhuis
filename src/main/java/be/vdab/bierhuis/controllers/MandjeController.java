package be.vdab.bierhuis.controllers;


import be.vdab.bierhuis.services.BierService;
import be.vdab.bierhuis.sessions.Mandje;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("mandje")
 class MandjeController {
    private final Mandje mandje;
    private final BierService bierService;

    MandjeController(Mandje mandje, BierService bierService) {
        this.mandje = mandje;
        this.bierService = bierService;
    }

    @PostMapping("{id}")
    public String voegToe(@PathVariable long id) {
        mandje.voegToe(id);
        return "redirect:/mandje";
    }
    @PostMapping("{aantal}")
    public String aantal(@PathVariable long aantal) {
        mandje.voegAantal(aantal);
        return "redirect:/mandje";
    }



    @GetMapping
    public ModelAndView toonMandje() {
        var modelAndView = new ModelAndView("mandje");
        modelAndView.addObject("mandbieren",bierService.findByIds(mandje.getIds()));
        modelAndView.addObject("aantal",mandje.getAantal());

        return modelAndView;
    }
}
