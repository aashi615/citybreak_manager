package com.github.prxy_rgb.city_break_manager.Controller;

import com.github.prxy_rgb.city_break_manager.Service.AppService;
import com.github.prxy_rgb.city_break_manager.Entity.City;
import com.github.prxy_rgb.city_break_manager.Entity.Trip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/")
public class AppController {
    @Autowired
    private AppService service;

    @GetMapping("cities")
    public List<City> getAllCities() {
        return service.getAllCities();
    }

    @GetMapping("cities/{id}")
    public City getCityById(@PathVariable Long id) {
        return service.getCityById(id);
    }

    @PostMapping("cities")
    public ResponseEntity<City> createCity(@RequestBody City city) {
        return ResponseEntity.ok(service.createCity(city));
    }

    @PutMapping("cities/{id}")
    public ResponseEntity<City> updateCity(@PathVariable Long id, @RequestBody City city) {
        return ResponseEntity.ok(service.updateCity(id, city));
    }

    @DeleteMapping("cities/{id}")
    public void deleteCity(@PathVariable Long id) {
        service.deleteCity(id);
    }

    @GetMapping("trips")
    public List<Trip> getAllTrips() {
        return service.getAllTrips();
    }

    @GetMapping("trips/{id}")
    public Trip getTripById(@PathVariable Long id) {
        return service.getTripById(id);
    }

    @PostMapping("trips")
    public ResponseEntity<Trip> createTrip(@RequestBody Trip trip) {
        return ResponseEntity.ok(service.createTrip(trip));
    }

    @PutMapping("trips/{id}")
    public ResponseEntity<Trip> updateTrip(@PathVariable Long id, @RequestBody Trip trip) {
        return ResponseEntity.ok(service.updateTrip(id, trip));
    }

    @DeleteMapping("trips/{id}")
    public void deleteTrip(@PathVariable Long id) {
        service.deleteTrip(id);
    }
}
