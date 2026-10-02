package org.polytech.filmapi;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmService {

    private final FilmStore repo;

    public FilmService(FilmStore repo) {
        this.repo = repo;
    }

    public List<Film> findAll() {
        return repo.findAll();
    }

    public Film findById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new FilmNotFoundException(id));
    }

    public Film addFilm(Film film) {
        return repo.addFilm(film);
    }

    public Film updateFilm(Long id, Film film) {
        return repo.updateFilm(id, film)
                .orElseThrow(() -> new FilmNotFoundException(id));
    }

    public void deleteFilm(Long id) {
        if (!repo.deleteFilm(id)) {
            throw new FilmNotFoundException(id);
        }
    }
}