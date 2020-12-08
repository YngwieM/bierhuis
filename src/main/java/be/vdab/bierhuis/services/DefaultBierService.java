package be.vdab.bierhuis.services;

import be.vdab.bierhuis.domain.Bier;
import be.vdab.bierhuis.queryresults.MandjeLijst;
import be.vdab.bierhuis.repositories.BierRepository;
import be.vdab.bierhuis.sessions.Mandje;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

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

//    public List<MandjeLijst> toonBestelLijn() {
//        List<MandjeLijst> mandjelijst = new ArrayList<>();
//
//        var bestellijnIds = mandje.getIds();
//        for ()
//    }
}
