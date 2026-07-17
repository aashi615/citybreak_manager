package com.github.prxy_rgb.city_break_manager.Service;

import com.github.prxy_rgb.city_break_manager.Entity.City;
import com.github.prxy_rgb.city_break_manager.Entity.Trip;
import com.github.prxy_rgb.city_break_manager.Repository.CityRepository;
import com.github.prxy_rgb.city_break_manager.Repository.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppService {
    @Autowired
    private CityRepository cityRepository;
    @Autowired
    private TripRepository tripRepository;

    public List<City> getAllCities() {
        return cityRepository.findAll();
    }

    public List<Trip> getAllTrips() {
        return tripRepository.findAll();
    }

    public City getCityById(Long id) {
        return cityRepository.findById(id).orElseThrow(() -> new RuntimeException("City not found"));
    }

    public Trip getTripById(Long id) {
        return tripRepository.findById(id).orElseThrow(() -> new RuntimeException("Trip not found"));
    }

    public City createCity(City city) {
        return cityRepository.save(city);
    }

    public Trip createTrip(Trip trip) {
        return tripRepository.save(trip);
    }

    public City updateCity(Long id, City city) {
        return cityRepository.findById(id).map(existingCity -> {
            existingCity.setName(city.getName());
            existingCity.setCountry(city.getCountry());
            existingCity.setDetails(city.getDetails());
            return cityRepository.save(existingCity);
        }).orElseThrow(() -> new RuntimeException("City not found"));
    }

    public Trip updateTrip(Long id, Trip trip) {
        return tripRepository.findById(id).map(existingTrip -> {
            existingTrip.setCity(trip.getCity());
            existingTrip.setStartDate(trip.getStartDate());
            existingTrip.setEndDate(trip.getEndDate());
            return tripRepository.save(existingTrip);
        }).orElseThrow(() -> new RuntimeException("Trip not found"));
    }

    public void deleteCity(Long id) {
        cityRepository.deleteById(id);
    }

    public void deleteTrip(Long id) {
        tripRepository.deleteById(id);
    }
}
