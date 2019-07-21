package movie.rate.service;

import com.google.common.collect.Lists;
import movie.rate.dto.ActorDTO;
import movie.rate.persistence.model.Actor;
import movie.rate.persistence.repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActorService {

    @Autowired
    private ActorRepository actorRepository;

    public ActorDTO findById(Long id){

        Optional<Actor> actor = actorRepository.findById(id);
        return actor.isPresent() ? ActorDTO.populate(actor.get()) : ActorDTO.getEmptyDto();
    }

    public List<ActorDTO> getAllActors(){

        return ActorDTO.populateList(Lists.newArrayList(actorRepository.findAll()));
    }
}
