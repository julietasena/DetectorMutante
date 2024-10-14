package com.adn.DetectorMutante.service;

import com.adn.DetectorMutante.entities.Adn;
import com.adn.DetectorMutante.repositories.AdnRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdnService {

    @Autowired
    private AdnRepository adnRepository;

    @Autowired
    private DetectorMutanteService detectorMutanteService;

    public boolean processDna(String[] dna) {
        String sequence = String.join(",", dna);
        if (adnRepository.existsBySequence(sequence)) {
            return false; // Already processed
        }

        boolean isMutant = detectorMutanteService.isMutant(dna);

        Adn adn = Adn.builder()
                .sequence(sequence)
                .isMutant(isMutant)
                .build();

        adnRepository.save(adn);
        return isMutant;
    }
    public long countMutantDna() {
        return adnRepository.countByIsMutant(true);
    }

    public long countHumanDna() {
        return adnRepository.countByIsMutant(false);
    }
}