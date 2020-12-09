package be.vdab.bierhuis.services;

import be.vdab.bierhuis.domain.BestelBonLijn;
import be.vdab.bierhuis.domain.Bestelbon;
import be.vdab.bierhuis.domain.Bier;
import be.vdab.bierhuis.queryresults.Mand;
import be.vdab.bierhuis.repositories.BestelBonLijnRepository;
import be.vdab.bierhuis.repositories.BestelBonRepository;
import be.vdab.bierhuis.sessions.Mandje;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;

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
