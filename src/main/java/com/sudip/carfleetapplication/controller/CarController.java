package com.sudip.carfleetapplication.controller;

import com.sudip.carfleetapplication.domain.CarAvailable;
import com.sudip.carfleetapplication.domain.Cars;
import com.sudip.carfleetapplication.dto.CarDTO;
import com.sudip.carfleetapplication.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cars")
public class CarController {

    @Autowired
    private CarService carService;

    //get all cars
    @GetMapping
    public ResponseEntity<?> findAllCars() {
        Cars cars = carService.findCars();
        return new ResponseEntity<>(cars, HttpStatus.OK);
    }

    //find cars by its type
    @GetMapping("/type")
    public ResponseEntity<?> findCarsByType(@RequestParam(value = "carType") String carType) {
        Cars cars = carService.findByCarType(carType);
        return new ResponseEntity<>(cars, HttpStatus.OK);
    }

    // find all cars of same brand
    @GetMapping("/brand")
    public ResponseEntity<?> findByBrand(@RequestParam(value = "carBrand") String carBrand) {
        Cars cars = carService.findByCarBrand(carBrand);
        return new ResponseEntity<>(cars, HttpStatus.OK);

    }

    //find all the cars with the same price
    @GetMapping("/price")
    public ResponseEntity<?> findBySamePrice(@RequestParam(value = "carPrice") double carPrice) {
        Cars cars = carService.findByCarPrice(carPrice);
        return new ResponseEntity<>(cars, HttpStatus.OK);
    }

    //create a car
    @PostMapping
    public ResponseEntity<?> createCar(@RequestBody CarDTO carDTO) {
        CarDTO dto = carService.addCar(carDTO);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    //remove a car
    @DeleteMapping("/{id}")
    public ResponseEntity<?> removeCar(@PathVariable("id") String licensePlate) {
        carService.removeCar(licensePlate);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    //update the car
    @PutMapping("/{id}")
    public ResponseEntity<?> updateCar(@PathVariable("id") String licensePlate, @RequestBody CarDTO carDTO) {
        CarDTO dto = carService.updateCar(licensePlate, carDTO);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    //find available car of brand and type
    @GetMapping("/brandAndType")
    public ResponseEntity<?> findCountByBrandAndTypeAvailable(@RequestParam(value = "carBrand") String carBrand, @RequestParam(value = "carType") String carType) {
        CarAvailable carAvailable = carService.findCountByBrandAndTypeAvailable(carBrand, carType);
        return new ResponseEntity<>(carAvailable, HttpStatus.OK);
    }


}
