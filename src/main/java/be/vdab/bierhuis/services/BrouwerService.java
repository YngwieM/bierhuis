package be.vdab.bierhuis.services;

import be.vdab.bierhuis.domain.Brouwer;

import java.util.List;

public interface BrouwerService {
    List<Brouwer> findAll();
}
