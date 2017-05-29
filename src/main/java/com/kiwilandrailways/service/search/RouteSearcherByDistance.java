package com.kiwilandrailways.service.search;

import java.util.List;
import java.util.Map;
import java.util.Queue;

import org.springframework.stereotype.Component;

import java.util.Map.Entry;

import com.kiwilandrailways.service.model.RouteSearchModel;
import com.kiwilandrailways.service.model.RouteSearchResultModel;
import com.kiwilandrailways.service.model.StationRouteModel;

@Component
public class RouteSearcherByDistance extends RouteSearcher {

	@Override
	boolean isValid(RouteSearchModel criteria) {
		if (criteria.isCheckNumberOfRoutesByDistance()) {
			return true;
		}
		return false;
	}

	@Override
	protected boolean processBFS(Map<String, Object> attrs,
		RouteSearchModel criteria, StationRouteModel sr,
		RouteSearchResultModel result, List<RouteSearchResultModel> results,
		Queue<Map.Entry<RouteSearchResultModel, StationRouteModel>> queue,
		Entry<RouteSearchResultModel, StationRouteModel> entry) {
		boolean isCont = true;
		boolean isValid = false;
			
		int maxDistance = criteria.getDistance();
		if (maxDistance > result.getTotalDistance()) {
			queue.add(entry);
			isValid = true;
		}
			
		String critDestId = criteria.getDestinationStationId();
		if (isValid && sr.getOrigin().getStationId().equals(critDestId)) {
			results.add(result);
		}
		
		return isCont;
	}
}
