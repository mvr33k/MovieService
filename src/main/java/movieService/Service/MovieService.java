package movieService.Service;

import movieService.Classes.Movie;
import movieService.Storage.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieStorage) {
        this.movieRepository = movieStorage;
    }

    public List<Movie> getAll() {
        return movieRepository.findAll();
    }

//    public Movie findMovieById(int id){
//        Movie toReturn=null;
//        for (Movie m : movieStorage.getAll()){
//            if(id == m.getId()){
//                toReturn = m;
//            }
//        }
//        return toReturn;
//    }

    public Optional<Movie> findMovieById(Integer id) {
        if (movieRepository.findById(id).isEmpty()) {
            throw new NoSuchElementException("Nie znaleziono filmu w bazie");
        } else {
            return movieRepository.findById(id);
        }
    }


    public void addMovieToList(Movie movie) {
        boolean shouldAdd = true;
        if (movie.getCategory() == null || movie.getTitle().isEmpty()) {
            throw new IllegalArgumentException("Nie wypelniono wszystkich pol");
        }
        for (Movie s : movieRepository.findAll()) {
            if (s.getTitle().equals(movie.getTitle())) {
                throw new IllegalArgumentException("Film znajduje sie juz w bazie");
            }
        }
        movieRepository.save(movie);
    }

//    public void addMovieToList(String tytul, String kategoria){
//        movieStorage.addMovie(new Movie(3,tytul,kategoria));
//    }
//    public Integer lastId(){
//        return getAll().stream()
//
//    }

    //    id nie moze byc nullem
//
    public Movie updateMovie(Integer id, Movie movie) {
        if (id == null) throw new IllegalArgumentException("Brak ID");
        if (movieRepository.findById(id).isEmpty())
            throw new IllegalArgumentException("Brak filmu w bazie");
        if (movie.getTitle().isEmpty() && movie.getCategory() != null)
            throw new IllegalArgumentException("Brak danych do update'u");
        Movie updated = movieRepository.findById(id).orElseThrow();
        if (!movie.getTitle().isEmpty())
            updated.setTitle(movie.getTitle());
        if (movie.getCategory() != null)
            updated.setCategory(movie.getCategory());
        movieRepository.save(updated);
        return updated;
    }

    public Movie isAvailable(int id){
        Movie movie = findMovieById(id).orElseThrow();
        movie.setAvailable(true);
        movieRepository.save(movie);
        return movie;
    }

    public Movie isNotAvailable(int id){
        Movie movie = findMovieById(id).orElseThrow();
        movie.setAvailable(false);
        movieRepository.save(movie);
        return movie;
    }


}
