package org.polytech.filmapi;

import jakarta.validation.constraints.NotBlank;

public record ActeurCreationDto(
        @NotBlank(message = "Le nom ne peut pas être vide")
        String nom,

        @NotBlank(message = "Le prenom ne peut pas être vide")
        String prenom
) {
}
