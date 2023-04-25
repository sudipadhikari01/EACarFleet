package com.sudip.carfleetapplication.service;

import com.sudip.carfleetapplication.domain.CarAvailable;
import com.sudip.carfleetapplication.domain.Cars;
import com.sudip.carfleetapplication.dto.CarDTO;

public interface CarService {

    CarDTO addCar(CarDTO carDTO);

    void removeCar(String carLicense);

    CarDTO updateCar(String carLicense, CarDTO carDTO);

    Cars findCars();

    Cars findByCarType(String carType);

    Cars findByCarBrand(String brand);

    Cars findByCarPrice(double price);

    CarAvailable findCountByBrandAndTypeAvailable(String brand, String type);

}
