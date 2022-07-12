package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name = "actor_tab")
public class Actor {
	@Id
	@GeneratedValue
	private Integer actorid;
	private String actorname;
	private String category;
	private Long mobileNo;
}
