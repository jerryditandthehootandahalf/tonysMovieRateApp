package movie.rate.persistence.repository;

import movie.rate.persistence.model.Movie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MovieRepository extends CrudRepository<Movie, Long> {


    Optional<Movie> findMovieByTitle(@Param("title")String title);
}
