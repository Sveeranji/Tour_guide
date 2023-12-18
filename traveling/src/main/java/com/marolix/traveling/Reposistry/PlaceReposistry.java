package com.marolix.traveling.Reposistry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marolix.traveling.entity.Place;

public interface PlaceReposistry extends JpaRepository<Place, Long>{

	Place findByName(String name);
}
