package com.kiwilandrailways.service.search;

import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Map.Entry;

import org.springframework.stereotype.Component;

import com.kiwilandrailways.service.model.RouteSearchModel;
import com.kiwilandrailways.service.model.RouteSearchResultModel;
import com.kiwilandrailways.service.model.StationRouteModel;

@Component
public class RouteSearcherByShortestRoute extends RouteSearcher {

	private static final String PREVIOUS_MIN_DISTANCE = "previousMinDistance";

	@Override
	boolean isValid(RouteSearchModel criteria) {
		if (criteria.isCheckShortestRoute()) {
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
		
		if (!attrs.containsKey(PREVIOUS_MIN_DISTANCE)) {
			attrs.put(PREVIOUS_MIN_DISTANCE, 999_999_999);
		}
		
		int previousMinDistance = (Integer) attrs.get(PREVIOUS_MIN_DISTANCE);
							
		String critDestId = criteria.getDestinationStationId();
		if (sr.getOrigin().getStationId().equals(critDestId)) {
			if (result.getTotalDistance() < previousMinDistance) {
				attrs.put(PREVIOUS_MIN_DISTANCE, result.getTotalDistance());
				
				results.clear();
				results.add(result);
				isCont = false;
			}
		}
			
		if (previousMinDistance > result.getTotalDistance()) {
			queue.add(entry);	
		}
		
		return isCont;
	}
}
