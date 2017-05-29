package com.kiwilandrailways.resource;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.kiwilandrailways.resource.model.RouteSearchRequest;
import com.kiwilandrailways.resource.model.RouteSearchResponse;
import com.kiwilandrailways.service.RouteService;
import com.kiwilandrailways.service.model.RouteSearchModel;
import com.kiwilandrailways.service.model.RouteSearchResultModel;

@RestController
@RequestMapping("/route")
public class RouteResource {
	@Autowired
	private RouteService routeService;
	
	@ResponseBody
	@RequestMapping(method=RequestMethod.GET, value="/search")
	public Object search(RouteSearchRequest r) {
		RouteSearchModel criteria = new RouteSearchModel();
		criteria.setOriginStationId(r.getOriginStationId());
		criteria.setDestinationStationId(r.getDestinationStationId());
		criteria.setNumberOfStops(r.getNumberOfStops());
		criteria.setDistance(r.getDistance());
		
		criteria.setCheckShortestRoute(r.isCheckShortestRoute());
		criteria.setCheckRouteExists(r.isCheckRouteExists());
		criteria.setCheckNumberOfRoutesByStop(r.isCheckNumberOfRoutesByStop());
		criteria.setCheckNumberOfRoutesByDistance(r.isCheckNumberOfRoutesByDistance());
		
		String stopIds = r.getStopStationIds();
		if (stopIds != null && stopIds.length() > 0) {
			String[] sids = stopIds.split("");
			for (String sid : sids) {
				criteria.addStopStationId(sid);
			}
		}
		
		List<RouteSearchResultModel> results = routeService.search(criteria);
		Collections.sort(results);
		
		List<RouteSearchResponse> responses = new ArrayList<>();
		for (RouteSearchResultModel res : results) {
			RouteSearchResponse response = new RouteSearchResponse();
			response.setAvailableRoutes(res.getAvailableRoutes());
			response.setNumberOfStops(res.getNumberOfStops());
			response.setTotalDistance(res.getTotalDistance());
			responses.add(response);
		}

	    return responses.size() > 0 ? responses : "{ msg: 'NO SUCH ROUTE' }";
	}
}
