package com.example.demo.servic;

import com.example.demo.model.Actor;

public interface ActorService {
	public Actor getActorById(Integer id);
	public String registerActor(Actor actor);
	public Iterable<Actor> getAllActors();
	public String deleteById(Integer id);
	public String updateActor(Actor actor);
}
