package be.vdab.bierhuis.controllers;


import be.vdab.bierhuis.domain.BestelBonLijn;
import be.vdab.bierhuis.domain.Bier;
import be.vdab.bierhuis.queryresults.Mand;
import be.vdab.bierhuis.queryresults.MandjeLijst;
import be.vdab.bierhuis.services.BestelBonLijnService;
import be.vdab.bierhuis.services.BierService;
import be.vdab.bierhuis.sessions.Mandje;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

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



    @GetMapping
    public ModelAndView toonMandje() {
        var modelAndView = new ModelAndView("mandje");
        Set<Long> bierIds = mandje.getBierIds();
        var mand = new Mand();
        List<Bier> besteldeBieren = bierService.findByIds(bierIds);
        besteldeBieren.forEach(bier ->mand.voegToe(bier, mandje.getAantalVanBierId(bier.getId())));
        BigDecimal totaal = new BigDecimal(0);// moet hier mijn totaal toevoegen.
        besteldeBieren.forEach(bier ->mand.getTotaalPrijs(new BigDecimal(mandje.getAantalVanBierId(bier.getId())).multiply(bier.getPrijs()))); // dit zou moeten werken?
        modelAndView.addObject("mand",mand);
        modelAndView.addObject("totaal",totaal);

        return modelAndView;
    }
}
