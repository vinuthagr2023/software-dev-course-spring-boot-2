package com.example.mycollections.controllers;

import com.example.mycollections.models.Albums;
import com.example.mycollections.models.Movies;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/movies")
public class MoviesController {

    private final List<Movies> movies = new ArrayList<>() {{
        add(new Movies("Jurassic Park", "Steven Spielberg", 1993, 127));
        add(new Movies("The Avengers", "Joss Whedon", 2012, 143));
        add(new Movies("Finding Nemo", "Andrew Stanton", 2003, 100));
    }};

    @GetMapping("/json")
    public List<Movies> getMoviesJson(){
        return movies;
    }

    @GetMapping("/html")
    public String getMoviesHtml() {
        String moviesList = "<ul>";
        for (Movies movie : movies) {
            moviesList += "<li>" + movie + "</li>";
        }
        moviesList += "</ul>";
        return """
                <html>
                    <body>
                        <h1>Movies</h1>
                        <ul>
                """ +
                moviesList +
                """
                        </ul>
                    </body>
                """;
    }
}
