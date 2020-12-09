package be.vdab.bierhuis.repositories;

import be.vdab.bierhuis.domain.BestelBonLijn;
import be.vdab.bierhuis.domain.Bestelbon;

import java.util.Optional;

public interface BestelBonRepository {
    long create(Bestelbon bestelbon);
   Optional<Bestelbon> findIdByNaam(String naam);
}
