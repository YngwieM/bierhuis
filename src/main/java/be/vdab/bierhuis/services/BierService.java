package be.vdab.bierhuis.services;

import be.vdab.bierhuis.domain.Bier;

import java.util.List;
import java.util.Optional;

public interface BierService {
    Optional<Bier> findById(long id);
    List<Bier> findByBrouwerId(long id);
    long findAantal();
}
