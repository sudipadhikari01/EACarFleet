package com.sudip.carfleetapplication.service.impl;

import com.sudip.carfleetapplication.domain.Car;
import com.sudip.carfleetapplication.domain.CarAvailable;
import com.sudip.carfleetapplication.domain.Cars;
import com.sudip.carfleetapplication.dto.CarDTO;
import com.sudip.carfleetapplication.exception.CarNotFoundException;
import com.sudip.carfleetapplication.repository.CarRepository;
import com.sudip.carfleetapplication.service.CarService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private ModelMapper modelMapper;

    // add the car
    @Override
    public CarDTO addCar(CarDTO carDTO) {
        Car car = modelMapper.map(carDTO, Car.class);
        Car returnCar = carRepository.insert(car);
        return modelMapper.map(returnCar, CarDTO.class);
    }

    //remove the car
    @Override
    public void removeCar(String carLicense) {
        carRepository.findById(carLicense).orElseThrow(() -> new CarNotFoundException("Car is not found with license number: " + carLicense));
        carRepository.deleteById(carLicense);

    }

    // update the car details
    @Override
    public CarDTO updateCar(String carLicense, CarDTO carDTO) {

        carRepository.findById(carLicense).orElseThrow(() -> new CarNotFoundException("Car is not found with license number: " + carLicense));
        Car car = modelMapper.map(carDTO, Car.class);
        car.setCarType(carDTO.getCarType());
        car.setBrand(carDTO.getBrand());
        car.setPrice(carDTO.getPrice());
        car.setAvailable(carDTO.isAvailable());
        Car insertedCar = carRepository.insert(car);

        return modelMapper.map(insertedCar, CarDTO.class);

    }

    //find all cars
    @Override
    public Cars findCars() {
        List<Car> carList = carRepository.findAll();
        Cars cars = new Cars(carList);
        return cars;
    }

    //find car by type
    @Override
    public Cars findByCarType(String carType) {
        List<Car> carList = carRepository.findByCarType(carType);
        Cars cars = new Cars(carList);
        return cars;
    }

    //find car by brand
    @Override
    public Cars findByCarBrand(String brand) {
        List<Car> carList = carRepository.findByBrand(brand);
        Cars cars = new Cars(carList);
        return cars;
    }

    //find cars by given price
    @Override
    public Cars findByCarPrice(double price) {
        List<Car> carList = carRepository.findByPrice(price);
        Cars cars = new Cars(carList);
        return cars;
    }

    @Override
    public CarAvailable findCountByBrandAndTypeAvailable(String brand, String type) {
        int size = carRepository.findByCarBrandAndCarType(brand, type).size();
        return new CarAvailable(size);
    }
}
