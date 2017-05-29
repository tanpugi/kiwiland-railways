package com.kiwilandrailways.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Route {

	@Id
	private String id;
	private String name;
	
	@ManyToOne
	@JoinColumn(name = "origin")
	private Station origin;
	@ManyToOne
	@JoinColumn(name = "destination")
	private Station destination;
	private int distance;

	public Route() {}
	public Route(String id, String name, Station origin, Station destination, int distance) {
		super();
		this.id = id;
		this.name = name;
		this.origin = origin;
		this.destination = destination;
		this.distance = distance;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Station getOrigin() {
		return origin;
	}
	public void setOrigin(Station origin) {
		this.origin = origin;
	}
	public Station getDestination() {
		return destination;
	}
	public void setDestination(Station destination) {
		this.destination = destination;
	}
	public int getDistance() {
		return distance;
	}
	public void setDistance(int distance) {
		this.distance = distance;
	}
}
