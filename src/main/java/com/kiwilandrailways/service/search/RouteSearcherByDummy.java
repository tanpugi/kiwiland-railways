package com.kiwilandrailways.service.search;

import com.kiwilandrailways.service.model.RouteSearchModel;

public class RouteSearcherByDummy extends RouteSearcher {

	@Override
	boolean isValid(RouteSearchModel criteria) {
		return true;
	}

}
