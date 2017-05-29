package com.kiwilandrailways.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kiwilandrailways.domain.Station;

public interface StationRepository extends JpaRepository<Station, String> {

}
