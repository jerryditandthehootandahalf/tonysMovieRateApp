package movie.rate.rest;

import movie.rate.dto.ActorDTO;
import movie.rate.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * A controller to handle requests for movie actors.
 */

@Controller
@RequestMapping("/actor/")
public class ActorController {

    @Autowired
    private ActorService actorService;

    @RequestMapping(value = "byId/{id}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public ActorDTO getActorById(@PathVariable(name = "id")Long id){

      return actorService.findById(id);
    }

    @RequestMapping(value = "all", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<ActorDTO> getAllActors(){

        return actorService.getAllActors();
    }
}
