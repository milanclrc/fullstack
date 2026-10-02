package org.polytech.filmapi;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class FilmNotFoundException extends ResponseStatusException {
    public FilmNotFoundException(Long id) {
        super(HttpStatus.NOT_FOUND, "Film introuvable avec l'id " + id);
    }
}