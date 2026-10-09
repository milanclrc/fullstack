package org.polytech.filmapi;

import java.time.LocalDate;

public record FilmDto (
    Long id,
    String titre,
    String realisateur,
    String description,
    LocalDate dateSortie,
    Genre genre
    ) {
}
