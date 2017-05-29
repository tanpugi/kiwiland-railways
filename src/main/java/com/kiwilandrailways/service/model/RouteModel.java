package com.kiwilandrailways.service.model;

public class RouteModel {
	private String id;
	private String name;
	private int distance;
		
	public RouteModel(String id, String name, int distance) {
		super();
		this.id = id;
		this.name = name;
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
	public int getDistance() {
		return distance;
	}
	public void setDistance(int distance) {
		this.distance = distance;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof RouteModel) {
			RouteModel that = (RouteModel) obj;
			return this.getId().equals(that.getId());
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return 52 + this.getId().hashCode();
	}
}
