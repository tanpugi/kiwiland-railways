package com.kiwilandrailways.service.search;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kiwilandrailways.service.model.RouteSearchModel;

@Service
public class SearchServiceImpl implements SearchService {

	@Autowired
	private List<RouteSearcher> routeSearchers;
	
	public RouteSearcher getRouteSearcher(RouteSearchModel criteria) {
		for (RouteSearcher routeSearcher : routeSearchers) {
			if (routeSearcher.isValid(criteria)) {
				return routeSearcher;
			}
		}
		return new RouteSearcherByDummy();
	}
}
