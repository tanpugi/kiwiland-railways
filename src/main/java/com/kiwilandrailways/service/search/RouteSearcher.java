package com.kiwilandrailways.service.search;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Map.Entry;

import com.kiwilandrailways.service.model.RouteModel;
import com.kiwilandrailways.service.model.RouteSearchModel;
import com.kiwilandrailways.service.model.RouteSearchResultModel;
import com.kiwilandrailways.service.model.StationRouteModel;

public abstract class RouteSearcher {

	abstract boolean isValid(RouteSearchModel criteria);

	public List<RouteSearchResultModel> searchBFS(
		Map<String, StationRouteModel> srMap, RouteSearchModel criteria) {
		List<RouteSearchResultModel> results = new ArrayList<RouteSearchResultModel>();
		
		RouteSearchResultModel srResultRoot = new RouteSearchResultModel();
		StationRouteModel srRoot = srMap.get(criteria.getOriginStationId());
		Entry<RouteSearchResultModel, StationRouteModel> entryRoot =
			new AbstractMap.SimpleEntry<RouteSearchResultModel, StationRouteModel>(srResultRoot, srRoot);
		Queue<Map.Entry<RouteSearchResultModel, StationRouteModel>> queue = new LinkedList<>();
		queue.add(entryRoot);
		
		Map<String, Object> attrs = new HashMap<>();
		while (!queue.isEmpty()) {
			Entry<RouteSearchResultModel, StationRouteModel> current = queue.remove();
			Map<RouteModel, StationRouteModel> srRoutes = current.getValue().getDestinations();
			RouteSearchResultModel currentResult = current.getKey();
			
			for (Entry<RouteModel, StationRouteModel> entry : srRoutes.entrySet()) {
				RouteModel route = entry.getKey();
				StationRouteModel sr = entry.getValue();

				RouteSearchResultModel result = copySearchResult(currentResult);
				Entry<RouteSearchResultModel, StationRouteModel> entryChild =
					new AbstractMap.SimpleEntry<RouteSearchResultModel, StationRouteModel>(result, sr);
				
				result.addAvailableRoute(route);
				
				if (!processBFS(attrs, criteria, sr, result, results, queue, entryChild)) {
					break;
				} else {
					continue;
				}
				
			}
		}

		return results;
		
	}
	
	protected boolean processBFS(Map<String, Object> attrs,
		RouteSearchModel criteria, StationRouteModel sr,
		RouteSearchResultModel result, List<RouteSearchResultModel> results,
		Queue<Map.Entry<RouteSearchResultModel, StationRouteModel>> queue,
		Entry<RouteSearchResultModel, StationRouteModel> entry) {
		return true;
	}

	private RouteSearchResultModel copySearchResult(RouteSearchResultModel resultFrom) {
		RouteSearchResultModel result = new RouteSearchResultModel();
		List<RouteModel> routes = resultFrom.getAvailableRoutes();
		for (RouteModel route : routes) {
			result.addAvailableRoute(route);
		}
		return result;
	}


}
