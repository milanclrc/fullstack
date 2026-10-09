package org.polytech.filmapi;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "film")
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "titre obligatoire")
    @Column(nullable = false)
    private String titre;

    @NotBlank(message = "réalisateur obligatoire")
    @Column(nullable = false)
    private String realisateur;

    private String description; // Ajout du champ description

    private LocalDate dateSortie;

    @Enumerated(EnumType.STRING)
    private Genre genre;

    @ManyToMany
    @JoinTable(name="acteur")
    private List<Acteur> acteurs = new ArrayList<>();

    public Film() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getRealisateur() {
        return realisateur;
    }

    public void setRealisateur(String realisateur) {
        this.realisateur = realisateur;
    }

    public String getDescription() { // Ajout du getter description
        return description;
    }

    public void setDescription(String description) { // Ajout du setter description
        this.description = description;
    }

    public LocalDate getDateSortie() {
        return dateSortie;
    }

    public void setDateSortie(LocalDate dateSortie) {
        this.dateSortie = dateSortie;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }
}