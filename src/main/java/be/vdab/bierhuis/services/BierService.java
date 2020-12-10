package be.vdab.bierhuis.services;

import be.vdab.bierhuis.domain.Bier;
import be.vdab.bierhuis.queryresults.MandjeLijst;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface BierService {
    Optional<Bier> findById(long id);
    List<Bier> findByBrouwerId(long id);
    long findAantal();
    List<Bier> findByIds(Set<Long> ids);
    Set<Long> toonLijstAantal( long aantal);
    void updateBieren(long id, long aantal);
}
