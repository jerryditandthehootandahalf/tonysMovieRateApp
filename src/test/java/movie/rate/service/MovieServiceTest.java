package movie.rate.service;

import movie.rate.dto.MovieDTO;
import movie.rate.persistence.model.Movie;
import movie.rate.persistence.model.StarRating;
import movie.rate.persistence.repository.MovieRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class MovieServiceTest {


    private MovieRepository mockMovieRepository = mock(MovieRepository.class);
    private MovieService movieService = new MovieService(mockMovieRepository);
    private Movie testMovie = new Movie();
    private Movie testMovie2 = new Movie();

    @Before
    public void init(){

        testMovie.setRating(StarRating.FOUR);
        testMovie.setReleaseDate(Date.valueOf("2017-05-12"));
        testMovie.setTitle("Dunkirk");
        testMovie.setId(1L);
        testMovie2.setRating(StarRating.FIVE);
        testMovie2.setReleaseDate(Date.valueOf("2019-05-12"));
        testMovie2.setTitle("Ransom");
        testMovie2.setId(2L);
    }

    @Test
    public void verifyGetAllMovies(){

        List<Movie> entities = Arrays.asList(testMovie, testMovie2);
        List<MovieDTO> expected = MovieDTO.populateList(entities);
        //when
        when(mockMovieRepository.findAll()).thenReturn(entities);
        //then
        List<MovieDTO> actual = movieService.getAllMovies();
        assertEquals(expected.size(), actual.size());
        assertEquals(expected.get(0).getTitle(), actual.get(0).getTitle());
        assertEquals(expected.get(1).getTitle(), actual.get(1).getTitle());
    }


}