package com.kiwilandrailways.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kiwilandrailways.service.model.RouteSearchModel;
import com.kiwilandrailways.service.model.RouteSearchResultModel;
import com.kiwilandrailways.service.model.StationRouteModel;
import com.kiwilandrailways.service.model.StationRouteSummaryModel;
import com.kiwilandrailways.service.search.RouteSearcher;
import com.kiwilandrailways.service.search.SearchService;

@Service
public class RouteServiceImpl implements RouteService {
	@Autowired
	CachingService cacheService;
	@Autowired
	SearchService searchService;
	
	public List<RouteSearchResultModel> search(RouteSearchModel criteria) {
		StationRouteSummaryModel srSummary = cacheService.retrieveStationRouteSummary();
		Map<String, StationRouteModel> srMap = srSummary.getStationRouteMap();
		RouteSearcher searcher = searchService.getRouteSearcher(criteria);
		return searcher.searchBFS(srMap, criteria);
	}
}
