package be.vdab.bierhuis.controllers;


import be.vdab.bierhuis.domain.BestelBonLijn;
import be.vdab.bierhuis.services.BestelBonLijnService;
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
    private final BestelBonLijnService bestelBonLijnService;

    MandjeController(Mandje mandje, BierService bierService, BestelBonLijnService bestelBonLijnService) {
        this.mandje = mandje;
        this.bierService = bierService;
        this.bestelBonLijnService = bestelBonLijnService;
    }

    @PostMapping("{id}")
    public String voegToe(@PathVariable long id) {
        mandje.voegToe(id);
        var bestelbonlijn = new BestelBonLijn(0,id,bierService.findAantal(),bierService.findById(id).get().getPrijs());
        bestelBonLijnService.create(bestelbonlijn);
        return "redirect:/mandje";
    }



    @GetMapping
    public ModelAndView toonMandje() {
        var modelAndView = new ModelAndView("mandje");
        modelAndView.addObject("mandbieren",bierService.findByIds(mandje.getIds()));
        modelAndView.addObject("lijstbestellijnen",mandje.getBestelLijnLijst());

        return modelAndView;
    }
}
