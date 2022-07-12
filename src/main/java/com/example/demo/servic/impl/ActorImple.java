package com.example.demo.servic.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.ActorNotFoundException;
import com.example.demo.model.Actor;
import com.example.demo.repository.ActorRepository;
import com.example.demo.servic.ActorService;
@Service
public class ActorImple implements ActorService {

	@Autowired
	private ActorRepository actorrepo;
	@Override
	public Actor getActorById(Integer id) {
		return  actorrepo.findById(id).orElseThrow(()-> new IllegalArgumentException());

	}
	@Override
	public String registerActor(Actor actor) {
 	Actor actors=actorrepo.save(actor);
		 return "Actor is register with  id value"+ actor.getActorid();
	}
	@Override
	public Iterable<Actor> getAllActors() {
	Iterable<Actor>	its=actorrepo.findAll();
	  List<Actor> list=(List<Actor>) its;
	  list.sort((t1,t2)->t1.getActorname().compareTo(t2.getActorname()));
	  return list;
	}
	@Override
	public String deleteById(Integer id) {
	   Optional<Actor> actors=actorrepo.findById(id);
	     if(actors.isPresent())
	     {
	    	 actorrepo.deleteById(id);
	    	 return "Actor information is deleted";
	     }else
	     {
	    	 throw new ActorNotFoundException("Actor not Found");
	     }
	}
	@Override
	public String updateActor(Actor actor) {
		Optional<Actor> actors=  actorrepo.findById(actor.getActorid());
		  if(actors.isPresent())
		  {
			  actorrepo.save(actor);
			  return "Actor information is updated";
		  }
		  else {
			  throw new ActorNotFoundException("Actor not Found");
		  }
	}

}
