package pl.pjatk.MovieService;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface MovieRepository extends JpaRepository<Movie, Integer> {

    @Override
    List<Movie> findAll();

    @Override
    Optional<Movie> findById(Integer integer);

    @Override
    <S extends Movie> S save(S entity);
}

