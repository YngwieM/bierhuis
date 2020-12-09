package be.vdab.bierhuis.services;

import be.vdab.bierhuis.domain.BestelBonLijn;
import be.vdab.bierhuis.domain.Bestelbon;
import be.vdab.bierhuis.repositories.BestelBonRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class DefaultBestelBonService implements BestelBonService {
    private final BestelBonRepository bestelBonRepository;

    public DefaultBestelBonService(BestelBonRepository bestelBonRepository) {
        this.bestelBonRepository = bestelBonRepository;
    }


    @Override
    public long create(Bestelbon bestelbon) {
        return bestelBonRepository.create(bestelbon);
    }

    @Override
    public Optional<Bestelbon> findIdByNaam(String naam) {
        return bestelBonRepository.findIdByNaam(naam);
    }
}
