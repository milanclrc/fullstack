package org.polytech.filmapi;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/films")
public class FilmController {

    private FilmService service;

    public FilmController(FilmService service) {
        this.service = service;
    }

    @GetMapping
    public List<Film> getFilms() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Film getFilm(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public ResponseEntity<Film> addFilm(@RequestBody Film film,
                                        UriComponentsBuilder uriBuilder) {
        Film created = service.addFilm(film);
        var location = uriBuilder.path("/films/{id}").buildAndExpand(created.getId()).toUri();
        return ResponseEntity.created(location).body(created);
    }

    @PutMapping("/{id}")
    public Film updateFilm(@PathVariable Long id, @RequestBody Film film) {
        return service.updateFilm(id, film);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFilm(@PathVariable Film film) {
        service.deleteFilm(film);
        return ResponseEntity.noContent().build();
    }



}
