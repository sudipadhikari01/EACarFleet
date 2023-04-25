package com.sudip.carfleetapplication.repository;

import com.sudip.carfleetapplication.domain.Car;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends MongoRepository<Car, String> {

    List<Car> findByCarType(String carType);

    List<Car> findByBrand(String carBrand);

    List<Car> findByPrice(Double price);

    @Query("{'Car.brand' ::#{#carBrand},'Car.carType' ::#{#carType},'Car.isAvailable' ::true}")
    List<Car> findByCarBrandAndCarType(@Param("carBrand") String carBrand, @Param("carType") String carType);
}
