package com.kiwilandrailways.service.search;

import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Map.Entry;

import org.springframework.stereotype.Component;

import com.kiwilandrailways.service.model.RouteSearchExpression;
import com.kiwilandrailways.service.model.RouteSearchModel;
import com.kiwilandrailways.service.model.RouteSearchResultModel;
import com.kiwilandrailways.service.model.StationRouteModel;

@Component
public class RouteSearcherByStop extends RouteSearcher {

	@Override
	boolean isValid(RouteSearchModel criteria) {
		if (criteria.isCheckNumberOfRoutesByStop()) {
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
			
		int maxStop = criteria.getNumberOfStops();
		RouteSearchExpression expr = criteria.getExpression();
		if (RouteSearchExpression.MAXIMUM.equals(expr)
			&& maxStop >= result.getNumberOfStops()) {
			queue.add(entry);
			isValid = true;
		}
			
		if (RouteSearchExpression.EXACTLY.equals(expr)) {
			if ((maxStop) > result.getNumberOfStops()) {
				queue.add(entry);
			} else {
				isValid = true;
			}
		}
			
		String critDestId = criteria.getDestinationStationId();
		if (isValid && sr.getOrigin().getStationId().equals(critDestId)) {
			results.add(result);
		}
		
		return isCont;
	}
}
