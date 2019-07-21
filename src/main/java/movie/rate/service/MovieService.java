package movie.rate.service;

import com.google.common.collect.Lists;
import movie.rate.dto.ActorDTO;
import movie.rate.dto.MovieDTO;
import movie.rate.persistence.model.Movie;
import movie.rate.persistence.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;


@Service
public class MovieService {

    private MovieRepository movieRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<MovieDTO> getAllMovies(){

        return MovieDTO.populateList(Lists.newArrayList(movieRepository.findAll()));
    }

    public MovieDTO findMovieById(Long id){

        Optional<Movie> movie = movieRepository.findById(id);
        return movie.isPresent() ? MovieDTO.populate(movie.get()) : MovieDTO.getEmptyDto();
    }

    public MovieDTO findMovieByTitle(String title){

        Optional<Movie> movie = movieRepository.findMovieByTitle(title);
        return movie.isPresent() ? MovieDTO.populate(movie.get()) : MovieDTO.getEmptyDto();
    }

    public List<ActorDTO> findCastByTitle(String title){

        Optional<Movie> movie = movieRepository.findMovieByTitle(title);
        return movie.isPresent() ? ActorDTO.populateList(movie.get().getCast()) : Lists.newArrayList(ActorDTO.getEmptyDto());
    }

    public void createNewMovie(MovieDTO movieDTO){

        validateNewMovie(movieDTO);
        Movie movie = getMovieFromDto(movieDTO);
        movieRepository.save(movie);
    }

    private void validateNewMovie(MovieDTO movieDTO){


    }

    private Movie getMovieFromDto(MovieDTO movieDTO){

        Movie entity = new Movie();
        entity.setReleaseDate(movieDTO.getReleaseDate());
        entity.setRating(movieDTO.getRating());
        entity.setTitle(movieDTO.getTitle());
        return entity;
    }
}
