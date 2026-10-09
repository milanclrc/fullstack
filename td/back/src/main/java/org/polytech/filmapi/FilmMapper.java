package org.polytech.filmapi;

public final class FilmMapper {

    private FilmMapper() {
        // Constructeur privé
    }

    public static FilmDto toDto(Film film) {
        if (film == null) {
            return null;
        }
        return new FilmDto(
                film.getId(),
                film.getTitre(),
                film.getRealisateur(),
                film.getDescription(),
                film.getDateSortie(),
                film.getGenre()
        );
    }
}