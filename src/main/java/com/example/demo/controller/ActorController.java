package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Actor;
import com.example.demo.servic.ActorService;

@RestController
@RequestMapping("/actor")
public class ActorController {
	@Autowired
	private ActorService actorservice;

	@GetMapping("/get/{id}")
	public ResponseEntity<?> fetchActorId(@PathVariable int id) {
		Actor actor = actorservice.getActorById(id);
		return new ResponseEntity<Actor>(actor, HttpStatus.OK);
	}
	@GetMapping("/allactor")
	public ResponseEntity<?> fetchAllActor(){
		Iterable<Actor> actors=actorservice.getAllActors();
		return new ResponseEntity<>(actors,HttpStatus.OK);
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteById(@PathVariable int id){
String msg=	actorservice.deleteById(id);
		return new ResponseEntity<String>(msg,HttpStatus.OK);
	}
	@PutMapping("/updatedata")
	public ResponseEntity<String> updateActor(@RequestBody Actor actor){
	String msg=	actorservice.updateActor(actor);
		return new ResponseEntity<>(msg,HttpStatus.OK);
	}
	@PostMapping("/register")
     public ResponseEntity<String> registeractorhere(@RequestBody Actor actor)
     {
    	String actors=actorservice.registerActor(actor);
    	 return new ResponseEntity<String>(actors,HttpStatus.OK);
     }
}
