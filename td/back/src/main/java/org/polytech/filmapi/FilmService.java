package org.polytech.filmapi;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class FilmService {

    private final FilmStore repo;

    public FilmService(FilmStore repo) {
        this.repo = repo;
    }

    public List<Film> findAll() {
        return repo.findAll();
    }

    public Film addFilm(Film film) {
        repo.addFilm(film);
        return film;
    }

    public Film findById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new FilmNotFoundException(id));
    }

    public Film updateFilm(Long id, Film film) {
        return repo.updateFilm(id, film)
                .orElseThrow(() -> new FilmNotFoundException(id));
    }

    public void deleteFilm(Film film) {
        boolean removed = repo.deleteFilm(film);
        if (!removed) {
            throw new FilmNotFoundException(film.getId());
        }
    }
}

