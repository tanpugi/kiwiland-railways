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
public class RouteSearcherByRoute extends RouteSearcher {

	@Override
	boolean isValid(RouteSearchModel criteria) {
		if (criteria.isCheckRouteExists()) {
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
		boolean isSkip = false;

		if (criteria.getStopStationIds().size() > 0) {
			String stopId = criteria.getStopStationIds().peekFirst();
			if (stopId.equals(sr.getOrigin().getStationId())) {
				criteria.getStopStationIds().removeFirst();
				queue.add(entry);
				isCont = false;
			} else {
				isSkip = true;
			}
		}
			
		if (!isSkip) {
			String critDestId = criteria.getDestinationStationId();
			if (sr.getOrigin().getStationId().equals(critDestId)) {
				results.add(result);
			}
		}
		
		return isCont;
	}
}
