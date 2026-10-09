package org.polytech.filmapi;

public class ActeurMapper {

    private ActeurMapper() {
    }

    public static ActeurDto toDto(Acteur acteur) {
        if (acteur == null) {
            return null;
        }
        return new ActeurDto(
                acteur.getId(),
                acteur.getNom(),
                acteur.getPrenom()
        );
    }

    public static Acteur toEntity(ActeurDto dto) {
        if (dto == null) {
            return null;
        }
        Acteur acteur = new Acteur();
        acteur.setId(dto.id());
        acteur.setNom(dto.nom());
        acteur.setPrenom(dto.prenom());
        return acteur;
    }
}