package org.polytech.filmapi;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ActeurService {

    private final ActeurRepo repo;

    public ActeurService(ActeurRepo repo) {
        this.repo = repo;
    }

    public List<ActeurDto> findAll() {
        return repo.findAll().stream()
                .map(ActeurMapper::toDto)
                .toList();
    }

    public ActeurDto findById(Long id) {
        Acteur acteur = repo.findById(id)
                .orElseThrow(() -> new ActeurNotFoundException(id));
        return ActeurMapper.toDto(acteur);
    }

    @Transactional
    public ActeurDto addActeur(ActeurDto body) {
        Acteur acteur = ActeurMapper.toEntity(body);
        acteur.setId(null);
        Acteur saved = repo.save(acteur);
        return ActeurMapper.toDto(saved);
    }

    @Transactional
    public ActeurDto updateActeur(Long id, ActeurDto body) {
        Acteur existing = repo.findById(id)
                .orElseThrow(() -> new ActeurNotFoundException(id));

        existing.setNom(body.nom());
        existing.setPrenom(body.prenom());

        return ActeurMapper.toDto(existing);
    }

    public void deleteActeur(Long id) {
        if (!repo.existsById(id)) {
            throw new ActeurNotFoundException(id);
        }
        repo.deleteById(id);
    }

    public List<FilmDto> getFilmsByActeurId(Long id) {
        Acteur acteur = repo.findById(id)
                .orElseThrow(() -> new ActeurNotFoundException(id));

        return acteur.getFilms().stream()
                .map(FilmMapper::toDto)
                .toList();
    }
}