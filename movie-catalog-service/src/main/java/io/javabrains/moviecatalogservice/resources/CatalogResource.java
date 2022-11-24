package io.javabrains.moviecatalogservice.resources;

import java.net.URISyntaxException;


import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import io.javabrains.moviecatalogservice.models.CatalogItem;
import io.javabrains.moviecatalogservice.models.Movie;
import io.javabrains.moviecatalogservice.models.Rating;
import io.javabrains.moviecatalogservice.models.UserRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class CatalogResource {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    WebClient.Builder webClientBuilder;

    @RequestMapping("/{userId}")
    public ResponseEntity<Movie> getCatalog(@PathVariable("userId") String userId){

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        Movie objEmp = new Movie();
        objEmp.setName("Krishna");
        objEmp.setMovieId("1");

        HttpEntity<Movie> httpEntity = new HttpEntity<Movie>(objEmp, headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Movie> responseEntity = restTemplate.exchange("http://localhost:8082/movies/postbody", HttpMethod.POST, httpEntity,Movie.class);

         return responseEntity;

       // UserRating userRating = restTemplate.getForObject("http://localhost:8083/ratingsdata/user/" + userId, UserRating.class);

       /* return userRating.getRatings().stream()
                .map(rating -> {
                    Movie movie = restTemplate.getForObject("http://localhost:8082/movies/" + rating.getMovieId(), Movie.class);
                    return new CatalogItem(movie.getName(), "Description", rating.getRating());
                })
                .collect(Collectors.toList());*/

    }
}

/*
Alternative WebClient way
Movie movie = webClientBuilder.build().get().uri("http://localhost:8082/movies/"+ rating.getMovieId())
.retrieve().bodyToMono(Movie.class).block();
*/