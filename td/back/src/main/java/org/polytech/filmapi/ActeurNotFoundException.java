package org.polytech.filmapi;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class ActeurNotFoundException extends ResponseStatusException  {
    public ActeurNotFoundException(Long id) {
        super(HttpStatus.NOT_FOUND, "Acteur introuvable avec l'id " + id);
    }
}
