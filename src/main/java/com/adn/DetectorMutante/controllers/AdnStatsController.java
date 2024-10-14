package com.adn.DetectorMutante.controllers;

import com.adn.DetectorMutante.service.AdnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/stats")
public class AdnStatsController {

    @Autowired
    private AdnService adnService;

    @GetMapping
    public ResponseEntity<Map<String, Object>> getStats() {
        long countMutantDna = adnService.countMutantDna();
        long countHumanDna = adnService.countHumanDna();
        double ratio = (countHumanDna == 0) ? 0 : (double) countMutantDna / countHumanDna;

        Map<String, Object> stats = new HashMap<>();
        stats.put("count_mutant_dna", countMutantDna);
        stats.put("count_human_dna", countHumanDna);
        stats.put("ratio", ratio);

        return ResponseEntity.ok(stats);
    }
}
