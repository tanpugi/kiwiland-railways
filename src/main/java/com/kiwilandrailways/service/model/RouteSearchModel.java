package com.kiwilandrailways.service.model;

import java.util.LinkedList;

public class RouteSearchModel {
	private String originStationId;
	private String destinationStationId;
	
	private LinkedList<String> stopStationIds = new LinkedList<>();
	
	private RouteSearchExpression expression;
	private int numberOfStops;
	private int distance;
	
	private boolean checkRouteExists;
	private boolean checkNumberOfRoutesByStop;
	private boolean checkNumberOfRoutesByDistance;
	private boolean checkShortestRoute;

	public String getOriginStationId() {
		return originStationId;
	}
	public void setOriginStationId(String originStationId) {
		this.originStationId = originStationId;
	}
	public String getDestinationStationId() {
		return destinationStationId;
	}
	public void setDestinationStationId(String destinationStationId) {
		this.destinationStationId = destinationStationId;
	}
	public LinkedList<String> getStopStationIds() {
		return stopStationIds;
	}
	public void addStopStationId(String stopStationId) {
		this.stopStationIds.add(stopStationId);
	}
	
	
	public RouteSearchExpression getExpression() {
		return expression;
	}
	public void setExpression(RouteSearchExpression expression) {
		this.expression = expression;
	}
	public int getNumberOfStops() {
		return numberOfStops;
	}
	public void setNumberOfStops(int numberOfStops) {
		this.numberOfStops = numberOfStops;
	}
	public int getDistance() {
		return distance;
	}
	public void setDistance(int distance) {
		this.distance = distance;
	}

	public boolean isCheckNumberOfRoutesByStop() {
		return checkNumberOfRoutesByStop;
	}
	public void setCheckNumberOfRoutesByStop(boolean checkNumberOfRoutesByStop) {
		this.checkNumberOfRoutesByStop = checkNumberOfRoutesByStop;
	}
	public boolean isCheckNumberOfRoutesByDistance() {
		return checkNumberOfRoutesByDistance;
	}
	public void setCheckNumberOfRoutesByDistance(boolean checkNumberOfRoutesByDistance) {
		this.checkNumberOfRoutesByDistance = checkNumberOfRoutesByDistance;
	}
	public boolean isCheckShortestRoute() {
		return checkShortestRoute;
	}
	public void setCheckShortestRoute(boolean checkShortestRoute) {
		this.checkShortestRoute = checkShortestRoute;
	}
	public boolean isCheckRouteExists() {
		return checkRouteExists;
	}
	public void setCheckRouteExists(boolean checkRouteExists) {
		this.checkRouteExists = checkRouteExists;
	}
}
