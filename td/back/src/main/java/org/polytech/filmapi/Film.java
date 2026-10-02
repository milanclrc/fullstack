package org.polytech.filmapi;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titre;
    private String real;
    private LocalDate dateSortie;
    private Genre genre;


    public Film(Long id, String titre, String real, LocalDate dateSortie, Genre genre) {
        this.id = id;
        this.titre = titre;
        this.real = real;
        this.dateSortie = dateSortie;
        this.genre = genre;
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
    public String getReal() {
        return real;
    }
    public void setReal(String real) {
        this.real = real;
    }
    public LocalDate getDateSortie() {
        return dateSortie;
    }
    public void setDateSortie(LocalDate dateSortie) {
        this.dateSortie = dateSortie;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Genre getGenre() {
        return genre;
    }
}
