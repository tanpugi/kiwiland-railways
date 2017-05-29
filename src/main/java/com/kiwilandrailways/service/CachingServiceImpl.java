package com.kiwilandrailways.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.kiwilandrailways.domain.Route;
import com.kiwilandrailways.domain.Station;
import com.kiwilandrailways.domain.repository.RouteRepository;
import com.kiwilandrailways.domain.repository.StationRepository;
import com.kiwilandrailways.service.model.RouteModel;
import com.kiwilandrailways.service.model.StationModel;
import com.kiwilandrailways.service.model.StationRouteModel;
import com.kiwilandrailways.service.model.StationRouteSummaryModel;

@Service
public class CachingServiceImpl implements CachingService {

	@Autowired
	private RouteRepository routeRepository;
	@Autowired
	private StationRepository stationRepository;
	
	@Cacheable("stationRouteSummary")
	public StationRouteSummaryModel retrieveStationRouteSummary() {
		StationRouteSummaryModel stationRouteSummary = new StationRouteSummaryModel();
		List<Station> stations = stationRepository.findAll();
		for (Station station : stations) {
			StationModel sModel = new StationModel(station.getId(), station.getName());
			StationRouteModel srModel = new StationRouteModel(sModel);
			stationRouteSummary.addStationRouteEntry(station.getId(), srModel);
			stationRouteSummary.incrementNumberOfStations();
		}
		
		List<Route> routes = routeRepository.findAll();
		for (Route route : routes) {
			Map<String, StationRouteModel> stationRouteMap = stationRouteSummary.getStationRouteMap();
			String sDestId = route.getDestination().getId();
			StationRouteModel srDest = stationRouteMap.get(sDestId); 
		
			String sOrigId = route.getOrigin().getId();
			StationRouteModel srOrig = stationRouteMap.get(sOrigId);
			
			RouteModel r = new RouteModel(route.getId(), route.getName(), route.getDistance());
			srOrig.addDestination(r, srDest);
			
			stationRouteSummary.incrementNumberOfRoutes();
		}
		return stationRouteSummary;
	}
}
