package com.marolix.traveling.Reposistry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marolix.traveling.entity.Sub_place;

public interface Sub_PlaceReposistry extends JpaRepository<Sub_place, Long> {
     
     Sub_place  findBySubplacename(String subplacename);
}
