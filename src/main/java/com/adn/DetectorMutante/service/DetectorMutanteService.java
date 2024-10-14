package com.adn.DetectorMutante.service;

import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class DetectorMutanteService {

    public boolean isMutant(String[] dna) {
        int count = 0;
        int n = dna.length;
        HashSet<String> secuenciasVerificadas = new HashSet<>();

        for (int i = 0; i < n; i++) {
            StringBuilder fila = new StringBuilder();
            StringBuilder columna = new StringBuilder();

            for (int j = 0; j < n; j++) {
                fila.append(dna[i].charAt(j));
                columna.append(dna[j].charAt(i));
            }


            count += contarSecuencia(fila.toString(), secuenciasVerificadas);
            if (count > 1) return true;
            count += contarSecuencia(columna.toString(), secuenciasVerificadas);
            if (count > 1) return true;
        }

        // Revisar diagonales
        for (int i = 0; i < n; i++) {
            StringBuilder diagonal1 = new StringBuilder();
            StringBuilder diagonal2 = new StringBuilder();

            for (int j = 0; j < n - i; j++) {
                diagonal1.append(dna[j].charAt(j + i));
                diagonal2.append(dna[j + i].charAt(j));
            }


            count += contarSecuencia(diagonal1.toString(), secuenciasVerificadas);
            if (count > 1) return true;
            count += contarSecuencia(diagonal2.toString(), secuenciasVerificadas);
            if (count > 1) return true;
        }

        return false;
    }

    private int contarSecuencia(String secuencia, HashSet<String> secuenciasVerificadas) {
        int count = 0;
        for (int i = 0; i < secuencia.length() - 3; i++) {
            String subSecuencia = secuencia.substring(i, i + 4);
            if (subSecuencia.charAt(0) == subSecuencia.charAt(1) &&
                    subSecuencia.charAt(0) == subSecuencia.charAt(2) &&
                    subSecuencia.charAt(0) == subSecuencia.charAt(3)) {

                if (!secuenciasVerificadas.contains(subSecuencia)) {
                    secuenciasVerificadas.add(subSecuencia);
                    count++;
                }
                if (count > 1) break;
            }
        }
        return count;
    }
}