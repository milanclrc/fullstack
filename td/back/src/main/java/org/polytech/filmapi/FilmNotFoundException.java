package org.polytech.filmapi;

public class FilmNotFoundException extends RuntimeException {
    public FilmNotFoundException(Long id) {
        super("Film introuvable avec l'id " + id);
    }
}