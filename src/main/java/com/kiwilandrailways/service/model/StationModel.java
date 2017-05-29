package com.kiwilandrailways.service.model;

public class StationModel {

	private String stationId;
	private String name;

	public StationModel(String stationId, String name) {
		super();
		this.stationId = stationId;
		this.name = name;
	}
	
	public String getStationId() {
		return stationId;
	}
	public void setStationId(String stationId) {
		this.stationId = stationId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof StationModel) {
			StationModel that = (StationModel) obj;
			return this.stationId.equals(that.stationId);
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return 51 + this.stationId.hashCode();
	}
}
