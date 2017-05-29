package com.kiwilandrailways.service;

import java.util.List;

import com.kiwilandrailways.service.model.RouteSearchModel;
import com.kiwilandrailways.service.model.RouteSearchResultModel;

public interface RouteService {
	List<RouteSearchResultModel> search(RouteSearchModel criteria);
}
