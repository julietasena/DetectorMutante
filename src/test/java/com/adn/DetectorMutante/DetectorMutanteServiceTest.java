package com.adn.DetectorMutante;


import com.adn.DetectorMutante.service.DetectorMutanteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class DetectorMutanteServiceTest {
    private DetectorMutanteService mutantDetectorService;

    @BeforeEach
    void setUp() {
        mutantDetectorService = new DetectorMutanteService();
    }

    @Test
    void testIsMutant_WithMutantDNA_ReturnsTrue() {
        String[] dna = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
        assertTrue(mutantDetectorService.isMutant(dna));
    }

    @Test
    void testIsMutant_WithHumanDNA_ReturnsFalse() {
        String[] dna = {"ATGCGA","CAGTGC","TTATTT","AGACGG","GCGTCA","TCACTG"};
        assertFalse(mutantDetectorService.isMutant(dna));
    }
}

