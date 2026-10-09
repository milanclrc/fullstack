package org.polytech.filmapi.acteur;

import org.polytech.filmapi.film.FilmDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/acteurs")
public class ActeurController {

    private final ActeurService acteurService;

    public ActeurController(ActeurService acteurService) {
        this.acteurService = acteurService;
    }

    @GetMapping
    public List<ActeurDto> findAll() {
        return acteurService.findAll();
    }

    @GetMapping("/{id}")
    public ActeurDto findById(@PathVariable Long id) {
        return acteurService.findById(id);
    }

    @PostMapping
    public ResponseEntity<ActeurDto> createActeur(@RequestBody ActeurDto dto) {
        ActeurDto created = acteurService.addActeur(dto);
        return ResponseEntity.created(URI.create("/acteurs/" + created.id())).body(created);
    }

    @PutMapping("/{id}")
    public ActeurDto updateActeur(@PathVariable Long id, @RequestBody ActeurDto dto) {
        return acteurService.updateActeur(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteActeur(@PathVariable Long id) {
        acteurService.deleteActeur(id);
    }

    @GetMapping("/{id}/films")
    public List<FilmDto> getFilmsByActeurId(@PathVariable Long id) {
        return acteurService.getFilmsByActeurId(id);
    }
}