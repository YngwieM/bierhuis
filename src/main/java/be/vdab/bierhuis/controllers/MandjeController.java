package be.vdab.bierhuis.controllers;


import be.vdab.bierhuis.domain.BestelBonLijn;
import be.vdab.bierhuis.domain.Bestelbon;
import be.vdab.bierhuis.domain.Bier;
import be.vdab.bierhuis.forms.GegevensForm;
import be.vdab.bierhuis.queryresults.Mand;
import be.vdab.bierhuis.services.BestelBonLijnService;
import be.vdab.bierhuis.services.BestelBonService;
import be.vdab.bierhuis.services.BierService;
import be.vdab.bierhuis.sessions.Mandje;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("mandje")
 class MandjeController {
    private final Mandje mandje;
    private final BierService bierService;
    private final BestelBonLijnService bestelBonLijnService;
    private final BestelBonService bestelBonService;

    MandjeController(Mandje mandje, BierService bierService, BestelBonLijnService bestelBonLijnService, BestelBonService bestelBonService) {
        this.mandje = mandje;
        this.bierService = bierService;
        this.bestelBonLijnService = bestelBonLijnService;
        this.bestelBonService = bestelBonService;
    }



    @GetMapping
    public ModelAndView toonMandje() {
        var modelAndView = new ModelAndView("mandje");
        Set<Long> bierIds = mandje.getBierIds();
        var mand = new Mand();
        List<Bier> besteldeBieren = bierService.findByIds(bierIds);
        besteldeBieren.forEach(bier ->mand.voegToe(bier, mandje.getAantalVanBierId(bier.getId())));
        modelAndView.addObject("mand",mand);
        modelAndView.addObject("totaal",mand.getTotaalPrijs());

        modelAndView.addObject(new GegevensForm(null,null,null,0,null));
        return modelAndView;
    }

    @PostMapping("/bevestigen")
    public ModelAndView bevestigen( @Valid GegevensForm form, Errors errors) {
        var bestelbon = new Bestelbon(0,form.getNaam(),form.getStraat(),form.getHuisNummer(),form.getPostcode(),form.getGemeente());
        bestelBonService.create(bestelbon);
        var bestelBonIdInt =bestelBonService.findIdByNaam(form.getNaam()).get().getId();
        var bestelIdLong = new Long (bestelBonIdInt);
        Set<Long> bierIds = mandje.getBierIds();
        List<Bier> besteldeBieren = bierService.findByIds(bierIds);
        besteldeBieren.forEach(bier -> bestelBonLijnService.create(new BestelBonLijn(bestelIdLong,bier.getId(), mandje.getAantalVanBierId(bier.getId()),bier.getPrijs())));
        mandje.voegBestelBonIdToe(bestelIdLong);


        return new ModelAndView("redirect:/bevestiging");
    }

    @GetMapping("/bevestiging")
    public ModelAndView bevestiging() {
        var modelAndView = new ModelAndView("bevestiging");
        modelAndView.addObject("bestelBonId",mandje.getBestelBonId());
        mandje.maakMandjeLeeg();
        return modelAndView;
    }
}
