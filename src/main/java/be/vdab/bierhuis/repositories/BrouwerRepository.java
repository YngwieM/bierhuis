package be.vdab.bierhuis.repositories;

import be.vdab.bierhuis.domain.Brouwer;

import java.util.List;

public interface BrouwerRepository {
    List<Brouwer> findAll();
}
