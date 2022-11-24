package io.javabrains.movieinfoservice.resources;

import io.javabrains.movieinfoservice.models.Movie;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movies")
public class MovieResource {

    @RequestMapping("/{movieId}")
    public Movie getMovieInfo(@PathVariable("movieId") String movieId) {
        return new Movie(movieId, "Name for ID " + movieId);

    }
    @PostMapping("/postbody")
    public Movie postBody(@RequestBody Movie movie) {
        movie.setName("Avathar");
        movie.setMovieId("1");
        return   movie;
    }
}
