package com.kiwilandrailways;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;

import com.kiwilandrailways.domain.Route;
import com.kiwilandrailways.domain.Station;
import com.kiwilandrailways.domain.repository.RouteRepository;
import com.kiwilandrailways.domain.repository.StationRepository;

@Component
public class ApplicationInitializer {
	@Autowired
	private RouteRepository routeRepository;
	@Autowired
	private StationRepository stationRepository;
	
	public void init(Map<String, String> argMap) throws IOException {
		String routesInput = argMap.get("-DroutesInput");

		initDatabase(routesInput);
	}
	
	private void initDatabase(String routesInput) throws IOException {
		Set<String> routes = retrieveRoutes(routesInput);
		for (String r : routes) {
			String[] rts = r.split("");
			int distance = Integer.valueOf(rts[2]);
			
			Station origin = new Station(rts[0], rts[0]);
			Station destination = new Station(rts[1], rts[1]);
			Route route = new Route(r, r, origin, destination, distance);

			stationRepository.save(origin);
			stationRepository.save(destination);
			routeRepository.save(route);
		}
	}

	private Set<String> retrieveRoutes(String rInput) throws IOException {
		String data = "";
		Set<String> routes = new HashSet<String>();
		if (rInput != null) {
			File rInputFile = new File(rInput);
			if (rInputFile.exists()) {
				BufferedReader reader = new BufferedReader(new FileReader(rInputFile));
				String fdata;
				while ((fdata = reader.readLine()) != null) {
					data += fdata + " ";
				}
				System.out.println(" data: **************** " +data);
				reader.close();
			}
		}
		
		if (data.length() == 0){
			ClassPathResource cpr = new ClassPathResource("data/routes.txt");
			byte[] bdata = FileCopyUtils.copyToByteArray(cpr.getInputStream());
		
			data = new String(bdata, StandardCharsets.UTF_8);
		}
		
		data = data.replaceAll(" ", "-").replaceAll("[^\\w\\s]", "-");
		String[] rts = data.split("-");
		for (String rt : rts) {
			if (rt.length() > 0) {
				routes.add(rt);
			}
		}
		
		return routes;
	}
}
