package movie.rate.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import movie.rate.persistence.model.Actor;
import movie.rate.persistence.model.Movie;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ActorDTO {

    private String firstName;
    private String lastName;
    private String nationality;
    private Integer age;
    private List<MovieDTO> movies;

    public ActorDTO(String firstName, String lastName, String nationality, Integer age, List<MovieDTO> movies) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nationality = nationality;
        this.age = age;
        this.movies = movies;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<MovieDTO> getMovies() {
        return movies;
    }

    public void setMovies(List<MovieDTO> movies) {
        this.movies = movies;
    }

    public static ActorDTO populate(Actor entity){
        ActorDTO dto = new ActorDTO(entity.getFirstName(), entity.getLastName(),
                entity.getNationality(), entity.getAge(), getListOfMovieDtos(entity.getMovies()));

        return dto;
    }

    public static List<ActorDTO> populateList(List<Actor> entities){

        return entities.stream().map(e -> ActorDTO.populate(e)).collect(Collectors.toList());
    }

    public static ActorDTO getEmptyDto(){
        return new ActorDTO(null, null,
                null, null, null);
    }

    private static List<MovieDTO> getListOfMovieDtos(List<Movie> entities){

        List<MovieDTO> dtos = new ArrayList<>();
        entities.forEach(e -> {
            dtos.add(new MovieDTO(e.getId(), e.getTitle(), e.getRating(), e.getReleaseDate(), null));
        });
        return dtos;
    }
}
