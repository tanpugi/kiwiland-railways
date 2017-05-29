package com.kiwilandrailways.service.model;

import java.util.HashMap;
import java.util.Map;

public class StationRouteModel {

	private StationModel origin;
	private Map<RouteModel, StationRouteModel> destinations = new HashMap<>();

	public StationRouteModel(StationModel origin) {
		super();
		this.origin = origin;
	}

	public StationModel getOrigin() {
		return origin;
	}
	public void setOrigin(StationModel origin) {
		this.origin = origin;
	}
	public Map<RouteModel, StationRouteModel> getDestinations() {
		return destinations;
	}
	public StationRouteModel getDestination(RouteModel route) {
		return getDestinations().get(route);
	}
	public void addDestination(RouteModel route, StationRouteModel destination) {
		this.getDestinations().put(route, destination);
	}
}
