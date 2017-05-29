package com.kiwilandrailways.service.model;

import java.util.ArrayList;
import java.util.List;

public class RouteSearchResultModel implements Comparable<Object> {

	private List<RouteModel> availableRoutes = new ArrayList<>();
	private int totalDistance = 0;
	private int numberOfStops = 0;
	
	public List<RouteModel> getAvailableRoutes() {		
		return availableRoutes;
	}

	public void addAvailableRoute(RouteModel availableRoute) {
		this.availableRoutes.add(availableRoute);
		this.totalDistance += availableRoute.getDistance();
		this.numberOfStops++;
	}
	
	public int getTotalDistance() {
		return totalDistance;
	}
	
	public int getNumberOfStops() {
		return numberOfStops;
	}
	
	@Override
	public String toString() {
		System.out.print("Routes: ");
		for (RouteModel route : availableRoutes) {
			System.out.print(route.getId() + " ");
		}
		System.out.println();
		System.out.println("Distance: " + getTotalDistance());
		System.out.println("Stops: " + getNumberOfStops());
		return "";
	}

	@Override
	public int compareTo(Object o) {
		if (o instanceof RouteSearchResultModel) {
			RouteSearchResultModel that = (RouteSearchResultModel) o;
			return this.getTotalDistance() - that.getTotalDistance();
		}
		return -1;
	}
}
