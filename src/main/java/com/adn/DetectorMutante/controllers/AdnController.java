package com.adn.DetectorMutante.controllers;

import com.adn.DetectorMutante.service.AdnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/mutant")
public class AdnController {

    @Autowired
    private AdnService adnService;

    @PostMapping
    public ResponseEntity<?> checkMutant(@RequestBody Map<String, String[]> request) {
        String[] dna = request.get("dna");
        if (dna == null || dna.length == 0) {
            return ResponseEntity.badRequest().body("DNA sequence is required");
        }

        boolean isMutant = adnService.processDna(dna);

        if (isMutant) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(403).build();
        }
    }

    @GetMapping
    public ResponseEntity<?> test() {
        return ResponseEntity.ok("Mutant detector is working!");
    }
}