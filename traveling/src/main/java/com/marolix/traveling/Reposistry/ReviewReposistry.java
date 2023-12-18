package com.marolix.traveling.Reposistry;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marolix.traveling.entity.Place;
import com.marolix.traveling.entity.Reviews;

public interface ReviewReposistry extends JpaRepository<Reviews, Long> {
   List<Reviews> findByPlace(Place place);
}
