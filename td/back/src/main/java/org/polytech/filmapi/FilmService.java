package org.polytech.filmapi;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FilmService {

    private final FilmRepo repo;

    public FilmService(FilmRepo repo) {
        this.repo = repo;
    }

    public List<FilmDto> findAll() {
        return repo.findAll().stream()
                .map(FilmMapper::toDto)
                .toList();
    }

    public FilmDto findById(Long id) {
        Film film = repo.findById(id)
                .orElseThrow(() -> new FilmNotFoundException(id));
        return FilmMapper.toDto(film);
    }

    @Transactional
    public FilmDto addFilm(FilmCreationDto body) {
        Film film = new Film();
        film.setTitre(body.titre());
        film.setRealisateur(body.realisateur()); // Corrigé ici
        film.setDateSortie(body.dateSortie());
        film.setGenre(body.genre());

        Film saved = repo.save(film);
        return FilmMapper.toDto(saved);
    }

    @Transactional
    public FilmDto updateFilm(Long id, FilmCreationDto body) {
        Film existing = repo.findById(id)
                .orElseThrow(() -> new FilmNotFoundException(id));

        existing.setTitre(body.titre());
        existing.setRealisateur(body.realisateur()); // Corrigé ici
        existing.setDateSortie(body.dateSortie());
        existing.setGenre(body.genre());

        return FilmMapper.toDto(existing);
    }

    public void deleteFilm(Long id) {
        if (!repo.existsById(id)) {
            throw new FilmNotFoundException(id);
        }
        repo.deleteById(id);
    }
}