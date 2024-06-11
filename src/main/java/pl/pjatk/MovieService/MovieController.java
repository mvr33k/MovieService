package pl.pjatk.MovieService;

import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/movies")
public class MovieController {
    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("")
    public ResponseEntity<List<Movie>> returnAllMovies() {
        return ResponseEntity.ok(movieService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movie> returnOneMovie(@PathVariable Integer id) {
        Movie movieById = movieService.findMovieById(id).orElseThrow();
        return ResponseEntity.ok(movieById);
    }
//    dopracować sobie tego optionala bo przy 404 nie zwraca wiadomości z obsługi błędu
//    info o tym jak to zrobić w prezentacji ze zjazdu 4

    @PostMapping("")
    public ResponseEntity<Movie> addMovieToList(
            @RequestBody Movie movie) {
        movieService.addMovieToList(movie);
        return ResponseEntity.ok(movie);
    }

    @PostMapping("/{id}")
    public ResponseEntity<Movie> updateMovie(
            @RequestBody Movie movie,
            @PathVariable Integer id) {
        return ResponseEntity.ok(movieService.updateMovie(id, movie));
    }

    @PatchMapping("/available/{id}")
    public ResponseEntity<Movie> isAvailable(
            @PathVariable Integer id){
        return ResponseEntity.ok(movieService.changeIsAvailable(id));
    }
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteMovie(
//            @PathVariable Integer id){
//
//
//    }


}
