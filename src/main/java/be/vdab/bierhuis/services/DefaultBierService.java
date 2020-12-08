package be.vdab.bierhuis.services;

import be.vdab.bierhuis.domain.BestelBonLijn;
import be.vdab.bierhuis.domain.Bier;
import be.vdab.bierhuis.queryresults.MandjeLijst;
import be.vdab.bierhuis.repositories.BierRepository;
import be.vdab.bierhuis.sessions.Mandje;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.*;

@Service
@Transactional
 class DefaultBierService implements BierService {
    private final BierRepository bierRepository;
    private final Mandje mandje;

    DefaultBierService(BierRepository bierRepository, Mandje mandje) {
        this.bierRepository = bierRepository;
        this.mandje = mandje;
    }

    @Override
    public Optional<Bier> findById(long id) {
        return bierRepository.findById(id);
    }

    @Override
    public List<Bier> findByBrouwerId(long id) {
        return bierRepository.findByBrouwerId(id);
    }

    @Override
    public long findAantal() {
        return bierRepository.findAantal();
    }

    @Override
    public List<Bier> findByIds(Set<Long> ids) {
        return bierRepository.findByIds(ids);
    }

//    public List<MandjeLijst> toonLijst() {
//        List<MandjeLijst> mandlijst = new ArrayList<>();
//        for ()
//        var lijn = new MandjeLijst(naam,prijs,aantal);
//        mandlijst.add(lijn);
//        return mandlijst;
//    }

    public Set<Long> toonLijstAantal( long aantal) {
         Set<Long> aantals = new LinkedHashSet<>();
        aantals.add(aantal);
        return aantals;
    }
}
