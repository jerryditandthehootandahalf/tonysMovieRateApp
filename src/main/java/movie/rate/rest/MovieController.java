package movie.rate.rest;

import movie.rate.dto.ActorDTO;
import movie.rate.dto.MovieDTO;

import movie.rate.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/movie/")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @RequestMapping(value = "all", method = RequestMethod.GET, produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    List<MovieDTO> getAllMovies() {

        return movieService.getAllMovies();
    }

    @RequestMapping(value = "byId/{id}", method = RequestMethod.GET, produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    MovieDTO getMovieById(@PathVariable(name = "id") Long id) {

        return movieService.findMovieById(id);
    }

    @RequestMapping(value = "byTitle/{title}", method = RequestMethod.GET, produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    MovieDTO getMovieByTitle(@PathVariable(name = "title") String title) {

        return movieService.findMovieByTitle(title);
    }

    @RequestMapping(value = "cast/{title}", method = RequestMethod.GET, produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    List<ActorDTO> getMovieActors(@PathVariable(name = "title") String title) {

        return movieService.findCastByTitle(title);
    }

    @RequestMapping(value = "create", method = RequestMethod.POST, produces = {"application/json"})
    @ResponseStatus(HttpStatus.CREATED)
    public void createNewMovie(@RequestBody MovieDTO movieDTO) {

        movieService.createNewMovie(movieDTO);
    }

}
