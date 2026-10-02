package org.polytech.filmapi;

import java.util.List;
import java.util.Optional;

public interface FilmStore {

    List<Film> findAll();
    Optional<Film> findById(Long id);
    Film addFilm(Film film);
    Optional<Film> updateFilm(Long id, Film film);
    boolean deleteFilm(Long id);
}
