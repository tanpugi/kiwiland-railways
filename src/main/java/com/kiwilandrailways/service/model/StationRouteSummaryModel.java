package com.kiwilandrailways.service.model;

import java.util.HashMap;
import java.util.Map;

public class StationRouteSummaryModel {
	private Map<String, StationRouteModel> stationRouteMap = new HashMap<>();
	private int numberOfRoutes;
	private int numberOfStations;

	public StationRouteSummaryModel() {
	}

	public Map<String, StationRouteModel> getStationRouteMap() {
		return stationRouteMap;
	}

	public void addStationRouteEntry(String stationId, StationRouteModel stationRoute) {
		this.stationRouteMap.put(stationId, stationRoute);
	}

	public int getNumberOfStations() {
		return numberOfStations;
	}
	public void incrementNumberOfStations() {
		this.numberOfStations++;
	}

	public int getNumberOfRoutes() {
		return numberOfRoutes;
	}
	
	public void incrementNumberOfRoutes() {
		this.numberOfRoutes++;
	}
}
