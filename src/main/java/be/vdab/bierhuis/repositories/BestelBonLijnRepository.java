package be.vdab.bierhuis.repositories;

import be.vdab.bierhuis.domain.BestelBonLijn;
import be.vdab.bierhuis.domain.Bestelbon;
import be.vdab.bierhuis.domain.Bier;

import java.util.Optional;

public interface BestelBonLijnRepository {
    Optional<BestelBonLijn> findById(long id);
    long create(BestelBonLijn bestelBonLijn);
}
