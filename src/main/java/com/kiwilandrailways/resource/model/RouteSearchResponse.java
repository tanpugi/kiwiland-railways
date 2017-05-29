package com.kiwilandrailways.resource.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.kiwilandrailways.service.model.RouteModel;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public class RouteSearchResponse {
	private List<RouteModel> availableRoutes = new ArrayList<>();
	private int totalDistance = 0;
	private int numberOfStops = 0;

	public List<RouteModel> getAvailableRoutes() {
		return availableRoutes;
	}
	public void setAvailableRoutes(List<RouteModel> availableRoutes) {
		this.availableRoutes = availableRoutes;
	}
	public int getTotalDistance() {
		return totalDistance;
	}
	public void setTotalDistance(int totalDistance) {
		this.totalDistance = totalDistance;
	}
	public int getNumberOfStops() {
		return numberOfStops;
	}
	public void setNumberOfStops(int numberOfStops) {
		this.numberOfStops = numberOfStops;
	}
}
