package com.github.prxy_rgb.city_break_manager.Controller;

import com.github.prxy_rgb.city_break_manager.Entity.City;
import com.github.prxy_rgb.city_break_manager.Entity.Trip;
import com.github.prxy_rgb.city_break_manager.Service.AppService;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class AppController {

    private final AppService service;

    // Constructor Injection
    public AppController(AppService service) {
        this.service = service;
    }

    // =========================
    // CITY APIs
    // =========================

    @GetMapping("/cities")
    public ResponseEntity<List<City>> getAllCities() {
        return ResponseEntity.ok(service.getAllCities());
    }

    @GetMapping("/cities/{id}")
    public ResponseEntity<City> getCityById(
            @PathVariable Long id
    ) {
        return ResponseEntity.ok(service.getCityById(id));
    }

    @PostMapping("/cities")
    public ResponseEntity<City> createCity(
            @Valid @RequestBody City city
    ) {
        City createdCity = service.createCity(city);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(createdCity);
    }

    @PutMapping("/cities/{id}")
    public ResponseEntity<City> updateCity(
            @PathVariable Long id,
            @Valid @RequestBody City city
    ) {
        City updatedCity = service.updateCity(id, city);

        return ResponseEntity.ok(updatedCity);
    }

    @DeleteMapping("/cities/{id}")
    public ResponseEntity<Void> deleteCity(
            @PathVariable Long id
    ) {
        service.deleteCity(id);

        return ResponseEntity.noContent().build();
    }


    // =========================
    // TRIP APIs
    // =========================

    @GetMapping("/trips")
    public ResponseEntity<List<Trip>> getAllTrips() {
        return ResponseEntity.ok(service.getAllTrips());
    }

    @GetMapping("/trips/{id}")
    public ResponseEntity<Trip> getTripById(
            @PathVariable Long id
    ) {
        return ResponseEntity.ok(service.getTripById(id));
    }

    @PostMapping("/trips")
    public ResponseEntity<Trip> createTrip(
            @Valid @RequestBody Trip trip
    ) {
        Trip createdTrip = service.createTrip(trip);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(createdTrip);
    }

    @PutMapping("/trips/{id}")
    public ResponseEntity<Trip> updateTrip(
            @PathVariable Long id,
            @Valid @RequestBody Trip trip
    ) {
        Trip updatedTrip = service.updateTrip(id, trip);

        return ResponseEntity.ok(updatedTrip);
    }

    @DeleteMapping("/trips/{id}")
    public ResponseEntity<Void> deleteTrip(
            @PathVariable Long id
    ) {
        service.deleteTrip(id);

        return ResponseEntity.noContent().build();
    }
}