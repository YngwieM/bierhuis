package be.vdab.bierhuis.services;

import be.vdab.bierhuis.domain.BestelBonLijn;
import be.vdab.bierhuis.repositories.BestelBonLijnRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
 class DefaultBestelBonLijnService implements BestelBonLijnService  {
    private final BestelBonLijnRepository bestelBonLijnRepository;

    DefaultBestelBonLijnService(BestelBonLijnRepository bestelBonLijnRepository) {
        this.bestelBonLijnRepository = bestelBonLijnRepository;
    }

    @Override
    public Optional<BestelBonLijn> findById(long id) {
      return bestelBonLijnRepository.findById(id);
    }

    @Override
    public long create(BestelBonLijn bestelBonLijn) {
        return bestelBonLijnRepository.create(bestelBonLijn);
    }
}
