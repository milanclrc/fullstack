package org.polytech.filmapi.acteur;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import org.polytech.filmapi.film.Film;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "acteur")
public class Acteur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "titre obligatoire")
    @Column(nullable = false)
    private String nom;

    @NotBlank(message = "réalisateur obligatoire")
    @Column(nullable = false)
    private String prenom;

    @ManyToMany(mappedBy = "acteurs")
    List<Film> films = new ArrayList<>();

    public Acteur() {
    }

    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getPrenom() {
        return prenom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public List<Film> getFilms() {
        return films;
    }
    public void setFilms(List<Film> films) {
        this.films = films;
    }
}