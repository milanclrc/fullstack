package org.polytech.filmapi.film;

public final class FilmMapper {

    private FilmMapper() {
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