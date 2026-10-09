# Développement Fullstack — Polytech

## Structure

    tp/
      back/     projet Gradle + Spring Boot préconfiguré : TP Java / Spring
      front/    répertoire vide, destiné au projet créé par « ng new » : TP Angular
    td/
      back/     TD : API REST de la bibliothèque de films
        http/   requêtes HTTP, exécutées avec l'extension VSCode REST Client
      front/    TD : front Angular de la bibliothèque de films

## Démarrage du site

Utilisation d'un docker pour le back, dans un premier terminal lancer le docker :

    sudo docker compose up -d

Par la suite, lancer App pour Sping Boot via la classe 

    back/src/main/java/org.polytech.filmapi/App

Dans un second terminal, démarrer l'application du front avec la commande :

    ng serve

Le site sera accessible sur :

    http://localhost:4200


