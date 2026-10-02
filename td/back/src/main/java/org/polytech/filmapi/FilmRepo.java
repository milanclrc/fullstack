package org.polytech.filmapi;

import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class FilmRepo implements FilmStore {

    private final List<Film> listeFilms = new ArrayList<>();
    private final AtomicLong sequence = new AtomicLong(0);

    @Override
    public List<Film> findAll() {
        return new ArrayList<>(listeFilms); // copie pour ne pas exposer la liste interne
    }

    @Override
    public Optional<Film> findById(Long id) {
        return listeFilms.stream()
                .filter(f -> f.getId().equals(id))
                .findFirst();
    }

    @Override
    public Film addFilm(Film film) {
        film.setId(sequence.incrementAndGet());
        listeFilms.add(film);
        return film;
    }

    @Override
    public Optional<Film> updateFilm(Long id, Film film) {
        Optional<Film> existing = findById(id);
        existing.ifPresent(f -> {
            f.setTitre(film.getTitre());
            f.setRealisateur(film.getRealisateur());
            f.setDateSortie(film.getDateSortie());
            f.setGenre(film.getGenre());
        });
        return existing;
    }

    @Override
    public boolean deleteFilm(Long id) {
        return listeFilms.removeIf(f -> f.getId().equals(id));
    }
}