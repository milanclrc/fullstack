package org.polytech.filmapi;

import jakarta.validation.constraints.NotBlank;
import java.time.LocalDate;

public record FilmCreationDto(
        @NotBlank(message = "Le titre ne peut pas être vide")
        String titre,

        String realisateur,

        String description,

        LocalDate dateSortie,

        Genre genre
) {}