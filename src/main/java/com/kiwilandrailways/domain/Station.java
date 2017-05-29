package com.kiwilandrailways.domain;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Station {

	@Id
	private String id;
	private String name;

	@OneToMany(mappedBy="origin", fetch = FetchType.LAZY)
	private Set<Route> origins;
	@OneToMany(mappedBy="destination", fetch = FetchType.LAZY)
	private Set<Route> destinations;
	
	public Station() {}
	public Station(String id, String name) {
		super();
		this.id = id;
		this.name = name;
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

	public Set<Route> getOrigins() {
		return origins;
	}

	public void setOrigins(Set<Route> origins) {
		this.origins = origins;
	}

	public Set<Route> getDestinations() {
		return destinations;
	}

	public void setDestinations(Set<Route> destinations) {
		this.destinations = destinations;
	}
}
