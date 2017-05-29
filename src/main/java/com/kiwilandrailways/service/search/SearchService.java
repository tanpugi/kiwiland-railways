package com.kiwilandrailways.service.search;

import com.kiwilandrailways.service.model.RouteSearchModel;

public interface SearchService {

	RouteSearcher getRouteSearcher(RouteSearchModel criteria);
}
