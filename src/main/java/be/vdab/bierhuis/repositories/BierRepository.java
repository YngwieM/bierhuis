package be.vdab.bierhuis.repositories;

import be.vdab.bierhuis.domain.BestelBonLijn;
import be.vdab.bierhuis.domain.Bier;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface BierRepository {
    Optional<Bier> findById(long id);
    List<Bier> findByBrouwerId(long id);
    long findAantal();
    List<Bier> findByIds(Set<Long> ids);
    void updateBieren(long id, long aantal);


}
