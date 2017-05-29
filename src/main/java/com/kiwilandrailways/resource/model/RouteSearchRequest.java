package com.kiwilandrailways.resource.model;

public class RouteSearchRequest {
	private String originStationId;
	private String destinationStationId;
	
	private String stopStationIds;
	
	private String expression;
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
	public String getStopStationIds() {
		return stopStationIds;
	}
	public void setStopStationIds(String stopStationIds) {
		this.stopStationIds = stopStationIds;
	}
	public String getExpression() {
		return expression;
	}
	public void setExpression(String expression) {
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
