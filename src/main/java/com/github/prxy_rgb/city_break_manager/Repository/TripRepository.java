package com.github.prxy_rgb.city_break_manager.Repository;

import com.github.prxy_rgb.city_break_manager.Entity.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TripRepository extends JpaRepository<Trip, Long> {
}
