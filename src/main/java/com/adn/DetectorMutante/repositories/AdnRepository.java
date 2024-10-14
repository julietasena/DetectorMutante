package com.adn.DetectorMutante.repositories;

import com.adn.DetectorMutante.entities.Adn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdnRepository extends JpaRepository<Adn, Long> {
    boolean existsBySequence(String sequence);
    long countByIsMutant(boolean isMutant);
}