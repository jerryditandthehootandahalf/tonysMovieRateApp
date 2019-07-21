package movie.rate.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import movie.rate.persistence.model.Actor;
import movie.rate.persistence.model.Movie;
import movie.rate.persistence.model.StarRating;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class MovieDTO {

    private Long id;
    private String title;
    private StarRating rating;
    private Date releaseDate;
    private List<ActorDTO> cast;

    public MovieDTO(Long id, String title, StarRating rating, Date releaseDate, List<ActorDTO> cast) {
        this.id = id;
        this.title = title;
        this.rating = rating;
        this.releaseDate = releaseDate;
        this.cast = cast;
    }

    public MovieDTO() {
    }

    public static MovieDTO populate(Movie entity) {

        return new MovieDTO(entity.getId(), entity.getTitle(),
                entity.getRating(), entity.getReleaseDate(), getListOfActorDtos(entity.getCast()));
    }

    public static List<MovieDTO> populateList(List<Movie> entities) {

        if (!(entities == null) && entities.size() > 0) {

            return entities.stream().map(e -> populate(e)).collect(Collectors.toList());
        }

        return Arrays.asList(getEmptyDto());
    }

    public static MovieDTO getEmptyDto() {
        return new MovieDTO(null, null,
                null, null, null);
    }


    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public StarRating getRating() {
        return rating;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public List<ActorDTO> getCast() {
        return cast;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setRating(StarRating rating) {
        this.rating = rating;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setCast(List<ActorDTO> cast) {
        this.cast = cast;
    }

    private static List<ActorDTO> getListOfActorDtos(List<Actor> entities){

        List<ActorDTO> dtos = new ArrayList<>();
        entities.forEach(e ->{
            dtos.add(new ActorDTO(e.getFirstName(), e.getLastName(),
                    e.getNationality(), e.getAge(), null));
        });
        return dtos;
    }
}
