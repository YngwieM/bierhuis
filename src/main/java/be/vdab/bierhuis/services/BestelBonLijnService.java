package be.vdab.bierhuis.services;

import be.vdab.bierhuis.domain.BestelBonLijn;

import java.util.Optional;

public interface BestelBonLijnService {

    Optional<BestelBonLijn> findById(long id);
    long create(BestelBonLijn bestelBonLijn);
}
