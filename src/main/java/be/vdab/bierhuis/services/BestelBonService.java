package be.vdab.bierhuis.services;

import be.vdab.bierhuis.domain.Bestelbon;

import java.util.Optional;

public interface BestelBonService {
    long create(Bestelbon bestelbon);
    Optional<Bestelbon> findIdByNaam(String naam);
}
