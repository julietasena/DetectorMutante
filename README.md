# DetectorMutante

Este proyecto implementa un sistema de detección de mutantes basado en secuencias de ADN.

## Descripción

El sistema analiza secuencias de ADN representadas como matrices de caracteres para determinar si pertenecen a un mutante. Se considera que una secuencia de ADN es de un mutante si se encuentra más de una secuencia de cuatro letras iguales de forma oblicua, horizontal o vertical.

## Tecnologías utilizadas

- Java 17
- Spring Boot 3.3.4
- Gradle
- H2 Database
- JUnit 5

## Uso de la API

Para verificar una secuencia de ADN, envía una solicitud POST a `/mutant/` con el siguiente formato JSON:

```json
{
  "dna": ["ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"]
}
```

La API responderá con:
- 200 OK si la secuencia es de un mutante
- 403 Forbidden si la secuencia no es de un mutante
